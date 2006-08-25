/**
 * nameType.java This file was generated by XMLSpy 2006sp2 Enterprise Edition.
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE OVERWRITTEN WHEN YOU
 * RE-RUN CODE GENERATION. Refer to the XMLSpy Documentation for further
 * details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaNCName;
import com.jmex.model.collada.types.SchemaType;

public class nameType extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public nameType(nameType node) {
        super(node);
    }

    public nameType(org.w3c.dom.Node node) {
        super(node);
    }

    public nameType(org.w3c.dom.Document doc) {
        super(doc);
    }

    public nameType(com.jmex.model.collada.xml.Document doc,
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
                "source"); tmpNode != null; tmpNode = getDomNextChild(
                Attribute, null, "source", tmpNode)) {
            internalAdjustPrefix(tmpNode, false);
        }
    }

    public static int getsourceMinCount() {
        return 0;
    }

    public static int getsourceMaxCount() {
        return 1;
    }

    public int getsourceCount() {
        return getDomChildCount(Attribute, null, "source");
    }

    public boolean hassource() {
        return hasDomChild(Attribute, null, "source");
    }

    public SchemaNCName newsource() {
        return new SchemaNCName();
    }

    public SchemaNCName getsourceAt(int index) throws Exception {
        return new SchemaNCName(getDomNodeValue(dereference(getDomChildAt(
                Attribute, null, "source", index))));
    }

    public org.w3c.dom.Node getStartingsourceCursor() throws Exception {
        return getDomFirstChild(Attribute, null, "source");
    }

    public org.w3c.dom.Node getAdvancedsourceCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Attribute, null, "source", curNode);
    }

    public SchemaNCName getsourceValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new SchemaNCName(getDomNodeValue(dereference(curNode)));
    }

    public SchemaNCName getsource() throws Exception {
        return getsourceAt(0);
    }

    public void removesourceAt(int index) {
        removeDomChildAt(Attribute, null, "source", index);
    }

    public void removesource() {
        while (hassource())
            removesourceAt(0);
    }

    public void addsource(SchemaNCName value) {
        if (value.isNull() == false) {
            appendDomChild(Attribute, null, "source", value.toString());
        }
    }

    public void addsource(String value) throws Exception {
        addsource(new SchemaNCName(value));
    }

    public void insertsourceAt(SchemaNCName value, int index) {
        insertDomChildAt(Attribute, null, "source", index, value.toString());
    }

    public void insertsourceAt(String value, int index) throws Exception {
        insertsourceAt(new SchemaNCName(value), index);
    }

    public void replacesourceAt(SchemaNCName value, int index) {
        replaceDomChildAt(Attribute, null, "source", index, value.toString());
    }

    public void replacesourceAt(String value, int index) throws Exception {
        replacesourceAt(new SchemaNCName(value), index);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
