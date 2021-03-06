//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.29 at 03:30:40 PM WAT 
//


package dz.home.commun.mapping.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mappings element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="mappings">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}variableDeclaration"/>
 *           &lt;element ref="{}functionDeclaration"/>
 *           &lt;element ref="{}ExternalObjectInput"/>
 *           &lt;element ref="{}mapping" maxOccurs="unbounded"/>
 *         &lt;/sequence>
 *         &lt;attribute name="name" use="required">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
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
    "variableDeclaration",
    "functionDeclaration",
    "externalObjectInput",
    "mapping"
})
@XmlRootElement(name = "mappings")
public class Mappings {

    @XmlElement(required = true)
    protected VariableDeclaration variableDeclaration;
    @XmlElement(required = true)
    protected FunctionDeclaration functionDeclaration;
    @XmlElement(name = "ExternalObjectInput", required = true)
    protected ExternalObjectInput externalObjectInput;
    @XmlElement(required = true)
    protected List<Mapping> mapping;
    @XmlAttribute(required = true)
    protected String name;

    /**
     * Gets the value of the variableDeclaration property.
     * 
     * @return
     *     possible object is
     *     {@link VariableDeclaration }
     *     
     */
    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    /**
     * Sets the value of the variableDeclaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableDeclaration }
     *     
     */
    public void setVariableDeclaration(VariableDeclaration value) {
        this.variableDeclaration = value;
    }

    /**
     * Gets the value of the functionDeclaration property.
     * 
     * @return
     *     possible object is
     *     {@link FunctionDeclaration }
     *     
     */
    public FunctionDeclaration getFunctionDeclaration() {
        return functionDeclaration;
    }

    /**
     * Sets the value of the functionDeclaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionDeclaration }
     *     
     */
    public void setFunctionDeclaration(FunctionDeclaration value) {
        this.functionDeclaration = value;
    }

    /**
     * Gets the value of the externalObjectInput property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalObjectInput }
     *     
     */
    public ExternalObjectInput getExternalObjectInput() {
        return externalObjectInput;
    }

    /**
     * Sets the value of the externalObjectInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalObjectInput }
     *     
     */
    public void setExternalObjectInput(ExternalObjectInput value) {
        this.externalObjectInput = value;
    }

    /**
     * Gets the value of the mapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mapping }
     * 
     * 
     */
    public List<Mapping> getMapping() {
        if (mapping == null) {
            mapping = new ArrayList<Mapping>();
        }
        return this.mapping;
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
