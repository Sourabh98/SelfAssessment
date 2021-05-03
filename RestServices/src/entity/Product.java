package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//For Java to JSON and JSON to java transformation of
//Product object, use JAXB annotations
/*This class represents the product each product will be having an id, a name, a brand and price we can also add more properties to the object depending on our requirement.
 * Now we wanted that from the client side a product comes in the JSON format and it would become available to service method and when we send the Java object from the service method then
 * it would be get transformed to JSON format and sent to client now we will use the same JAXB annotations for this purpose which we used in SOAP. Now to do this we will use @XmlRootElement annotation
 * at class level and will @XmlElement annotation with every getter method. Now if we wanted to save the product Object to the database we need to have a DB and a table in DB and we will create
 * DAO to perform operations on DB.*/
@XmlRootElement
/*This tells in which order the property of the product object will be aligned when we will send it over the network.*/
@XmlType(propOrder = { "id", "name", "brand", "price" })
public class Product {
	private int id;
	private String name, brand;
	private int price;

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@XmlElement
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
