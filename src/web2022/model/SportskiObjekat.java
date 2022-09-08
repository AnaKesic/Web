package web2022.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
	
	 private Long id;
	 private String naziv;
	 private Tip tip;
	 private ArrayList<Sadrzaj>sadrzaj;
	 private Status status;
	 private Lokacija lokacija;
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
	
	
	

}
