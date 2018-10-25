package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;

import DataStructures.trees.AVL.AVL;
import DataStructures.trees.BST.BST;
import DataStructures.trees.BST.NodeBST;
import DataStructures.trees.RBT.RBT;

public class Fiba {

	private Hashtable<Integer, LinkedList<BST<Integer, String>>> forestYears;
	
	public Fiba() {
		forestYears = new Hashtable<Integer, LinkedList<BST<Integer, String>>>();
	}
	
	public void fillForest() {
		
		for(int i = 1978; i < 2017; i ++) {
			LinkedList<BST<Integer,String>> m = new LinkedList<BST<Integer,String>>();
			//PRIMER BST, GUARDA POR PARTIDO
			m.add(new BST<Integer, String>());
			//SEGUNDO BST GUARDA REBOTES
			m.add(new BST<Integer, String>());
			//PRIMER RBT GUARDA POR ASISTENCIA
			m.add(new RBT<Integer, String>());
			//SEGUNDO RBT GUARDA POR ROBOS
			m.add(new RBT<Integer, String>());
			//PRIMER AVL GUARDA POR REBOTES
			m.add(new AVL<Integer, String>());
			//SEGUNDO AVL GUARDA POR BLOQUEOS
			m.add(new AVL<Integer, String>());
			forestYears.put(i, m);
		}
	}
	
	
	public void makeForest(BST<Integer, String> treeToChargue, int year, int posParameter) throws IOException {
		
		//Directorio donde deseo buscar
		File directoryToSearch = new File("data/" + year);
		//Archivos que estan dentro del directorio
		String[] files = directoryToSearch.list();
		
		for(int i = 0; i < files.length ; i ++) {
			FileReader m = new FileReader(files[i]);
			BufferedReader reader = new BufferedReader(m);
			String line = reader.readLine();
			String[] parameters = line.split(",");
			int key = Integer.parseInt(parameters[posParameter]);
			treeToChargue.insert(new NodeBST<Integer, String>(key, directoryToSearch.getPath() + "/" + files[i]));
			reader.close();
			m.close();
		}
		
		
	}
	
	
	
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
//		f.filesGenerator("data/data2.csv");
		f.fillForest();
		int x = 0;
		int y = x + 10;
		
		File directory = new File("data/1978");
		String[] a = directory.list();
		int x1 = 0;
		int y1 = x + 10;
		
	}
	
	
}
