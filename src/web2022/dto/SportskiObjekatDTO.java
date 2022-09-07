package web2022.dto;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.model.Lokacija;
import web2022.model.SportskiObjekat.Sadrzaj;
import web2022.model.SportskiObjekat.Status;
import web2022.model.SportskiObjekat.Tip;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SportskiObjekatDTO {
	
	private Long id;
	private String naziv;
	private String tip;
	private String sadrzaj;
	private String status;
	private Lokacija lokacija;
	private String logoObjekta;
	private double prosecnaOcena;
	private String pocetakRadnogVremena;
	private String krajRadnogVremena;

}
