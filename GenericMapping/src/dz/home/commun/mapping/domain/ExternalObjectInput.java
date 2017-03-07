//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.29 at 03:30:40 PM WAT 
//


package dz.home.commun.mapping.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExternalObjectInput element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="ExternalObjectInput">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}FilesKeys"/>
 *           &lt;element ref="{}FileRelationShip"/>
 *         &lt;/sequence>
 *         &lt;attribute name="exoInputType" use="required">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="text"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/attribute>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "filesKeys",
    "fileRelationShip"
})
@XmlRootElement(name = "ExternalObjectInput")
public class ExternalObjectInput {

    @XmlElement(name = "FilesKeys", required = true)
    protected FilesKeys filesKeys;
    @XmlElement(name = "FileRelationShip", required = true)
    protected FileRelationShip fileRelationShip;
    @XmlAttribute(required = true)
    protected String exoInputType;

    /**
     * Gets the value of the filesKeys property.
     * 
     * @return
     *     possible object is
     *     {@link FilesKeys }
     *     
     */
    public FilesKeys getFilesKeys() {
        return filesKeys;
    }

    /**
     * Sets the value of the filesKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilesKeys }
     *     
     */
    public void setFilesKeys(FilesKeys value) {
        this.filesKeys = value;
    }

    /**
     * Gets the value of the fileRelationShip property.
     * 
     * @return
     *     possible object is
     *     {@link FileRelationShip }
     *     
     */
    public FileRelationShip getFileRelationShip() {
        return fileRelationShip;
    }

    /**
     * Sets the value of the fileRelationShip property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileRelationShip }
     *     
     */
    public void setFileRelationShip(FileRelationShip value) {
        this.fileRelationShip = value;
    }

    /**
     * Gets the value of the exoInputType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExoInputType() {
        return exoInputType;
    }

    /**
     * Sets the value of the exoInputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExoInputType(String value) {
        this.exoInputType = value;
    }

}