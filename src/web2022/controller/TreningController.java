package web2022.controller;

import static web2022.Application.gson;
import static web2022.Application.korisnikService;
import static web2022.Application.treningService;
import static web2022.utils.Responses.serverError;

import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;
import web2022.dto.KorisnikDTO;
import web2022.dto.KorisnikIspisDTO;
import web2022.dto.TreningDTO;
import web2022.model.Korisnik;
import web2022.model.Trening;

public class TreningController {
	
	public static Route addTrening = (Request request, Response response) -> {
		String payload = request.body();
		TreningDTO testDTO = gson.fromJson(payload, TreningDTO.class);
		Trening k = treningService.addUser(testDTO);
		if(k == null) {
			return serverError("user with same id already exist", response);
		}
		String returnToFront = gson.toJson(k);
		return returnToFront;
	};
	 public static Route  getTreneriZaSportskiObjekat =(Request request, Response response) -> {
		 String naziv = request.params(":naziv");
		 ArrayList<Korisnik> treneri = treningService.getTreneri(naziv);
		 ArrayList<KorisnikIspisDTO> trenerifront= new ArrayList<KorisnikIspisDTO>();
		 for(Korisnik k:treneri) {
			 
			 KorisnikIspisDTO kk=new KorisnikIspisDTO();
			 kk.setIme(k.getIme());
			 kk.setKIme(k.getKorisnickoIme());
			 kk.setPrezime(k.getPrezime());
			 trenerifront.add(kk);
			 
		 }
			String returnToFront = gson.toJson(trenerifront);
			return returnToFront;
			
		
		 
	 };
	 public static Route  getTreninziZaSportskiObjekat =(Request request, Response response) -> {
		 String naziv = request.params(":naziv");
		 ArrayList<Trening> treninzi = treningService.getTreninzi(naziv);
		 ArrayList<TreningDTO> treninzidto= new ArrayList<TreningDTO>();
		 for(Trening k:treninzi) {
			 treninzidto.add(new TreningDTO(k));
			
			 
		 }
			String returnToFront = gson.toJson(treninzidto);
			return returnToFront;
			
		
		 
	 };
	 public static Route  getTreninziZaTrenera =(Request request, Response response) -> {
		 String kIme = request.params(":kIme");
		 ArrayList<Trening> treninzi = treningService.getTreninziZaTrenera(kIme);
		 ArrayList<TreningDTO> treninzidto= new ArrayList<TreningDTO>();
		 for(Trening k:treninzi) {
			 treninzidto.add(new TreningDTO(k));
			
			 
		 }
			String returnToFront = gson.toJson(treninzidto);
			return returnToFront;
			
		
		 
	 };

}
