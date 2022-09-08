package web2022.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.model.Lokacija;

import web2022.model.SportskiObjekat.Status;
import web2022.model.SportskiObjekat.Tip;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SportskiObjekatDTO {
	public enum Sadrzaj  implements Serializable{GRUPNI_TRENING, PERSONALNI_TRENING, SAUNA};
	
	private Long id;
	private String naziv;
	private String tip;
	private ArrayList<Sadrzaj> sadrzaj;
	private String status;
	private Lokacija lokacija;
	private String logoObjekta;
	private double prosecnaOcena;
	private String pocetakRadnogVremena;
	private String krajRadnogVremena;

}
