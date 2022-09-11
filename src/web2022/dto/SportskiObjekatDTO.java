package web2022.dto;


import java.util.ArrayList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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

	

	private String naziv;
	private String tip;
	private String lokacija;
	private String logo;
	private String pocetnoVreme;
	private String krajnjeVreme;
	private ArrayList<String> sadrzaj;
//=======
//	public enum Sadrzaj  implements Serializable{GRUPNI_TRENING, PERSONALNI_TRENING, SAUNA};
//	
//	private Long id;
//	private String naziv;
//	private String tip;
//	private ArrayList<Sadrzaj> sadrzaj;
//	private String status;
//	private Lokacija lokacija;
//	private String logoObjekta;
//	private double prosecnaOcena;
//	private String pocetakRadnogVremena;
//	private String krajRadnogVremena;
//>>>>>>> 69026b77dc754417569b48ecfa13205fb810d003

}
