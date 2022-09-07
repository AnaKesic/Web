package web2022.dto;



import java.io.Serializable;

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
public class SportskiObjekatSearchDTO implements Serializable {
	public enum Tip implements Serializable { SVI, TERETANA, BAZEN, SPORTSKI_CENTAR, PLESNI_STUDIO};
	
	public String naziv;
	public String tip;
	public String lokacija;
	public String prosecnaOcena;
	public String samoOtvoreni;
	
	

}
