package web2022.dto;

import web2022.model.Korisnik;

public class KorisnikMenDTO {
	private String ime;
    private String prezime;
 
    
    public KorisnikMenDTO(Korisnik korisnik) {
    	this.ime=korisnik.getIme();
    	this.prezime=korisnik.getPrezime();
    }

}
