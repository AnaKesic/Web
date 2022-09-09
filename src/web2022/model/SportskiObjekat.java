package web2022.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.dto.SportskiObjekatDTO;
import web2022.model.Korisnik.Pol;
import web2022.model.Korisnik.TipKupca;
import web2022.model.Korisnik.Uloga;
import com.google.gson.annotations.Expose;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SportskiObjekat implements Serializable, Comparable<SportskiObjekat>{

	
	private static final long serialVersionUID = 7688413004133167026L;
	
	public enum Tip implements Serializable { SVI, TERETANA, BAZEN, SPORTSKI_CENTAR, PLESNI_STUDIO};
	public enum Status implements Serializable { OTVORENO,ZATVORENO};
	public enum Sadrzaj  implements Serializable{GRUPNI_TRENING, PERSONALNI_TRENING, SAUNA};
	
	 private Long id= System.currentTimeMillis();;
	 private String naziv;
	 private Tip tip;
	 private ArrayList<Sadrzaj> sadrzaj= new ArrayList<Sadrzaj>();
	 private Status status;
	 private Lokacija lokacija= new Lokacija();
	 private String logoObjekta;
	 private double prosecnaOcena;
	 private String pocetakRadnogVremena;
	 private String krajRadnogVremena;
	@Override
	public int compareTo(SportskiObjekat o) {
		 if( o.getStatus()==Status.OTVORENO)
	            return 1;
	        else 
	            return -1 ;
		
	}
	public SportskiObjekat(SportskiObjekatDTO SO) {
		
	
		this.naziv = SO.getNaziv();
		if(SO.getTip().equals(Tip.BAZEN)) {
			this.tip=Tip.BAZEN;
		}
		if(SO.getTip().equals(Tip.PLESNI_STUDIO)) {
			this.tip=Tip.PLESNI_STUDIO;
		}
		if(SO.getTip().equals(Tip.SPORTSKI_CENTAR)) {
			this.tip=Tip.SPORTSKI_CENTAR;
		}
		if(SO.getTip().equals(Tip.SVI)) {
			this.tip=Tip.SVI;
		}
		if(SO.getTip().equals(Tip.TERETANA)) {
			this.tip=Tip.TERETANA;
		}
		for (String s:SO.getSadrzaj()) {
			
			if(s.equals("Grupni trening")) {
				this.sadrzaj.add(Sadrzaj.GRUPNI_TRENING);
			}
			if(s.equals("Personalni trening")) {
				this.sadrzaj.add(Sadrzaj.PERSONALNI_TRENING);
			}
			if(s.equals("Sauna")) {
				this.sadrzaj.add(Sadrzaj.SAUNA);
			}
		}
		
		this.lokacija.setAdresa(SO.getLokacija());
		this.logoObjekta = SO.getLogo();
		this.prosecnaOcena = 0;
		this.pocetakRadnogVremena = SO.getPocetnoVreme();
		this.krajRadnogVremena = SO.getKrajnjeVreme();
	}
	
	
	

}
