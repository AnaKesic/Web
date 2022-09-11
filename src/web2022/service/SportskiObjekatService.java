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
import web2022.model.Trening;
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
	public  SportskiObjekat addSportskiObjekat(SportskiObjekatDTO sportskiObjekatDTO) {

		SportskiObjekat sportskiObjekat = new SportskiObjekat(sportskiObjekatDTO);
		sportskiObjekat=this.sportskiObjekatRepository.add(sportskiObjekat);
	       
		
		
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
		SportskiObjekat ret =new SportskiObjekat();
		for(SportskiObjekat s : sportskiObjekti ) {
			if(s.getNaziv().equals(naziv)) {
				ret=s;
				break;
			}
		}
		return ret;
	}
	
	
}
