package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fiba {

	//GENERATOR PLAYERSqwreqrwerewrwer
	public void filesGenerator(String archivoLeer) throws IOException {
		

		FileReader fileReaded = new FileReader(archivoLeer);
		BufferedReader bufer = new BufferedReader(fileReaded);

		
		String linea = "";
		int i = 0;
		while((linea = bufer.readLine()) != null) {
			linea = bufer.readLine();
			int year = Integer.parseInt(linea.split(",")[0]);
			File directory = new File("data/" + String.valueOf(year));
			directory.mkdir();
			String h = directory.getPath() + "/File" + "" + i;
			FileWriter fileWrited = new FileWriter(h);
			BufferedWriter writer = new BufferedWriter(fileWrited);
			writer.write(linea);
			writer.close();
			fileWrited.close();
			linea = bufer.readLine();
			i ++;
		}
			
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Fiba f = new Fiba();
		f.filesGenerator("data/data2.csv");
		
		
		
		
	}
	
	
}
