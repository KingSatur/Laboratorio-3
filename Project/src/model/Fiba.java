package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.LinkedList;

import DataStructures.trees.AVL.AVL;
import DataStructures.trees.BST.BST;
import DataStructures.trees.BST.NodeBST;
import DataStructures.trees.RBT.RBT;

public class Fiba implements Serializable{

	private Hashtable<Integer, LinkedList<BST<Integer, String>>> forestYears;
	
	public Fiba() {
		forestYears = new Hashtable<Integer, LinkedList<BST<Integer, String>>>();
	}
	
	public void fillForest() throws IOException {
		
		for(int i = 1978; i < 2017; i ++) {
			LinkedList<BST<Integer,String>> m = new LinkedList<BST<Integer,String>>();
			//PRIMER BST, GUARDA POR puntos de PARTIDO
			m.add(new BST<Integer, String>());
			makeTree(m.get(0), i, 6);
			//SEGUNDO BST GUARDA REBOTES
			m.add(new BST<Integer, String>());
			makeTree(m.get(1), i, 7);
			//PRIMER RBT GUARDA POR ASISTENCIA
			m.add(new RBT<Integer, String>());
			makeTree(m.get(2), i, 8);
			//SEGUNDO RBT GUARDA POR ROBOS
			m.add(new RBT<Integer, String>());
			makeTree(m.get(3), i , 9);
			//PRIMER AVL GUARDA POR REBOTES
			m.add(new AVL<Integer, String>());
			makeTree(m.get(4), i , 7);
			//SEGUNDO AVL GUARDA POR BLOQUEOS
			m.add(new AVL<Integer, String>());
			makeTree(m.get(5), i, 10);
			forestYears.put(i, m);
		}
	}

	
	
	public void makeTree(BST<Integer, String> treeToChargue, int year, int posParameter) throws IOException {
		
		//Directorio donde deseo buscar
		File directoryToSearch = new File("data/" + year);
		//Archivos que estan dentro del directorio
		String[] files = directoryToSearch.list();
		
		for(int i = 0; i < files.length ; i ++) {
			FileReader m = new FileReader(("data/" + year) + "/" + files[i]);
			BufferedReader reader = new BufferedReader(m);
			String line = reader.readLine();
			String[] parameters = line.split(",");
			int key = Integer.parseInt(parameters[posParameter - 1]);
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
	
	public void serializar() throws IOException {
		
	    FileOutputStream fs = new FileOutputStream("data/serializable.txt");
	    ObjectOutputStream os = new ObjectOutputStream(fs);
	    os.writeObject(this);//El método writeObject() serializa el objeto y lo escribe en el archivo
	    os.close();//Hay que cerrar siempre el archivo	
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Fiba f = new Fiba();
//		f.filesGenerator("data/data2.csv");
		f.fillForest();
		f.serializar();
		int x = 0;
		int y = x + 10;
		
		File directory = new File("data/1978");
		String[] a = directory.list();
		int x1 = 0;
		int y1 = x + 10;
		
	}
	
	
}
