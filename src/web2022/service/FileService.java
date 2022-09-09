package web2022.service;
 
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
 
import spark.Request;
 
public class FileService {
 
	private String projectFoder = System.getProperty("user.dir");
	private String staticFolder = "/static";
	private String uploadFolder = "/files/upload";
 
	private String path = projectFoder + staticFolder + uploadFolder;
 
	private long maxFileSize = 100000000;
	private long maxRequestSize = 100000000;
	private int fileSizeThreshold = 1024;
 
	public String upload(Request request) throws IOException, ServletException {
 
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(path, maxFileSize, maxRequestSize, fileSizeThreshold);
 
		 request.raw().setAttribute("org.eclipse.jetty.multipartConfig", multipartConfigElement);
 
		 String fName = request.raw().getPart("file").getSubmittedFileName();
 
		 System.out.println("Uploading file: " + fName + " to: " + path);
 
		 Part uploadedFile = request.raw().getPart("file");
		 Path out = Paths.get(path + "/" + fName);
		 try (final InputStream in = uploadedFile.getInputStream()) {
		    Files.copy(in, out);
		    System.out.println("File: " + fName + " is uploaded to: " + path);
		 } catch (FileAlreadyExistsException exception) {
			 System.out.println("File: " + fName + " is already uploaded. Skipping...");
		 }
 
		 // Cleanup
		 uploadedFile.delete();
		 multipartConfigElement = null;
		 uploadedFile = null;
 
		 return uploadFolder +  "/" + fName;
    }
}