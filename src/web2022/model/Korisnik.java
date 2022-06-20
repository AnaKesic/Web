package web2022.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.dto.KorisnikDTO;
import web2022.dto.TestDTO;
import web2022.dto.UserDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter



public class Korisnik implements Serializable {

	
	private static final long serialVersionUID = 4205893040112416905L;
	public enum Pol implements Serializable { MUSKI, ZENSKI};
	public enum Uloga implements Serializable { ADMINISTRATOR, MENADZER, DOSTAVLJAC, KUPAC};
	public enum TipKupca implements Serializable { ZLATNI, SREBRNI, BRONZANI};
	private float id = System.currentTimeMillis();
	private String korisnickoIme;  // jedinstveno
	private String lozinka;
	private String ime;
	private String prezime;
	private Pol pol;
	private String datumRodjenja;  // yyyy-MM-dd
	private Uloga uloga;
	private ArrayList<Trening> istorijaTreninga;	
	private Clanarina clanarina;  // za korisnika
	private SportskiObjekat sportskiObjekat; // za menadzera
	private ArrayList<SportskiObjekat> poseceniObjekti; // sve porudzbine dostavljaca koje treba da dostavi
	private double brojSakupljenihBodova;
	private TipKupca tipKupca;
	private double popust; // u procentima
	private double trazeniBrojBodova; // npr. broj bodova da bi postao Zlatni kupac
	private boolean blokiran;
	private boolean obrisan;
	
	public Korisnik(KorisnikDTO kDTO) {
		this.korisnickoIme = kDTO.getKorisnickoIme();
		this.lozinka = kDTO.getLozinka();
		this.ime="";
		this.prezime="";
		this.pol=Pol.MUSKI;
		this.datumRodjenja="";
		this.uloga=Uloga.KUPAC;
		this.istorijaTreninga= new ArrayList<Trening>() ;
		this.clanarina=new Clanarina();
		this.sportskiObjekat=new SportskiObjekat();
		this.poseceniObjekti=new ArrayList<>();
		this.brojSakupljenihBodova=0;
		this.tipKupca=TipKupca.BRONZANI;
		this.popust=0;
		this.trazeniBrojBodova=0;
		this.blokiran=false;
		this.obrisan=false;
		
		
	}

}
