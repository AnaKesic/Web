package web2022.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.model.Korisnik.Pol;
import web2022.model.Korisnik.TipKupca;
import web2022.model.Korisnik.Uloga;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter



public class Clanarina implements Serializable {

	
	//private static final long serialVersionUID = 6290862293337771303L;
	
	public enum TipCl implements Serializable { MESECNA, GODISNJA};
	
	private  TipCl tip;
	private  LocalDateTime datumPlacanja;
	private  LocalDateTime datumVazenja;
	private  int cena;
	private  String korisnik;
	private  boolean status;
	private  int brTermina;
	
	
	

	
	

}
