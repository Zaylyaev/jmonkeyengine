/**
 * fx_colortarget_common.java This file was generated by XMLSpy 2006sp2
 * Enterprise Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION. Refer to the XMLSpy
 * Documentation for further details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaInteger;
import com.jmex.model.collada.types.SchemaNCName;
import com.jmex.model.collada.types.SchemaType;

public class fx_colortarget_common extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public fx_colortarget_common(fx_colortarget_common node) {
        super(node);
    }

    public fx_colortarget_common(org.w3c.dom.Node node) {
        super(node);
    }

    public fx_colortarget_common(org.w3c.dom.Document doc) {
        super(doc);
    }

    public fx_colortarget_common(com.jmex.model.collada.xml.Document doc,
            String namespaceURI, String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public SchemaNCName getValue() {
        return new SchemaNCName(getDomNodeValue(dereference(domNode)));
    }

    public void setValue(SchemaType value) {
        setDomNodeValue(domNode, value.toString());
    }

    public void assign(SchemaType value) {
        setValue(value);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Attribute, null,
                "index"); tmpNode != null; tmpNode = getDomNextChild(Attribute,
                null, "index", tmpNode)) {
            internalAdjustPrefix(tmpNode, false);
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Attribute, null,
                "slice"); tmpNode != null; tmpNode = getDomNextChild(Attribute,
                null, "slice", tmpNode)) {
            internalAdjustPrefix(tmpNode, false);
        }
    }

    public static int getindexMinCount() {
        return 0;
    }

    public static int getindexMaxCount() {
        return 1;
    }

    public int getindexCount() {
        return getDomChildCount(Attribute, null, "index");
    }

    public boolean hasindex() {
        return hasDomChild(Attribute, null, "index");
    }

    public SchemaInteger newindex() {
        return new SchemaInteger();
    }

    public SchemaInteger getindexAt(int index) throws Exception {
        return new SchemaInteger(getDomNodeValue(dereference(getDomChildAt(
                Attribute, null, "index", index))));
    }

    public org.w3c.dom.Node getStartingindexCursor() throws Exception {
        return getDomFirstChild(Attribute, null, "index");
    }

    public org.w3c.dom.Node getAdvancedindexCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Attribute, null, "index", curNode);
    }

    public SchemaInteger getindexValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new SchemaInteger(getDomNodeValue(dereference(curNode)));
    }

    public SchemaInteger getindex() throws Exception {
        return getindexAt(0);
    }

    public void removeindexAt(int index) {
        removeDomChildAt(Attribute, null, "index", index);
    }

    public void removeindex() {
        while (hasindex())
            removeindexAt(0);
    }

    public void addindex(SchemaInteger value) {
        if (value.isNull() == false) {
            appendDomChild(Attribute, null, "index", value.toString());
        }
    }

    public void addindex(String value) throws Exception {
        addindex(new SchemaInteger(value));
    }

    public void insertindexAt(SchemaInteger value, int index) {
        insertDomChildAt(Attribute, null, "index", index, value.toString());
    }

    public void insertindexAt(String value, int index) throws Exception {
        insertindexAt(new SchemaInteger(value), index);
    }

    public void replaceindexAt(SchemaInteger value, int index) {
        replaceDomChildAt(Attribute, null, "index", index, value.toString());
    }

    public void replaceindexAt(String value, int index) throws Exception {
        replaceindexAt(new SchemaInteger(value), index);
    }

    public static int getsliceMinCount() {
        return 0;
    }

    public static int getsliceMaxCount() {
        return 1;
    }

    public int getsliceCount() {
        return getDomChildCount(Attribute, null, "slice");
    }

    public boolean hasslice() {
        return hasDomChild(Attribute, null, "slice");
    }

    public SchemaInteger newslice() {
        return new SchemaInteger();
    }

    public SchemaInteger getsliceAt(int index) throws Exception {
        return new SchemaInteger(getDomNodeValue(dereference(getDomChildAt(
                Attribute, null, "slice", index))));
    }

    public org.w3c.dom.Node getStartingsliceCursor() throws Exception {
        return getDomFirstChild(Attribute, null, "slice");
    }

    public org.w3c.dom.Node getAdvancedsliceCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Attribute, null, "slice", curNode);
    }

    public SchemaInteger getsliceValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new SchemaInteger(getDomNodeValue(dereference(curNode)));
    }

    public SchemaInteger getslice() throws Exception {
        return getsliceAt(0);
    }

    public void removesliceAt(int index) {
        removeDomChildAt(Attribute, null, "slice", index);
    }

    public void removeslice() {
        while (hasslice())
            removesliceAt(0);
    }

    public void addslice(SchemaInteger value) {
        if (value.isNull() == false) {
            appendDomChild(Attribute, null, "slice", value.toString());
        }
    }

    public void addslice(String value) throws Exception {
        addslice(new SchemaInteger(value));
    }

    public void insertsliceAt(SchemaInteger value, int index) {
        insertDomChildAt(Attribute, null, "slice", index, value.toString());
    }

    public void insertsliceAt(String value, int index) throws Exception {
        insertsliceAt(new SchemaInteger(value), index);
    }

    public void replacesliceAt(SchemaInteger value, int index) {
        replaceDomChildAt(Attribute, null, "slice", index, value.toString());
    }

    public void replacesliceAt(String value, int index) throws Exception {
        replacesliceAt(new SchemaInteger(value), index);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
