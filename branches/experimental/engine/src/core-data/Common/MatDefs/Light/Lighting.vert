//#import "Common/ShaderLib/Skinning.glsllib"
#import "Common/ShaderLib/Lighting.glsllib"

uniform mat4 g_WorldViewProjectionMatrix;
uniform mat4 g_WorldViewMatrix;
uniform mat3 g_NormalMatrix;
uniform mat4 g_ViewMatrix;

uniform vec4 m_Ambient;
uniform vec4 m_Diffuse;
uniform vec4 m_Specular;
uniform float m_Shininess;

varying vec2 texCoord;
#ifdef SEPARATE_TEXCOORD
  varying vec2 texCoord2;
  attribute vec2 inTexCoord2;
#endif

varying vec3 AmbientSum;
varying vec4 DiffuseSum;
varying vec3 SpecularSum;

attribute vec3 inPosition;
attribute vec2 inTexCoord;
attribute vec3 inNormal;

varying vec3 lightVec;
//varying vec4 spotVec;

#ifdef VERTEX_COLOR
  attribute vec4 inColor;
#endif

#ifndef VERTEX_LIGHTING
  attribute vec4 inTangent;

  #ifndef NORMALMAP
    varying vec3 vNormal;
  #endif
  //varying vec3 vPosition;
  varying vec3 vViewDir;
  varying vec4 vLightDir;
#else
  varying vec2 vertexLightValues;
  uniform vec4 g_LightDirection;
#endif

#ifdef USE_REFLECTION
    uniform vec3 g_CameraPosition;
    uniform mat4 g_WorldMatrix;

    uniform vec3 m_FresnelParams;
    varying vec4 refVec;


    /**
     * Input:
     * attribute inPosition
     * attribute inNormal
     * uniform g_WorldMatrix
     * uniform g_CameraPosition
     *
     * Output:
     * varying refVec
     */
    void computeRef(in vec4 modelSpacePos){
        vec3 worldPos = (g_WorldMatrix * modelSpacePos).xyz;

        vec3 I = normalize( g_CameraPosition - worldPos  ).xyz;
        vec3 N = normalize( (g_WorldMatrix * vec4(inNormal, 0.0)).xyz );

        refVec.xyz = reflect(I, N);
        refVec.w   = m_FresnelParams.x + m_FresnelParams.y * pow(1.0 + dot(I, N), m_FresnelParams.z);
    }
#endif

void main(){
   vec4 modelSpacePos = vec4(inPosition, 1.0);
   vec3 modelSpaceNorm = inNormal;
   
   #ifndef VERTEX_LIGHTING
        vec3 modelSpaceTan  = inTangent.xyz;
   #endif

   #ifdef NUM_BONES
        #ifndef VERTEX_LIGHTING
            Skinning_Compute(modelSpacePos, modelSpaceNorm, modelSpaceTan);
        #else
            Skinning_Compute(modelSpacePos, modelSpaceNorm);
        #endif
   #endif

   gl_Position = g_WorldViewProjectionMatrix * modelSpacePos;
   texCoord = inTexCoord;
   #ifdef SEPARATE_TEXCOORD
      texCoord2 = inTexCoord2;
   #endif

   vec3 wvPosition = (g_WorldViewMatrix * modelSpacePos).xyz;
   vec3 wvNormal  = normalize(g_NormalMatrix * modelSpaceNorm);
   vec3 viewDir = normalize(-wvPosition);

   vec4 wvLightPos = (g_ViewMatrix * vec4(g_LightPosition.xyz, clamp(g_LightColor.w, 0.0, 1.0)));
   wvLightPos.w = g_LightPosition.w;
   vec4 lightColor = g_LightColor;

   #if defined(NORMALMAP) && !defined(VERTEX_LIGHTING)
     vec3 wvTangent = normalize(g_NormalMatrix * modelSpaceTan);
     vec3 wvBinormal = cross(wvNormal, wvTangent);

     mat3 tbnMat = mat3(wvTangent, wvBinormal * -inTangent.w,wvNormal);
     
     vViewDir  = -wvPosition * tbnMat;
     vLightDir = Lighting_Direction(wvPosition, lightColor, wvLightPos);
     vLightDir.xyz = (vLightDir.xyz * tbnMat).xyz;
   #elif !defined(VERTEX_LIGHTING)
     vNormal = wvNormal;

     //vPosition = wvPosition;
     vViewDir = viewDir;

     vLightDir = Lighting_Direction(wvPosition, lightColor, wvLightPos);

     #ifdef V_TANGENT
        vNormal = normalize(g_NormalMatrix * inTangent.xyz);
        vNormal = -cross(cross(vLightDir.xyz, vNormal), vNormal);
     #endif
   #endif

   //computing spot direction in view space and unpacking spotlight cos
   lightVec = (g_ViewMatrix * vec4(g_LightDirection.xyz, 0.0) ).xyz;

   lightColor.w = 1.0;
   #ifdef MATERIAL_COLORS
      AmbientSum  = (m_Ambient  * g_AmbientLightColor).rgb;
      DiffuseSum  =  m_Diffuse  * lightColor;
      SpecularSum = (m_Specular * lightColor).rgb;
    #else
      AmbientSum  = vec3(0.2, 0.2, 0.2) * g_AmbientLightColor.rgb; // Default: ambient color is dark gray
      DiffuseSum  = lightColor;
      SpecularSum = vec3(0.0);
    #endif

    #ifdef VERTEX_COLOR
      AmbientSum *= inColor.rgb;
      DiffuseSum *= inColor;
    #endif

    #ifdef VERTEX_LIGHTING
       vertexLightValues = computeLighting(wvPosition, wvNormal, viewDir, wvLightPos);
    #endif

    #ifdef USE_REFLECTION
        computeRef(modelSpacePos);
    #endif 
}