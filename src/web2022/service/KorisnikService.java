package web2022.service;

import java.util.ArrayList;

import web2022.dto.KorisnikDTO;
import web2022.dto.TestDTO;
import web2022.model.Korisnik;
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
		if(korisnikDTO == null) {
			return null;
		}
		
		
	    Korisnik k = korisnikRepository.getById(korisnikDTO);
		
		return k;
	}
	
	public Korisnik addUser(KorisnikDTO kDTO) {
//		Test test = new Test(testDTO);
		Korisnik k = new Korisnik();
	    k.setKorisnickoIme(kDTO.getKorisnickoIme());
	    k.setLozinka(kDTO.getLozinka());
		
		Korisnik kk=korisnikRepository.add(k);
		return kk;
	}
	
}
