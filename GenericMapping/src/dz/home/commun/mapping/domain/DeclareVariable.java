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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for declareVariable element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="declareVariable">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;attribute name="key" use="required">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ABCD1"/>
 *               &lt;enumeration value="ABCD2"/>
 *               &lt;enumeration value="ABCD3"/>
 *               &lt;enumeration value="ABCD4"/>
 *               &lt;enumeration value="ABCD5"/>
 *               &lt;enumeration value="ABCD6"/>
 *               &lt;enumeration value="ABCD7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/attribute>
 *         &lt;attribute name="name" use="required">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="CTRL CODE No."/>
 *               &lt;enumeration value="INTFC(1) CODE No."/>
 *               &lt;enumeration value="INTFC(2) CODE No."/>
 *               &lt;enumeration value="MODEM CODE No.{|(No.1)|(DIR-A)}"/>
 *               &lt;enumeration value="MODEM CODE No.{|(No.2)|(DIR-B)}"/>
 *               &lt;enumeration value="ODU CODE No.{|(No.1)|(DIR-A)}"/>
 *               &lt;enumeration value="ODU CODE No.{|(No.2)|(DIR-B)}"/>
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
@XmlType(name = "")
@XmlRootElement(name = "declareVariable")
public class DeclareVariable {

    @XmlAttribute(required = true)
    protected String key;
    @XmlAttribute(required = true)
    protected String name;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
