/**
 * tapered_cylinderType.java This file was generated by XMLSpy 2006sp2
 * Enterprise Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION. Refer to the XMLSpy
 * Documentation for further details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

public class tapered_cylinderType extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public tapered_cylinderType(tapered_cylinderType node) {
        super(node);
    }

    public tapered_cylinderType(org.w3c.dom.Node node) {
        super(node);
    }

    public tapered_cylinderType(org.w3c.dom.Document doc) {
        super(doc);
    }

    public tapered_cylinderType(com.jmex.model.collada.xml.Document doc,
            String namespaceURI, String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "height", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "radius1", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "radius2", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "extra", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
            new extraType(tmpNode).adjustPrefix();
        }
    }

    public static int getheightMinCount() {
        return 1;
    }

    public static int getheightMaxCount() {
        return 1;
    }

    public int getheightCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height");
    }

    public boolean hasheight() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height");
    }

    public float2 newheight() {
        return new float2();
    }

    public float2 getheightAt(int index) throws Exception {
        return new float2(
                getDomNodeValue(dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "height", index))));
    }

    public org.w3c.dom.Node getStartingheightCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height");
    }

    public org.w3c.dom.Node getAdvancedheightCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height",
                curNode);
    }

    public float2 getheightValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new float2(getDomNodeValue(dereference(curNode)));
    }

    public float2 getheight() throws Exception {
        return getheightAt(0);
    }

    public void removeheightAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height", index);
    }

    public void removeheight() {
        while (hasheight())
            removeheightAt(0);
    }

    public void addheight(float2 value) {
        if (value.isNull() == false) {
            appendDomChild(Element,
                    "http://www.collada.org/2005/11/COLLADASchema", "height",
                    value.toString());
        }
    }

    public void addheight(String value) throws Exception {
        addheight(new float2(value));
    }

    public void insertheightAt(float2 value, int index) {
        insertDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height",
                index, value.toString());
    }

    public void insertheightAt(String value, int index) throws Exception {
        insertheightAt(new float2(value), index);
    }

    public void replaceheightAt(float2 value, int index) {
        replaceDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "height",
                index, value.toString());
    }

    public void replaceheightAt(String value, int index) throws Exception {
        replaceheightAt(new float2(value), index);
    }

    public static int getradius1MinCount() {
        return 1;
    }

    public static int getradius1MaxCount() {
        return 1;
    }

    public int getradius1Count() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1");
    }

    public boolean hasradius1() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1");
    }

    public float22 newradius1() {
        return new float22();
    }

    public float22 getradius1At(int index) throws Exception {
        return new float22(getDomNodeValue(dereference(getDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1",
                index))));
    }

    public org.w3c.dom.Node getStartingradius1Cursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1");
    }

    public org.w3c.dom.Node getAdvancedradius1Cursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1",
                curNode);
    }

    public float22 getradius1ValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new float22(getDomNodeValue(dereference(curNode)));
    }

    public float22 getradius1() throws Exception {
        return getradius1At(0);
    }

    public void removeradius1At(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1",
                index);
    }

    public void removeradius1() {
        while (hasradius1())
            removeradius1At(0);
    }

    public void addradius1(float22 value) {
        if (value.isNull() == false) {
            appendDomChild(Element,
                    "http://www.collada.org/2005/11/COLLADASchema", "radius1",
                    value.toString());
        }
    }

    public void addradius1(String value) throws Exception {
        addradius1(new float22(value));
    }

    public void insertradius1At(float22 value, int index) {
        insertDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1",
                index, value.toString());
    }

    public void insertradius1At(String value, int index) throws Exception {
        insertradius1At(new float22(value), index);
    }

    public void replaceradius1At(float22 value, int index) {
        replaceDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius1",
                index, value.toString());
    }

    public void replaceradius1At(String value, int index) throws Exception {
        replaceradius1At(new float22(value), index);
    }

    public static int getradius2MinCount() {
        return 1;
    }

    public static int getradius2MaxCount() {
        return 1;
    }

    public int getradius2Count() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2");
    }

    public boolean hasradius2() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2");
    }

    public float22 newradius2() {
        return new float22();
    }

    public float22 getradius2At(int index) throws Exception {
        return new float22(getDomNodeValue(dereference(getDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2",
                index))));
    }

    public org.w3c.dom.Node getStartingradius2Cursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2");
    }

    public org.w3c.dom.Node getAdvancedradius2Cursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2",
                curNode);
    }

    public float22 getradius2ValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new float22(getDomNodeValue(dereference(curNode)));
    }

    public float22 getradius2() throws Exception {
        return getradius2At(0);
    }

    public void removeradius2At(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2",
                index);
    }

    public void removeradius2() {
        while (hasradius2())
            removeradius2At(0);
    }

    public void addradius2(float22 value) {
        if (value.isNull() == false) {
            appendDomChild(Element,
                    "http://www.collada.org/2005/11/COLLADASchema", "radius2",
                    value.toString());
        }
    }

    public void addradius2(String value) throws Exception {
        addradius2(new float22(value));
    }

    public void insertradius2At(float22 value, int index) {
        insertDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2",
                index, value.toString());
    }

    public void insertradius2At(String value, int index) throws Exception {
        insertradius2At(new float22(value), index);
    }

    public void replaceradius2At(float22 value, int index) {
        replaceDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius2",
                index, value.toString());
    }

    public void replaceradius2At(String value, int index) throws Exception {
        replaceradius2At(new float22(value), index);
    }

    public static int getextraMinCount() {
        return 0;
    }

    public static int getextraMaxCount() {
        return Integer.MAX_VALUE;
    }

    public int getextraCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra");
    }

    public boolean hasextra() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra");
    }

    public extraType newextra() {
        return new extraType(domNode.getOwnerDocument().createElementNS(
                "http://www.collada.org/2005/11/COLLADASchema", "extra"));
    }

    public extraType getextraAt(int index) throws Exception {
        return new extraType(
                dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "extra", index)));
    }

    public org.w3c.dom.Node getStartingextraCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra");
    }

    public org.w3c.dom.Node getAdvancedextraCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra",
                curNode);
    }

    public extraType getextraValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new extraType(dereference(curNode));
    }

    public extraType getextra() throws Exception {
        return getextraAt(0);
    }

    public void removeextraAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra", index);
    }

    public void removeextra() {
        while (hasextra())
            removeextraAt(0);
    }

    public void addextra(extraType value) {
        appendDomElement("http://www.collada.org/2005/11/COLLADASchema",
                "extra", value);
    }

    public void insertextraAt(extraType value, int index) {
        insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "extra", index, value);
    }

    public void replaceextraAt(extraType value, int index) {
        replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "extra", index, value);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
