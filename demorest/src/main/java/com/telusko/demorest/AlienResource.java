package com.telusko.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*Jersey also provides the libraries for the JSON and XML conversion which we have configured in pom.xml file moxy 
 * one if for JSON and the other one which is starting with jersey will also help in XML conversion, There are other 
 * libraries such as Json and jackson  other then moxy which you can use for conversion
 * but this moxy one is provided by the jersey so we are going to use this one only configuration for the same is provided in the pom.xml */
@Path("/aliens")
public class AlienResource {

	/*
	 * Everytime you will invoke this service the Interceptor Servlet which is
	 * Servletcontainer will create this Object so even you are adding the data to
	 * the list through the POST request you will always get only two objects which
	 * we added in the Constructor of the Repo
	 */
	private AlienRepository alienRepo = new AlienRepository();

	@Path("/fromService")
	@GET
	@Produces(value = { MediaType.APPLICATION_XML })
	public List<Alien> getAliens() {

		return alienRepo.getAllAliens();

	}

	/*
	 * Now in this case we are using @QueryParam and the query parameter which we
	 * will send in the URL would be after the Question mark, but we can send such
	 * data using slash '/' and the annotation we will use in that case would
	 * be @PathParam
	 */
	@Path("/alien")
	@GET
	@Consumes(value = { MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_XML })
	public Alien getAlienFromRepo(@QueryParam("id") int id) {
		return alienRepo.getAlien(id);
	}

	@Path("/alien/{id}")
	@GET
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Alien getAlienPathParam(@PathParam("id") int id) {
		return alienRepo.getAlien(id);
	}

	/*
	 * As we already know post annotation is used for creating a resource.. Now the
	 * main thing is how we send the data this we have already covered in angular
	 * based app and console based apps, we will have to marshall the objects into
	 * JSON or XML depending in which format service is consuming and then will send
	 * the data through post request. But the thing is we can not create those
	 * clients every time so we will have to use some tool to send the data to a
	 * service so we have a tool named as POSTMAN we can add it as plugin in your
	 * browser or download it as an app and then we can use this tool as a client
	 * for our rest services the benefit of using this is that through browser you
	 * can only send the get request but through this you can send multiple types of
	 * Request for example you can send PUT,POST,DELETE etc requests which are
	 * supported by http protocol, there are other benefits of using that tool too.
	 */
	@Path("/alien")
	@POST
	@Consumes(value = { MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String saveAlienInRepo(Alien alien) {
		alienRepo.saveAlien(alien);
		System.out.println(alien);
		return "Alien has been saved successfully..";

	}

	/*
	 * In maven based projects to support JSON format you will have to add the
	 * dependency in pom.xml as by default jersey only supports xml format and as
	 * you can see below we can also provide both the formats in an array
	 * with @Produces annotation that means that this method can produces or convert
	 * the JAVA object to XML or JSON format(marshalling) and will return that
	 * object but now the question is when it will send the JSON object and when the
	 * XML object do we need to make any changes on the client side???? Yes
	 * through the tool like POSTMAN you can mention what you wanted to receive from
	 * your service so if you will mention in accept key as application/json then in
	 * that case you will get the JSON object back, you can find the screenshot in
	 * the notes, this is also called content negotiation like from the service you are 
	 * sending XML or JSON depending on what the user wants.
	 */
	@Path("/fromDb")
	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public AlienList getAllAliensFromDb() {
		AlienDao dao = new AlienDao();
		AlienList alienList = new AlienList();
		alienList.setAlientList(dao.getAllAliens());
		return alienList;

	}

	/*
	 * below method will be to fetch Alien on the basis of the Id from DB when you
	 * are sending id as part of the path Parameter that is after the / in the url
	 */
	@Path("/fromDb/{id}")
	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Alien getAlien(@PathParam("id") int id) {
		Alien alien = null;
		AlienDao dao = new AlienDao();
		try {
			alien = dao.getAlien(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alien;
	}

	/* Below service method is to save the resource to the DB */
	@Path("/fromDb/save")
	@POST
	@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces(MediaType.TEXT_PLAIN)
	public String saveAlien(Alien alien) {
		AlienDao dao = new AlienDao();
		try {
			dao.saveAlien(alien);
			return "Resource saved successfully..";
		} catch (Exception e) {
			e.printStackTrace();
			return "Unable to save the Resource..";
		}
	}

	/*
	 * Below is the method to update the resource for that we will use the PUT
	 * request type, in this method we would be receiving the alien object and then
	 * will be updating the db record on the basis of that object. Now you can also
	 * send an update request from the client for the object which actually don't
	 * exist in the database so in that you won't get any error on the client side
	 * like using below method you will get resource has been updated successfully
	 * but as the data is not there in the Db so there won't be any update for that
	 * record so now we need to write the method in that way that if record is not
	 * there in DB so we would be sending a message to the client that the record
	 * doesn't exist in the DB or we can do if resource is not available then create
	 * a new resource
	 */

	@Path("fromDb/update")
	@PUT
	@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String updateAlien(Alien alien) {
		AlienDao dao = new AlienDao();

		try {
			/*
			 * So below if block will check if the data exist in the DB and if not will
			 * create a new resource else we will update the existing record
			 */
			if (dao.getAlien(alien.getId()).getId() == 0) {
				dao.saveAlien(alien);
				return "Resource doesn't exist for updation so created a new resource";

			} else {
				dao.updateAlien(alien);
				return "Resource has been updated successfully..";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Unable to update the resource..";
		}
	}

	/* Below method is to delete a resource from DB on the basis of the Id */
	@Path("fromDb/delete")
	@DELETE
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String deleteResource(@QueryParam("id") int id) {
		AlienDao dao = new AlienDao();
		try {
			/*
			 * So the executeUpdate method in dao either returns 1 if the record has been
			 * found or 0 if it is not found so instead of doing the things which we did
			 * above we will use the if block on executeUpdate return value
			 */
			if (dao.deleteAlien(id) == 1) {
				return "Resource has been deleted successfully.";
			} else
				return "Resource hasn't been deleted as it doesn't exist in the DB.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Some exception occured while deleting the resource";
		}
	}
}
