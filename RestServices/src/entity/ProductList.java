package entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/*For XML and JSON transformation we are using JAX-B annotations this is a wrapper class for collection of Product objects return by getAllProdcut method*/
/*XML root element uses to transfer ProductList object to XML*/
@XmlRootElement
/*Below annotation used when we wanted  to look into the Product class mapping or binding as well while doing the mapping for ProductList*/
@XmlSeeAlso(Product.class)
public class ProductList {

	List<Product> list;

	@XmlElement
	public List<Product> getProductList() {
		return list;
	}

	public void setProductList(List<Product> productList) {
		list = productList;
	}
}
