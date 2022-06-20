package web2022.service;

import java.util.ArrayList;

import web2022.model.Korisnik.Pol;
import web2022.model.Korisnik.TipKupca;
import web2022.model.Korisnik.Uloga;

import web2022.dto.SportskiObjekatDTO;
import web2022.dto.TestDTO;
import web2022.model.SportskiObjekat;
import web2022.model.SportskiObjekat.Sadrzaj;
import web2022.model.SportskiObjekat.Status;
import web2022.model.SportskiObjekat.Tip;
import web2022.model.Test;
import web2022.repository.SportskiObjekatRepository;
import web2022.repository.TestRepository;

public class SportskiObjekatService {
	
	private SportskiObjekatRepository sportskiObjekatRepository;
	
	public SportskiObjekatService() {
		this.sportskiObjekatRepository = new SportskiObjekatRepository();
	}
	
	public ArrayList<SportskiObjekat> getAll() {
		 ArrayList<SportskiObjekat> sportskiObjekti = sportskiObjekatRepository.getAll();
		 return sportskiObjekti;
	}
	public SportskiObjekat addSportskiObjekat(SportskiObjekatDTO sportskiObjekatDTO) {
//		Test test = new Test(testDTO);
		SportskiObjekat sportskiObjekat = new SportskiObjekat();
		sportskiObjekat.setId(System.currentTimeMillis());
		sportskiObjekat.setNaziv(sportskiObjekatDTO.getNaziv());
		
		if(sportskiObjekatDTO.getTip().equals("Teretana")) {
			sportskiObjekat.setTip(Tip.TERETANA);
		} else if(sportskiObjekatDTO.getTip().equals("Bazen")) {
			sportskiObjekat.setTip(Tip.BAZEN);
		} else if(sportskiObjekatDTO.getTip().equals("Sportski centar")) {
			sportskiObjekat.setTip(Tip.SPORTSKI_CENTAR);
		} else if(sportskiObjekatDTO.getTip().equals("Plesni studio")) {
			 sportskiObjekat.setTip(Tip.PLESNI_STUDIO);
		}
		
		if(sportskiObjekatDTO.getStatus().equals("Radi")) {
			sportskiObjekat.setStatus(Status.RADI);
		} else if(sportskiObjekatDTO.getStatus().equals("Ne radi")) {
			sportskiObjekat.setStatus(Status.NE_RADI);
		}
		
		if(sportskiObjekatDTO.getSadrzaj().equals("Grupni trening")) {
			sportskiObjekat.setSadrzaj(Sadrzaj.GRUPNI_TRENING);
		} else if(sportskiObjekatDTO.getSadrzaj().equals("Personalni trening")) {
			sportskiObjekat.setSadrzaj(Sadrzaj.PERSONALNI_TRENING);
		} else if(sportskiObjekatDTO.getSadrzaj().equals("Sauna")) {
			sportskiObjekat.setSadrzaj(Sadrzaj.SAUNA);
		}
	
		
		sportskiObjekat.setLokacija(sportskiObjekatDTO.getLokacija());
		sportskiObjekat.setLogoObjekta(sportskiObjekatDTO.getLogoObjekta());
		sportskiObjekat.setProsecnaOcena(sportskiObjekatDTO.getProsecnaOcena());
		sportskiObjekat.setPocetakRadnogVremena(sportskiObjekatDTO.getPocetakRadnogVremena());
		sportskiObjekat.setKrajRadnogVremena(sportskiObjekatDTO.getKrajRadnogVremena());

		sportskiObjekatRepository.add(sportskiObjekat);
		return sportskiObjekat;
	}

	public ArrayList<SportskiObjekat> search(String naziv, String tip, String lokacija, String prosecnaOcena) {
		ArrayList<SportskiObjekat> trazeniObjekti = new ArrayList<SportskiObjekat>();
		for(SportskiObjekat so: getAll()) {
			if(so.getNaziv().toLowerCase().contains(naziv.toLowerCase()) &&
			so.getLokacija().getAdresa().toLowerCase().contains(lokacija.toLowerCase())) {
				if(so.getProsecnaOcena() == Double.parseDouble(prosecnaOcena) || prosecnaOcena.equals("0")) {
					trazeniObjekti.add(so);
				}
				
			}
		}
		
		return trazeniObjekti;
	}
}
