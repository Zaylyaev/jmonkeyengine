/**
 * fx_include_common.java This file was generated by XMLSpy 2006sp2 Enterprise
 * Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE OVERWRITTEN WHEN
 * YOU RE-RUN CODE GENERATION. Refer to the XMLSpy Documentation for further
 * details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaNCName;
import com.jmex.model.collada.types.SchemaString;

public class fx_include_common extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public fx_include_common(fx_include_common node) {
        super(node);
    }

    public fx_include_common(org.w3c.dom.Node node) {
        super(node);
    }

    public fx_include_common(org.w3c.dom.Document doc) {
        super(doc);
    }

    public fx_include_common(com.jmex.model.collada.xml.Document doc,
            String namespaceURI, String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Attribute, null, "sid"); tmpNode != null; tmpNode = getDomNextChild(
                Attribute, null, "sid", tmpNode)) {
            internalAdjustPrefix(tmpNode, false);
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Attribute, null, "url"); tmpNode != null; tmpNode = getDomNextChild(
                Attribute, null, "url", tmpNode)) {
            internalAdjustPrefix(tmpNode, false);
        }
    }

    public static int getsidMinCount() {
        return 1;
    }

    public static int getsidMaxCount() {
        return 1;
    }

    public int getsidCount() {
        return getDomChildCount(Attribute, null, "sid");
    }

    public boolean hassid() {
        return hasDomChild(Attribute, null, "sid");
    }

    public SchemaNCName newsid() {
        return new SchemaNCName();
    }

    public SchemaNCName getsidAt(int index) throws Exception {
        return new SchemaNCName(getDomNodeValue(dereference(getDomChildAt(
                Attribute, null, "sid", index))));
    }

    public org.w3c.dom.Node getStartingsidCursor() throws Exception {
        return getDomFirstChild(Attribute, null, "sid");
    }

    public org.w3c.dom.Node getAdvancedsidCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Attribute, null, "sid", curNode);
    }

    public SchemaNCName getsidValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new SchemaNCName(getDomNodeValue(dereference(curNode)));
    }

    public SchemaNCName getsid() throws Exception {
        return getsidAt(0);
    }

    public void removesidAt(int index) {
        removeDomChildAt(Attribute, null, "sid", index);
    }

    public void removesid() {
        while (hassid())
            removesidAt(0);
    }

    public void addsid(SchemaNCName value) {
        if (value.isNull() == false) {
            appendDomChild(Attribute, null, "sid", value.toString());
        }
    }

    public void addsid(String value) throws Exception {
        addsid(new SchemaNCName(value));
    }

    public void insertsidAt(SchemaNCName value, int index) {
        insertDomChildAt(Attribute, null, "sid", index, value.toString());
    }

    public void insertsidAt(String value, int index) throws Exception {
        insertsidAt(new SchemaNCName(value), index);
    }

    public void replacesidAt(SchemaNCName value, int index) {
        replaceDomChildAt(Attribute, null, "sid", index, value.toString());
    }

    public void replacesidAt(String value, int index) throws Exception {
        replacesidAt(new SchemaNCName(value), index);
    }

    public static int geturlMinCount() {
        return 1;
    }

    public static int geturlMaxCount() {
        return 1;
    }

    public int geturlCount() {
        return getDomChildCount(Attribute, null, "url");
    }

    public boolean hasurl() {
        return hasDomChild(Attribute, null, "url");
    }

    public SchemaString newurl() {
        return new SchemaString();
    }

    public SchemaString geturlAt(int index) throws Exception {
        return new SchemaString(getDomNodeValue(dereference(getDomChildAt(
                Attribute, null, "url", index))));
    }

    public org.w3c.dom.Node getStartingurlCursor() throws Exception {
        return getDomFirstChild(Attribute, null, "url");
    }

    public org.w3c.dom.Node getAdvancedurlCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Attribute, null, "url", curNode);
    }

    public SchemaString geturlValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new SchemaString(getDomNodeValue(dereference(curNode)));
    }

    public SchemaString geturl() throws Exception {
        return geturlAt(0);
    }

    public void removeurlAt(int index) {
        removeDomChildAt(Attribute, null, "url", index);
    }

    public void removeurl() {
        while (hasurl())
            removeurlAt(0);
    }

    public void addurl(SchemaString value) {
        if (value.isNull() == false) {
            appendDomChild(Attribute, null, "url", value.toString());
        }
    }

    public void addurl(String value) throws Exception {
        addurl(new SchemaString(value));
    }

    public void inserturlAt(SchemaString value, int index) {
        insertDomChildAt(Attribute, null, "url", index, value.toString());
    }

    public void inserturlAt(String value, int index) throws Exception {
        inserturlAt(new SchemaString(value), index);
    }

    public void replaceurlAt(SchemaString value, int index) {
        replaceDomChildAt(Attribute, null, "url", index, value.toString());
    }

    public void replaceurlAt(String value, int index) throws Exception {
        replaceurlAt(new SchemaString(value), index);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
