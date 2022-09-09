package web2022.service;

import java.util.ArrayList;

import web2022.dto.KorisnikDTO;
import web2022.dto.TestDTO;
import web2022.model.Korisnik;
import web2022.model.Korisnik.Uloga;
import web2022.model.Test;
import web2022.repository.KorisniciRepository;
import web2022.repository.TestRepository;

public class KorisnikService {
	private KorisniciRepository korisnikRepository;
	
	public KorisnikService() {
		this.korisnikRepository = new KorisniciRepository();
	}
	
	public ArrayList<Korisnik> getAll() {
		return korisnikRepository.getAll();
	}
    
	public  Korisnik getById(KorisnikDTO korisnikDTO) {
		
		
	    Korisnik k = korisnikRepository.getById(korisnikDTO);
		
		return k;
	}
	
	 public  Korisnik getByIdd(String id) {
			
			
		    Korisnik k = korisnikRepository.getByIdd(id);
			
			return k;
		}
	 
	public Korisnik addUser(KorisnikDTO kDTO) {
//		Test test = new Test(testDTO);
		Korisnik k = new Korisnik(kDTO);
	   // k.setKorisnickoIme(kDTO.getKorisnickoIme());
	    //k.setLozinka(kDTO.getLozinka());
		
		Korisnik kk=korisnikRepository.add(k);
		return kk;
	}
	public  Korisnik settings(KorisnikDTO kDTO) {
		
		
	    Korisnik k = korisnikRepository.update(kDTO);
		
		return k;
	}
	public ArrayList<String> findFreeMenagers(){
		ArrayList<String> slobodni= new ArrayList<String>();
		ArrayList<Korisnik> svi= getAll();
		for (Korisnik k :svi) {
			if(k.getUloga().equals(Uloga.MENADZER)) {
				if(k.getSportskiObjekat().equals("")) {
					slobodni.add(k.getKorisnickoIme());
					
				}
			}
		}
		return slobodni;
	}
}
