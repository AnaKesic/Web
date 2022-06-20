package web2022.controller;

import static web2022.Application.gson;
import static web2022.Application.korisnikService;
import static web2022.utils.Responses.serverError;

import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;
import web2022.dto.KorisnikDTO;
import web2022.model.Korisnik;
import web2022.model.Test;
import web2022.service.KorisnikService;

public class KorisnikController {


	public static Route getbyID = (Request request, Response response) -> {
		String payload = request.body();
		KorisnikDTO testDTO = gson.fromJson(payload, KorisnikDTO.class);
		Korisnik kor = korisnikService.getById(testDTO);
		if(kor ==null) {
			return serverError("user doesnt exist", response);
		}
		
		String returnToFront = gson.toJson(kor);
		return returnToFront;
	};
	
	public static Route addUser = (Request request, Response response) -> {
		String payload = request.body();
		KorisnikDTO testDTO = gson.fromJson(payload, KorisnikDTO.class);
		Korisnik k = korisnikService.addUser(testDTO);
		if(k == null) {
			return serverError("user with same id already exist", response);
		}
		String returnToFront = gson.toJson(k);
		return returnToFront;
	};
	

}
