package web2022.controller;
import static web2022.Application.fileService;
import spark.Request;
import spark.Response;
import spark.Route;

public class FileController {
	public static Route upload = (Request request, Response response) -> {
        return fileService.upload(request);
    };
}
