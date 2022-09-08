package web2022.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;


import io.jsonwebtoken.lang.Arrays;
import web2022.model.Korisnik.Pol;
import web2022.model.Korisnik.TipKupca;
import web2022.model.Korisnik.Uloga;

import web2022.dto.SportskiObjekatDTO;
import web2022.dto.SportskiObjekatSearchDTO;
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
	     setStatuss(sportskiObjekti);
	     Collections.sort(sportskiObjekti);
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
		if(sportskiObjekatDTO.getSadrzaj().equals("GRUPNI TRENING")) {
			sportskiObjekat.getSadrzaj().add(Sadrzaj.GRUPNI_TRENING);
		}else if(sportskiObjekatDTO.getSadrzaj().equals("PERSONALNI TRENING")) {
			sportskiObjekat.getSadrzaj().add(Sadrzaj.PERSONALNI_TRENING);
		} else if(sportskiObjekatDTO.getSadrzaj().equals("SAUNA")) {
			sportskiObjekat.getSadrzaj().add(Sadrzaj.SAUNA);
		}
		
		
		
		if(sportskiObjekatDTO.getStatus().equals("OTVORENO")) {
			sportskiObjekat.setStatus(Status.OTVORENO);
		} else if(sportskiObjekatDTO.getStatus().equals("ZATVORENO")) {
			sportskiObjekat.setStatus(Status.ZATVORENO);
		}
		
		
	
		
		sportskiObjekat.setLokacija(sportskiObjekatDTO.getLokacija());
		sportskiObjekat.setLogoObjekta(sportskiObjekatDTO.getLogoObjekta());
		sportskiObjekat.setProsecnaOcena(sportskiObjekatDTO.getProsecnaOcena());
		sportskiObjekat.setPocetakRadnogVremena(sportskiObjekatDTO.getPocetakRadnogVremena());
		sportskiObjekat.setKrajRadnogVremena(sportskiObjekatDTO.getKrajRadnogVremena());

		sportskiObjekatRepository.add(sportskiObjekat);
		return sportskiObjekat;
	}

	public ArrayList<SportskiObjekat> search(SportskiObjekatSearchDTO ss) {
	
		ArrayList<SportskiObjekat> trazeniObjekti = new ArrayList<SportskiObjekat>();
		for(SportskiObjekat so: getAll()) {
			if(so.getNaziv().toLowerCase().contains(ss.naziv.toLowerCase())){
				if(so.getLokacija().getAdresa().toLowerCase().contains(ss.lokacija.toLowerCase())){
					if(so.getTip().name().toString().toLowerCase().contains(ss.tip.toLowerCase())
						|| ss.tip.equals("SVI")){
						if(((int)so.getProsecnaOcena() >= (Integer.parseInt(ss.prosecnaOcena)))) {
							if(Boolean.parseBoolean(ss.samoOtvoreni)) {
								if(so.getStatus() == Status.OTVORENO) {
									trazeniObjekti.add(so);
								}
							}
							else {
							
							trazeniObjekti.add(so);
							}
				}
				
			}
				}
		
			
			}
		}
		
		return trazeniObjekti;
	}
	public void setStatuss(ArrayList<SportskiObjekat> sos) {
		
		for(SportskiObjekat so:sos) {
			LocalTime now = LocalTime.now();
			LocalTime lt=LocalTime.of(now.getHour(), now.getMinute());
			
			LocalTime prv=LocalTime.parse(so.getPocetakRadnogVremena());
		
			LocalTime krv=LocalTime.parse(so.getKrajRadnogVremena());
			
			
			
			if(lt.isBefore(prv)) 
				so.setStatus(Status.ZATVORENO);
			else if(lt.isAfter(krv)) {
					so.setStatus(Status.ZATVORENO);
			     }
			
			
			else {
				so.setStatus(Status.OTVORENO);
			}
			
		}
		
		return;
		
	}
	public SportskiObjekat getByName(String naziv) {
		ArrayList<SportskiObjekat> sportskiObjekti =getAll();
		SportskiObjekat ret = null;
		for(SportskiObjekat s : sportskiObjekti ) {
			if(s.getNaziv().equals(naziv)) {
				ret=s;
				break;
			}
		}
		return ret;
	}
}
