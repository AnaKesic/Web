package web2022.model;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


public class IstorijaTreninga {
	private float id = System.currentTimeMillis();
	private LocalDateTime datumVremePrijave;
	private Trening trening;
	private Korisnik kupac;
	private Korisnik trener;


}
