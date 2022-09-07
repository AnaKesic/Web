package web2022.model;

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
public class Lokacija {
	private double geografskaDuzina;
	private double geografskaSirina;
	private String adresa;

}
