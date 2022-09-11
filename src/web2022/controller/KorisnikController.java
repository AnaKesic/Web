package web2022.controller;

import static web2022.Application.gson;
import static web2022.Application.korisnikService;
import static web2022.utils.Responses.serverError;

import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;
import web2022.dto.ClanarinaDTO;
import web2022.dto.KorisnikDTO;
import web2022.model.Korisnik;
import web2022.model.Test;
import web2022.service.KorisnikService;

public class KorisnikController {


	public static Route getAll = (Request request, Response response) -> {
		
		ArrayList<Korisnik> kor = korisnikService.getAll();
		
		if(kor ==null) {
			return serverError("empty", response);
		}
		
		String returnToFront = gson.toJson(kor);
		return returnToFront;
	};
	
	public static Route getbyID = (Request request, Response response) -> {
		String payload = request.body();
		KorisnikDTO testDTO = gson.fromJson(payload, KorisnikDTO.class);
		Korisnik kor = korisnikService.getById(testDTO);
		
		if(kor ==null) {
			return serverError("test with same id already exist", response);
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
	public static Route getbyIDD = (Request request, Response response) -> {
		String id = request.params(":id");
		
		Korisnik kor = korisnikService.getByIdd(id);
		
		if(kor ==null) {
			return serverError("test with same id already exist", response);
		}
		
		String returnToFront = gson.toJson(kor);
		return returnToFront;
	};
	 public static Route  settings =(Request request, Response response) -> {
		 String payload = request.body();
		KorisnikDTO testDTO = gson.fromJson(payload, KorisnikDTO.class);
		Korisnik k = korisnikService.settings(testDTO);
		if(k == null) {
			return serverError("user with same id already exist", response);
		}
		String returnToFront = gson.toJson(k);
		return returnToFront;
		 
	 };
	 public static Route  getFreeMenagers =(Request request, Response response) -> {
		 
		 ArrayList<String> menagers= korisnikService.findFreeMenagers();
		 String returnToFront = gson.toJson(menagers);
		 return returnToFront;
			 
		 
	 };
	 public static Route addClanarina = (Request request, Response response) -> {
		    String payload = request.body();
		    ClanarinaDTO clan = gson.fromJson(payload, ClanarinaDTO.class);
			Korisnik kor = korisnikService.addClanarina(clan);
			
			if(kor ==null) {
				return serverError("test with same id already exist", response);
			}
			
			String returnToFront = gson.toJson(kor);
			System.out.println(returnToFront);
			return returnToFront;
		};
}
