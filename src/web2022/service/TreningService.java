package web2022.service;

import java.util.ArrayList;

import web2022.dto.KorisnikDTO;
import web2022.dto.TreningDTO;
import web2022.model.Korisnik;
import web2022.model.Trening;

import web2022.repository.TreninziRepository;


public class TreningService {
private TreninziRepository treningRepository;
	
	public TreningService() {
		this.treningRepository = new TreninziRepository();
	}
	
	public ArrayList<Trening> getAll() {
		return treningRepository.getAll();
	}
	public Trening addUser(TreningDTO kDTO) {
//		Test test = new Test(testDTO);
		Trening k = new Trening(kDTO);
	   // k.setKorisnickoIme(kDTO.getKorisnickoIme());
	    //k.setLozinka(kDTO.getLozinka());
		
		Trening kk=treningRepository.add(k);
		return kk;
	}

	public ArrayList<Korisnik> getTreneri(String naziv) {
		ArrayList<Korisnik> treneri = new ArrayList<Korisnik>();
		ArrayList<String> naz =new ArrayList<String>() ;
		
		for (Trening t : getAll()) {
			if(t.getObjekatGdePripada().toLowerCase().equals(naziv.toLowerCase())) {
				 
				if (t.getTrener() != null) {
					if(!naz.contains(t.getTrener().getKorisnickoIme())){
					
						treneri.add(t.getTrener());
						naz.add(t.getTrener().getKorisnickoIme());
					}
				
			}
		}
		}
		return treneri;
	}
	public ArrayList<Trening> getTreninzi(String naziv) {
		ArrayList<Trening> treninzi = new ArrayList<Trening>();
		for (Trening t : getAll()) {
			if(t.getObjekatGdePripada().toLowerCase().equals(naziv.toLowerCase())) {
				 
				if (t.getTrener() != null) {
					
					treninzi.add(t);
					
				
			}
		}
		}
		return treninzi;
	}
	public ArrayList<Trening> getTreninziZaTrenera(String naziv) {
		ArrayList<Trening> treninzi = new ArrayList<Trening>();
		for (Trening t : getAll()) {
			if(t.getTrener().getKorisnickoIme().toLowerCase().equals(naziv.toLowerCase())) {
				 
				if (t.getTrener() != null) {
					
					treninzi.add(t);
					
				
			}
		}
		}
		return treninzi;
	}
	
	

}
