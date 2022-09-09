package web2022.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.model.Clanarina;
import web2022.model.SportskiObjekat;
import web2022.model.Trening;
import web2022.model.Korisnik.Pol;
import web2022.model.Korisnik.TipKupca;
import web2022.model.Korisnik.Uloga;

@AllArgsConstructor
@NoArgsConstructor
@Setter
 @Getter

public class KorisnikDTO {
	private String kIme;  // jedinstveno
	private String sifra;
	private String ime;
    private String prezime;
    private String rodjendan;
    private String pol;
    private Uloga uloga;
    private String sportskiObjekat;

}
