package web2022.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.dto.TreningDTO;
import web2022.model.SportskiObjekat.Sadrzaj;
import web2022.model.SportskiObjekat.Status;
import web2022.model.SportskiObjekat.Tip;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter



public class Trening implements Serializable {
	
	private static final long serialVersionUID = 7688413004133167026L;
	private Long id;
	private String naziv;
	private String tipTreninga;
	private String objekatGdePripada;
	private int trajanje;
	private Korisnik trener;
	private String opis;
	private String slika;
	
    public Trening(TreningDTO tDTO) {
		
		this.naziv = tDTO.getNaziv();
		this.tipTreninga = tDTO.getTipTreninga();
		this.objekatGdePripada = tDTO.getObjekatGdePripada();
		this.trajanje = tDTO.getTrajanje(); //da li trba kastovati
		this.trener = new Korisnik();
		this.opis = tDTO.getOpis();
		this.slika = tDTO.getSlika();
			
		
	}
	
	

}
