package DataStructures.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import DataStructures.trees.BST.BST;
import DataStructures.trees.BST.NodeBST;

class TestBST {

	
	private int[] inOrderData1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	private BST<Integer, Integer> bst;
	private int[] data = {10,5,16,2,8,13,19,1,4,7,9,12,15,18,20,3,6,11,14,17};
	
	

	private ArrayList inOrderData(NodeBST x, ArrayList array ) {

			if (x != bst.getNil()) {
				inOrderData(x.getL(), array);
				array.add(x.getValue());
				inOrderData(x.getR(), array);
			}
			return array;
	}
	
	
	
	private void setupStage1() {
		bst = new BST<Integer, Integer>();
	}
	
	private void setupStage2() {
		bst = new BST<Integer, Integer>();
		
		for (int i = 0; i < data.length; i++) {
			NodeBST<Integer, Integer> z = new NodeBST<Integer, Integer>(data[i], data[i]);
			bst.insert(z);
		}
	}
		
	@Test
	void testInsert() {
		setupStage1();
		
		for (int i = 0; i < data.length; i++) {
			NodeBST<Integer, Integer> z = new NodeBST<Integer, Integer>(data[i], data[i]);
			bst.insert(z);
		}
		
		ArrayList<Integer> array =  inOrderData(bst.getRoot(), new ArrayList<Integer>());
		for (int i = 0; i < data.length; i++) {
			boolean test = inOrderData1[i] == array.get(i);
			assertTrue(test);
		}
		
	}
	
	@Test
	void testSearch() {
		setupStage2();
		boolean test = false;
		for (int i = 1; i < data.length+1; i++) {
			test = bst.search(i).getKey().compareTo(i) == 0;
			assertTrue(test);
		}
		
		NodeBST x = bst.search(-1);  
		NodeBST y = bst.search(-2);
		NodeBST z = bst.search(-3);
		NodeBST w = bst.search(-4);
		
		test = true && x == null;
		test = true && y == null;
		test = true && z == null;
		test = true && w == null;
		
		assertTrue(test);
	}

	@Test
	void testDelete() {
		setupStage2();
		
		boolean test = false;
		
		//Elimino las hojas caso 1
		bst.delete(1);
		bst.delete(3);
		bst.delete(6);
		bst.delete(11);
		bst.delete(14);
		bst.delete(17);
		bst.delete(20);
		
		test = bst.search(1) == null;
		test = bst.search(3) == null;  
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
