package web2022.service;

import java.util.ArrayList;


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

	public ArrayList<Korisnik> getTreneri(String naziv) {
		ArrayList<Korisnik> treneri = new ArrayList<Korisnik>();
		for (Trening t : getAll()) {
			if(t.getObjekatGdePripada().toLowerCase().equals(naziv.toLowerCase())) {
				 
				if (t.getTrener() != null) {
					
						treneri.add(t.getTrener());
					
				
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
	public ArrayList<Trening> getbynaziv(String naziv){
		ArrayList<Trening> svi=getAll();
		ArrayList<Trening> povrat=new ArrayList<Trening>();
		for(Trening t:svi) {
			if(t.getObjekatGdePripada().equals(naziv)) {
				povrat.add(t);
			}
			
		}
		   System.out.println("ana");
		   return povrat;
	   }

	
	

}
