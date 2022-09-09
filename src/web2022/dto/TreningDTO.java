package web2022.dto;



import web2022.model.Trening;

public class TreningDTO {
	private static final long serialVersionUID = 7688413004133167026L;
	
	private String naziv;
	private String tipTreninga;
	private String objekatGdePripada;
	private double trajanje;
	private String opis;
	private String slika;
	
	public TreningDTO(Trening trening) {
		this.naziv = trening.getNaziv();
		this.tipTreninga = trening.getTipTreninga();
		this.objekatGdePripada = trening.getObjekatGdePripada();
		this.trajanje = trening.getTrajanje(); //da li trba kastovati
		this.opis = trening.getOpis();
		this.slika = trening.getSlika();
	}

}
