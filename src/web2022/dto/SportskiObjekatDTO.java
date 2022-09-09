package web2022.dto;

import java.util.ArrayList;

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

}
