/**
 * common_float_or_param_type.java This file was generated by XMLSpy 2006sp2
 * Enterprise Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION. Refer to the XMLSpy
 * Documentation for further details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

public class common_float_or_param_type extends
        com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public common_float_or_param_type(common_float_or_param_type node) {
        super(node);
    }

    public common_float_or_param_type(org.w3c.dom.Node node) {
        super(node);
    }

    public common_float_or_param_type(org.w3c.dom.Document doc) {
        super(doc);
    }

    public common_float_or_param_type(
            com.jmex.model.collada.xml.Document doc, String namespaceURI,
            String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "float"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "float", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
            new floatType(tmpNode).adjustPrefix();
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "param"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "param", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
            new paramType2(tmpNode).adjustPrefix();
        }
    }

    public static int getfloat2MinCount() {
        return 1;
    }

    public static int getfloat2MaxCount() {
        return 1;
    }

    public int getfloat2Count() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "float");
    }

    public boolean hasfloat2() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "float");
    }

    public floatType newfloat2() {
        return new floatType(domNode.getOwnerDocument().createElementNS(
                "http://www.collada.org/2005/11/COLLADASchema", "float"));
    }

    public floatType getfloat2At(int index) throws Exception {
        return new floatType(
                dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "float", index)));
    }

    public org.w3c.dom.Node getStartingfloat2Cursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "float");
    }

    public org.w3c.dom.Node getAdvancedfloat2Cursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "float",
                curNode);
    }

    public floatType getfloat2ValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new floatType(dereference(curNode));
    }

    public floatType getfloat2() throws Exception {
        return getfloat2At(0);
    }

    public void removefloat2At(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "float", index);
    }

    public void removefloat2() {
        while (hasfloat2())
            removefloat2At(0);
    }

    public void addfloat2(floatType value) {
        appendDomElement("http://www.collada.org/2005/11/COLLADASchema",
                "float", value);
    }

    public void insertfloat2At(floatType value, int index) {
        insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "float", index, value);
    }

    public void replacefloat2At(floatType value, int index) {
        replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "float", index, value);
    }

    public static int getparamMinCount() {
        return 1;
    }

    public static int getparamMaxCount() {
        return 1;
    }

    public int getparamCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "param");
    }

    public boolean hasparam() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "param");
    }

    public paramType2 newparam() {
        return new paramType2(domNode.getOwnerDocument().createElementNS(
                "http://www.collada.org/2005/11/COLLADASchema", "param"));
    }

    public paramType2 getparamAt(int index) throws Exception {
        return new paramType2(
                dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "param", index)));
    }

    public org.w3c.dom.Node getStartingparamCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "param");
    }

    public org.w3c.dom.Node getAdvancedparamCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "param",
                curNode);
    }

    public paramType2 getparamValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new paramType2(dereference(curNode));
    }

    public paramType2 getparam() throws Exception {
        return getparamAt(0);
    }

    public void removeparamAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "param", index);
    }

    public void removeparam() {
        while (hasparam())
            removeparamAt(0);
    }

    public void addparam(paramType2 value) {
        appendDomElement("http://www.collada.org/2005/11/COLLADASchema",
                "param", value);
    }

    public void insertparamAt(paramType2 value, int index) {
        insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "param", index, value);
    }

    public void replaceparamAt(paramType2 value, int index) {
        replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "param", index, value);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
