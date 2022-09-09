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


import web2022.model.Trening;

public class TreninziRepository {
private String filename;
	
	public TreninziRepository() {
		this.filename = "treninzi.json";
		this.initFile();
	}
	
	private void initFile()
	{
		File file = new File(this.filename);
		if (!file.isFile()) {
			this.saveAll(new ArrayList<Trening>());
		}}
	
	
		private void saveAll(Collection<Trening> k)
		{
			try (FileWriter writer = new FileWriter(this.filename)) {
				gson.toJson(k, writer);
			} catch (JsonIOException | IOException e) {
				// e.printStackTrace();
				System.out.println("There was an error trying to save to file tests.json!");
			}
		}
	
	public  ArrayList<Trening> getAll() {
		ArrayList<Trening> tests = null;
		Type collectionType = new TypeToken<Collection<Trening>>(){}.getType();
		try(FileReader freader = new FileReader(this.filename); JsonReader jreader = new JsonReader(freader)) {
			tests = gson.fromJson(jreader, collectionType);
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("There was an error trying to read from file tests.json!");
		}
		if(tests == null) {
			return new ArrayList<Trening>();
		}
		else {
			return tests;
		}
	}

}
