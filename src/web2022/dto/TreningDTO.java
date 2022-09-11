package web2022.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.model.Korisnik;
import web2022.model.Trening;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


public class TreningDTO {
	private static final long serialVersionUID = 7688413004133167026L;
	
	private String naziv;
	private String tipTreninga;
	private String objekatGdePripada;
	private double trajanje;
	public String nazivTrenera;
	private String opis;
	private String slika;
	
	public TreningDTO(Trening trening) {
		this.naziv = trening.getNaziv();
		this.tipTreninga = trening.getTipTreninga();
		this.objekatGdePripada = trening.getObjekatGdePripada();
		this.trajanje = trening.getTrajanje(); //da li trba kastovati
		this.nazivTrenera = trening.getTrener().getKorisnickoIme();
		this.opis = trening.getOpis();
		this.slika = trening.getSlika();
	


	}
	public TreningDTO(String objekat,String tip) {
		
		
		this.objekatGdePripada = objekat;
		this.tipTreninga = tip;
		
		
	}
}
