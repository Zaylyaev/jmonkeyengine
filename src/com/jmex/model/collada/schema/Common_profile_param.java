/**
 * Common_profile_param.java This file was generated by XMLSpy 2006sp2
 * Enterprise Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION. Refer to the XMLSpy
 * Documentation for further details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaNMToken;

public class Common_profile_param extends SchemaNMToken {

    private static final long serialVersionUID = 1L;
    public static final int EA = 0; /* A */
    public static final int EANGLE = 1; /* ANGLE */
    public static final int EB = 2; /* B */
    public static final int EDOUBLE_SIDED = 3; /* DOUBLE_SIDED */
    public static final int EG = 4; /* G */
    public static final int EP = 5; /* P */
    public static final int EQ = 6; /* Q */
    public static final int ER = 7; /* R */
    public static final int ES = 8; /* S */
    public static final int ET = 9; /* T */
    public static final int ETIME = 10; /* TIME */
    public static final int EU = 11; /* U */
    public static final int EV = 12; /* V */
    public static final int EW = 13; /* W */
    public static final int EX = 14; /* X */
    public static final int EY = 15; /* Y */
    public static final int EZ = 16; /* Z */

    public static String[] sEnumValues = { "A", "ANGLE", "B", "DOUBLE_SIDED",
            "G", "P", "Q", "R", "S", "T", "TIME", "U", "V", "W", "X", "Y", "Z", };

    public Common_profile_param() {
        super();
    }

    public Common_profile_param(String newValue) {
        super(newValue);
        validate();
    }

    public Common_profile_param(SchemaNMToken newValue) {
        super(newValue);
        validate();
    }

    public static int getEnumerationCount() {
        return sEnumValues.length;
    }

    public static String getEnumerationValue(int index) {
        return sEnumValues[index];
    }

    public static boolean isValidEnumerationValue(String val) {
        for (int i = 0; i < sEnumValues.length; i++) {
            if (val.equals(sEnumValues[i]))
                return true;
        }
        return false;
    }

    public void validate() {

        if (!isValidEnumerationValue(toString()))
            throw new com.jmex.model.collada.xml.XmlException(
                    "Value of Common_profile_param is invalid.");
    }
}
