package web2022.controller;

import static web2022.Application.gson;
import static web2022.Application.sportskiObjekatService;
import static web2022.Application.testService;
import static web2022.utils.Responses.serverError;

import java.util.ArrayList;


import spark.Request;
import spark.Response;
import spark.Route;
import web2022.dto.SportskiObjekatDTO;
import web2022.dto.SportskiObjekatSearchDTO;
import web2022.dto.TestDTO;
import web2022.model.SportskiObjekat;
import web2022.model.Test;

import web2022.model.Trening;


public class SportskiObjekatController {
	
	public static Route getAll = (Request request, Response response) -> {
		
		ArrayList<SportskiObjekat> sportskiObjekti = sportskiObjekatService.getAll();
		String returnToFront = gson.toJson(sportskiObjekti);
		return returnToFront;
	};
	
	public static Route addSportskiObjekat = (Request request, Response response) -> {
		String payload = request.body();
		SportskiObjekatDTO sportskiObjekatDTO = gson.fromJson(payload, SportskiObjekatDTO.class);
		SportskiObjekat newSportskiObjekat = sportskiObjekatService.addSportskiObjekat(sportskiObjekatDTO);
		if(newSportskiObjekat == null) {
			return serverError("sportski objekat sa istim id postoji", response);
		}
		String returnToFront = gson.toJson(newSportskiObjekat);
		return returnToFront;
	};
	

	

	public static Route search = (Request request, Response response) -> {
		System.out.print("why");
		String naziv = request.queryParams("naziv");
		String tip= request.queryParams("tip");
		String lokacija = request.queryParams("lokacija");
		String prosecnaOcena = request.queryParams("prosecnaOcena");
		String samoOtvoreni = request.queryParams("samoOtvoreni");
		SportskiObjekatSearchDTO parametres = new SportskiObjekatSearchDTO(naziv, tip, lokacija, prosecnaOcena, samoOtvoreni);
		ArrayList<SportskiObjekat> sportskiObjekti = sportskiObjekatService.search(parametres);
		String returnToFront = gson.toJson(sportskiObjekti);
		return returnToFront;
	};

	public static Route ucitajObjMen = (Request request, Response response) -> {
 	String naziv = request.params(":naziv");
		SportskiObjekat sportskiObjekat = sportskiObjekatService.getByName(naziv);
	
		String returnToFront = gson.toJson(sportskiObjekat);
		return returnToFront;
	};

	
	
	

}
