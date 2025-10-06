package com.cohan.test.web_service_soap;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
* <p>Clase Java para alumnoInfo complex type.
* 
* <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
* 
* <pre>
* &lt;complexType name="alumnoInfo">
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personInfo", propOrder = {
 "nif",
 "name",
 "phone",
 "email"
})
public class PersonInfo {

 @XmlElement(required = true)
 protected String nif;
 @XmlElement(required = true)
 protected String name;
 @XmlElement(required = true)
 protected String phone;
 @XmlElement(required = true)
 protected String email;

 /**
  * Obtiene el valor de la propiedad nif.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getNif() {
     return nif;
 }

 /**
  * Define el valor de la propiedad nif.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setNif(String value) {
     this.nif = value;
 }

 /**
  * Obtiene el valor de la propiedad name.
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
  * Define el valor de la propiedad nombre.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setName(String value) {
     this.name = value;
 }

 /**
  * Obtiene el valor de la propiedad phone.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getPhone() {
     return phone;
 }

 /**
  * Define el valor de la propiedad apellidos.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setPhone(String value) {
     this.phone = value;
 }

 /**
  * Obtiene el valor de la propiedad email.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getEmail() {
     return email;
 }

 /**
  * Define el valor de la propiedad email.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setEmail(String value) {
     this.email = value;
 }

}