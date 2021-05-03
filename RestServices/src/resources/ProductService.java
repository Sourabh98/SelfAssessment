package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ProductDao;
import entity.Product;
import entity.ProductList;

/*So if there would be a request with products service URI i.e. if we will write the products in front of the application name 
 * then this service will get invoked, we know in REST there is a fixed format of the Service URLS and in the URL we append the service URI to map the URL
 * to a particular service.
 * We will use this service to fetch the products, save the products, update the products and delete the products.*/
@Path("/products")
public class ProductService {

	/*
	 * As we know POST annotation uses to map the service method to the HTTP post
	 * request which is uses to persist or save the data in the DB so here we are
	 * saving the products in the DB and for that we are using the dao, @Consume
	 * notation will tell what kind of data this service method would consume or use
	 * and @Produce annotation will tell what type of result this service method
	 * will produce. MediaType is the Enum which is defined in Java in which they
	 * have given values which can be produced or consumed by the services, in
	 * consumes we have given MediaType.APPLICATION_JSON here application means that
	 * the object will come in the JSON format and this will convert that JSON
	 * format object to the Java object. Again we are saying that we are returning
	 * the plain text so from the @Produces annotation invoker will get to know what
	 * we wanted to return. Now this is our small service method now we wanted to
	 * invoke this service for that we would be needing the interceptor that
	 * interceptor will intercept the request and will identify the service class on
	 * the basis of the request URI and on the basis of the request type and method
	 * path will identify the service method which needs to be invoked, now that
	 * intrerceptor we will get from the JERSEY implementation whose jar file we
	 * have added.
	 */
	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String saveProduct(Product p) {
		/*
		 * Now the object we would be receiving in this method would be a JSON object
		 * and we would be needing to convert that object to that Java object of product
		 * type.
		 */

		try {
			ProductDao productDao = new ProductDao();
			productDao.saveProduct(p);
			return "Successfully saved";
		} catch (Exception e) {
			return "Product couldn't be saved because" + e.getMessage();
		}

	}

	/*
	 * so here we are mapping this service method there would be the id after the
	 * service URI and request type would be get request in that case this method
	 * would get invoked, so for path param you will write @Path annotation like
	 * below the id which we have written in the {} braces means that this could be
	 * replaced by the paramters which would be send as part of the URL after slash
	 * '/'.
	 */
	@Path("/id/{id}")
	@GET
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public Product getProduct(@PathParam("id") int id) {

		try {
			ProductDao productDao = new ProductDao();
			return productDao.getProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * this service method will get invoked where there would be a http get request
	 * with serviceUI only, this method will fetch all the products from the DB.
	 */
	@GET
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ProductList getAllProducts() {

		ProductList productList = new ProductList();
		try {
			ProductDao dao = new ProductDao();
			productList.setProductList(dao.getAllProducts());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

}
