package web2022.repository;
import static web2022.Application.gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import web2022.dto.KorisnikDTO;
import web2022.model.Korisnik;
import web2022.model.Korisnik.Pol;

public class KorisniciRepository {
private String filename;
	
	public KorisniciRepository() {
		this.filename = "users.json";
		this.initFile();
	}
	
	private void initFile()
	{
		File file = new File(this.filename);
		if (!file.isFile()) {
			this.saveAll(new ArrayList<Korisnik>());
		}}
	
	
		private void saveAll(Collection<Korisnik> k)
		{
			try (FileWriter writer = new FileWriter(this.filename)) {
				gson.toJson(k, writer);
			} catch (JsonIOException | IOException e) {
				// e.printStackTrace();
				System.out.println("There was an error trying to save to file tests.json!");
			}
		}
		
		public  ArrayList<Korisnik> getAll() {
			ArrayList<Korisnik> tests = null;
			Type collectionType = new TypeToken<Collection<Korisnik>>(){}.getType();
			try(FileReader freader = new FileReader(this.filename); JsonReader jreader = new JsonReader(freader)) {
				tests = gson.fromJson(jreader, collectionType);
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("There was an error trying to read from file tests.json!");
			}
			if(tests == null) {
				return new ArrayList<Korisnik>();
			}
			else {
				tests.removeIf(t -> t.isObrisan());
				return tests;
			}
		}
		
		public Korisnik add(Korisnik newTest) {
			ArrayList<Korisnik> tests = getAll();
			boolean exist = false;
			for(Korisnik test : tests) {
				if(test.getKorisnickoIme().equals(newTest.getKorisnickoIme())) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				tests.add(newTest);
				saveAll(tests);
				return newTest;
			}
			return null;
		}
		
	public  Korisnik update(KorisnikDTO K)
		{
			ArrayList<Korisnik> tests = (ArrayList<Korisnik>) this.getAll();
			for (int i = 0; i < tests.size(); i++) {
				if(tests.get(i).getKorisnickoIme().equals(K.getKIme())) {
					tests.get(i).setDatumRodjenja(K.getRodjendan());
					tests.get(i).setIme(K.getIme());
					tests.get(i).setLozinka(K.getSifra());
					tests.get(i).setPrezime(K.getPrezime());
					if(K.getPol().equals("MUSKI")) {
					tests.get(i).setPol(Pol.MUSKI);}
					else {tests.get(i).setPol(Pol.ZENSKI); }
					this.saveAll(tests);
					return tests.get(i);
				}
			}
			return null;
		}
		
		public   Korisnik getById(KorisnikDTO kor) {
			for(Korisnik k : getAll()) {
				if(k.getKorisnickoIme().equals(kor.getKIme())) {
					 if(k.getLozinka().equals(kor.getSifra())) {
							 return k;}
				}
			}
			return null;
		}
		public   Korisnik getByIdd(String id) {
			for(Korisnik k : getAll()) {
				if(k.getKorisnickoIme().equals(id)) {
					 
							 return k;}
				}
			return null;
			}
			
	
}
