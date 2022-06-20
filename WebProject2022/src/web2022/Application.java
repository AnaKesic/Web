package web2022;

import java.io.File;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web2022.controller.SportskiObjekatController;
import web2022.controller.TestController;
import web2022.service.SportskiObjekatService;
import web2022.service.TestService;

import web2022.utils.LocalDateTimeDeserializer;
import web2022.utils.LocalDateTimeSerializer;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.delete;
import static spark.Spark.put;
import static spark.Spark.staticFiles;

public class Application {
	
	private static GsonBuilder gsonBuilder = new GsonBuilder();
	
	public static Gson gson;

	public static File uploadDir;
	
	public static TestService testService;
	
	public static SportskiObjekatService sportskiObjekatService;
	
	public static Route serveStaticResource = (Request request, Response response) ->
	{
		response.redirect("/static/index.html");
		return response;
	};
	
	private static void enableCORS(final String origin, final String methods, final String headers) {

	    options("/*", (request, response) -> {

	        String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
	        if (accessControlRequestHeaders != null) {
	            response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
	        }

	        String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
	        if (accessControlRequestMethod != null) {
	            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
	        }

	        return "OK";
	    });

	    before((request, response) -> {
	        response.header("Access-Control-Allow-Origin", origin);
	        response.header("Access-Control-Request-Method", methods);
	        response.header("Access-Control-Allow-Headers", headers);
	        // Note: this may or may not be necessary in your particular application
	        response.type("application/json");
	    });
	}
	
	public static Gson createCustomGson() {
		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
		Gson gson = gsonBuilder.create();
		return gson;
	}
	
	public static void main(String args[])
	{
		gson = createCustomGson();
		
		testService = new TestService();
		sportskiObjekatService = new SportskiObjekatService();
		
		uploadDir = new File(System.getProperty("user.dir") + "/upload");
		uploadDir.mkdir();

		port(8080);
//		uncomment if creating jar
//		staticFiles.location("/static");

//		comment if creating jar
		staticFiles.externalLocation(System.getProperty("user.dir") + "/static");
		
		enableCORS("*", "*", "*");
		
		get("/", serveStaticResource);
		
		post("rest/test/add-test", TestController.addTest);
		post("rest/sportski-objekat/add-sportski-objekat", SportskiObjekatController.addSportskiObjekat);
		
		put("rest/test/update-test", TestController.updateTest);
		
		get("rest/test/get-all", TestController.getAll);
		get("rest/sportski-objekat/get-all", SportskiObjekatController.getAll);
		get("rest/sportski-objekat/search/:naziv/:tip/:lokacija/:prosecna-ocena", SportskiObjekatController.search);
		
		delete("rest/test/delete-test/:id", TestController.deleteTest);
		
		get("*", (request, response) ->
		{
			System.out.println("Redirecting...");
			response.redirect("/");
			return response;
		});
	}
}