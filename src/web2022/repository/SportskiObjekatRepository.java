package web2022.repository;

import static web2022.Application.gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import web2022.model.SportskiObjekat;
import web2022.model.SportskiObjekat.Status;
import web2022.model.Test;

public class SportskiObjekatRepository {
private String filename;
	
	public  SportskiObjekatRepository() {
		this.filename = "sportskiObjekti.json";
		this.initFile();
	}
	
	private void  initFile()
	{
		File file = new File(this.filename);
		if (!file.isFile()) {
			this.saveAll(new ArrayList<SportskiObjekat>());
		}
	}
	private  void saveAll(Collection<SportskiObjekat> sportskiObjekti)
	{
		try (FileWriter writer = new FileWriter(this.filename)) {
			gson.toJson(sportskiObjekti, writer);
		} catch (JsonIOException | IOException e) {
			// e.printStackTrace();
			System.out.println("There was an error trying to save to file tests.json!");
		}
	}
	
	public  ArrayList<SportskiObjekat> getAll() {
		ArrayList<SportskiObjekat> sportskiObjekti = null;
		Type collectionType = new TypeToken<Collection<SportskiObjekat>>(){}.getType();
		try(FileReader freader = new FileReader(this.filename); JsonReader jreader = new JsonReader(freader)) {
			sportskiObjekti = gson.fromJson(jreader, collectionType);
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("There was an error trying to read from file tests.json!");
		}
		if(sportskiObjekti == null) {
			return new ArrayList<SportskiObjekat>();
		}
		
		return sportskiObjekti;
	}
	
	public  SportskiObjekat add(SportskiObjekat newSportskiObjekat) {
		ArrayList<SportskiObjekat> sportskiObjekti =getAll();
		boolean exist = false;
		System.out.println("usao");
		for(SportskiObjekat sportskiObjekat : sportskiObjekti) {
			if(sportskiObjekat.getId().equals(newSportskiObjekat.getId())) {
				exist = true;
				break;
			}
		}
		if(!exist) {
			sportskiObjekti.add(newSportskiObjekat);
			saveAll(sportskiObjekti);
			return newSportskiObjekat;
		}
		return null;
	}

}
