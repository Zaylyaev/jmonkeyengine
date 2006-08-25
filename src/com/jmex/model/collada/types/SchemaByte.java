/**
 * SchemaByte.java This file was generated by XMLSpy 2006sp2 Enterprise Edition.
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE OVERWRITTEN WHEN YOU
 * RE-RUN CODE GENERATION. Refer to the XMLSpy Documentation for further
 * details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.types;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SchemaByte implements SchemaTypeNumber {

    private static final long serialVersionUID = 1L;
    protected byte value;
    protected boolean isempty;
    protected boolean isnull;

    // construction
    public SchemaByte() {
        setEmpty();
    }

    public SchemaByte(SchemaByte newvalue) {
        value = newvalue.value;
        isempty = newvalue.isempty;
        isnull = newvalue.isnull;
    }

    public SchemaByte(int newvalue) {
        setValue(newvalue);
    }

    public SchemaByte(String newvalue) {
        parse(newvalue);
    }

    public SchemaByte(SchemaType newvalue) {
        assign(newvalue);
    }

    public SchemaByte(SchemaTypeNumber newvalue) {
        assign(newvalue);
    }

    // getValue, setValue
    public byte getValue() {
        return value;
    }

    public void setValue(int newvalue) {
        value = (byte) newvalue;
        isempty = false;
        isnull = false;
    }

    public void parse(String newvalue) {
        if (newvalue == null)
            setNull();
        else if (newvalue.length() == 0)
            setEmpty();
        else {
            isempty = false;
            isnull = false;
            value = Byte.parseByte(newvalue);
        }
    }

    public void assign(SchemaType newvalue) {
        if (newvalue == null || newvalue.isNull())
            setNull();
        else if (newvalue.isEmpty())
            setEmpty();
        else {
            isnull = false;
            isempty = false;
            if (newvalue instanceof SchemaTypeNumber)
                value = (byte) ((SchemaTypeNumber) newvalue).intValue();
            else
                throw new TypesIncompatibleException(newvalue, this);
        }
    }

    public void setNull() {
        isnull = true;
        isempty = true;
        value = 0;
    }

    public void setEmpty() {
        isnull = false;
        isempty = true;
        value = 0;
    }

    // further
    public int hashCode() {
        return value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SchemaByte))
            return false;
        return value == ((SchemaByte) obj).value;
    }

    public Object clone() {
        return new SchemaByte(this);
    }

    public String toString() {
        if (isempty || isnull)
            return "";
        return Byte.toString(value);
    }

    public int length() {
        return toString().length();
    }

    public boolean booleanValue() {
        return value != 0;
    }

    public boolean isEmpty() {
        return isempty;
    }

    public boolean isNull() {
        return isnull;
    }

    public int compareTo(Object obj) {
        return compareTo((SchemaByte) obj);
    }

    public int compareTo(SchemaByte obj) {
        return new Byte(value).compareTo(new Byte(obj.value));
    }

    // interface SchemaTypeNumber
    public int numericType() {
        return NUMERIC_VALUE_INT;
    }

    public int intValue() {
        return value;
    }

    public long longValue() {
        return value;
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(value);
    }

    public float floatValue() {
        return value;
    }

    public double doubleValue() {
        return value;
    }

    public BigDecimal bigDecimalValue() {
        return BigDecimal.valueOf(value);
    }

}
