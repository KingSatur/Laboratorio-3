package DataStructures.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import DataStructures.trees.AVL.AVL;
import DataStructures.trees.AVL.NodeAVL;
import DataStructures.trees.RBT.NodeRBT;


class TestAVL {

	private static final int[] dataInOrder = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private static final int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

	private AVL<Integer, Integer> avl;
	
	private ArrayList inOrderData(NodeAVL x, ArrayList array) {
		if (x != avl.getNil()) {
			inOrderData((NodeAVL) x.getL(), array);
			array.add(x.getValue());
			inOrderData((NodeAVL) x.getR(), array);
		}
		return array;
	}
	
	private void invariant(NodeAVL x) {
		boolean test = false;
		if(x!=avl.getNil()) {
			x.updateFactorBalance();
			if(x.getBalance() >= -1 && x.getBalance() <= 1) {
				test = true;
			}
			assertTrue(test);
			invariant((NodeAVL) x.getR());
			invariant((NodeAVL) x.getL());
		}	
	}

	private void setupStage1() {
		avl = new AVL<Integer, Integer>();
	}

	private void setupStage2() {
		avl = new AVL<Integer, Integer>();
		for (int i = 0; i < data.length; i++) {
			avl.insert(data[i], data[i]);
		}
	}

	@Test
	void testInsert() {
		setupStage1();
		
		for (int i = 0; i < data.length; i++) {
			avl.insert(data[i], data[i]);
		}
		
		ArrayList<Integer> array = inOrderData((NodeAVL) avl.getRoot(), new ArrayList<Integer>());
		for (int i = 0; i < data.length; i++) {
			boolean test = dataInOrder[i] == array.get(i);
			assertTrue(test);
		}
		
		invariant((NodeAVL) avl.getRoot());
		
	}
	
	@Test
	void testDelete() {
		setupStage2();
		boolean test = false;
		
		avl.remove(1);
		avl.remove(3);
		avl.remove(5);
		
		test = avl.search(1) == null;
		test = avl.search(3) == null;
		test = avl.search(5) == null;
		
		assertTrue(test);
		invariant((NodeAVL) avl.getRoot());
		
		avl.remove(2);
		avl.remove(6);
		avl.remove(4);
		
		test = avl.search(2) == null;
		test = avl.search(6) == null;
		test = avl.search(4) == null;
		
		assertTrue(test);
		invariant((NodeAVL) avl.getRoot());
		
		avl.remove(8);
		avl.remove(16);
		avl.remove(12);
		avl.remove(10);
		avl.remove(9);
		
		test = avl.search(8) == null;
		test = avl.search(16) == null;
		test = avl.search(12) == null;
		test = avl.search(10) == null;
		test = avl.search(9) == null;
	
		assertTrue(test);
		invariant((NodeAVL) avl.getRoot());
		
		
	}

}
