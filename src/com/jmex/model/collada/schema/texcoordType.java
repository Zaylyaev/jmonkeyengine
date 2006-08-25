/**
 * texcoordType.java This file was generated by XMLSpy 2006sp2 Enterprise
 * Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE OVERWRITTEN WHEN
 * YOU RE-RUN CODE GENERATION. Refer to the XMLSpy Documentation for further
 * details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaNCName;

public class texcoordType extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public texcoordType(texcoordType node) {
        super(node);
    }

    public texcoordType(org.w3c.dom.Node node) {
        super(node);
    }

    public texcoordType(org.w3c.dom.Document doc) {
        super(doc);
    }

    public texcoordType(com.jmex.model.collada.xml.Document doc,
            String namespaceURI, String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Attribute, null,
                "semantic"); tmpNode != null; tmpNode = getDomNextChild(
                Attribute, null, "semantic", tmpNode)) {
            internalAdjustPrefix(tmpNode, false);
        }
    }

    public static int getsemanticMinCount() {
        return 0;
    }

    public static int getsemanticMaxCount() {
        return 1;
    }

    public int getsemanticCount() {
        return getDomChildCount(Attribute, null, "semantic");
    }

    public boolean hassemantic() {
        return hasDomChild(Attribute, null, "semantic");
    }

    public SchemaNCName newsemantic() {
        return new SchemaNCName();
    }

    public SchemaNCName getsemanticAt(int index) throws Exception {
        return new SchemaNCName(getDomNodeValue(dereference(getDomChildAt(
                Attribute, null, "semantic", index))));
    }

    public org.w3c.dom.Node getStartingsemanticCursor() throws Exception {
        return getDomFirstChild(Attribute, null, "semantic");
    }

    public org.w3c.dom.Node getAdvancedsemanticCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Attribute, null, "semantic", curNode);
    }

    public SchemaNCName getsemanticValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new SchemaNCName(getDomNodeValue(dereference(curNode)));
    }

    public SchemaNCName getsemantic() throws Exception {
        return getsemanticAt(0);
    }

    public void removesemanticAt(int index) {
        removeDomChildAt(Attribute, null, "semantic", index);
    }

    public void removesemantic() {
        while (hassemantic())
            removesemanticAt(0);
    }

    public void addsemantic(SchemaNCName value) {
        if (value.isNull() == false) {
            appendDomChild(Attribute, null, "semantic", value.toString());
        }
    }

    public void addsemantic(String value) throws Exception {
        addsemantic(new SchemaNCName(value));
    }

    public void insertsemanticAt(SchemaNCName value, int index) {
        insertDomChildAt(Attribute, null, "semantic", index, value.toString());
    }

    public void insertsemanticAt(String value, int index) throws Exception {
        insertsemanticAt(new SchemaNCName(value), index);
    }

    public void replacesemanticAt(SchemaNCName value, int index) {
        replaceDomChildAt(Attribute, null, "semantic", index, value.toString());
    }

    public void replacesemanticAt(String value, int index) throws Exception {
        replacesemanticAt(new SchemaNCName(value), index);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
