package web2022.utils;

import spark.Response;

public class Responses
{
	// NOTE(Ana): 200 OK
	public static Response ok(String msg, Response response)
	{
		response.body(msg);
		response.status(200);
		return response;
	}
	
	// NOTE(Ana): 400 Bad request
	public static Response badRequest(String msg, Response response)
	{
		response.body(msg);
		response.status(400);
		return response;
	}
	
	// NOTE(Ana): 401 Unauthorized
	public static Response unauthorized(String msg, Response response)
	{
		response.body(msg);
		response.status(401);
		return response;
	}
	
	// NOTE(Ana): 403 Forbidden
	public static Response forbidden(String msg, Response response)
	{
		response.body(msg);
		response.status(403);
		return response;
	}

	// NOTE(Ana): 404 Not found
	public static Response notFound(String msg, Response response)
	{
		response.body(msg);
		response.status(404);
		return response;
	}
	
	// NOTE(Ana): 500 Internal server error
	public static Response serverError(String msg, Response response)
	{
		response.body(msg);
		response.status(500);
		return response;
	}
}
