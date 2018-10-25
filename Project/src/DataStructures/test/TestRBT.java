package DataStructures.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import DataStructures.trees.BST.NodeBST;
import DataStructures.trees.RBT.*;
import junit.framework.AssertionFailedError;

class TestRBT {


	private static final int[] dataInOrder = { 1, 6, 8, 11, 13, 15, 17, 22, 25, 27 };
	private static final int[] data = { 13, 8, 17, 1, 11, 15, 25, 6, 22, 27 };
	private RBT<Integer, Integer> rbt;

	private void setupStage1() {
		rbt = new RBT<Integer, Integer>();
	}

	private void setupStage2() {
		rbt = new RBT<Integer, Integer>();
		for (int i = 0; i < data.length; i++) {
			rbt.insert(data[i], data[i]);
		}
	}

	@SuppressWarnings("rawtypes")
	private void invariant(NodeRBT x) {
		boolean test = false;
		if (x == rbt.getRoot()) {
			if ((((NodeRBT) x).getType() == NodeRBT.BLACK))
				test = true;
			assertTrue(test);
		} 
		

		if (((NodeRBT) x).getType() == NodeRBT.RED) {
			if (((NodeRBT) x.getR()).getType() == NodeRBT.BLACK) {
				test = true;
			}
			if (((NodeRBT) x.getL()).getType() == NodeRBT.BLACK) {
				test = true;
			}
			assertTrue(test);
		}

		int rightHeight = 0;
		NodeRBT aux = x;
		while (aux != rbt.getNil()) {
			if (aux.getType() == NodeRBT.BLACK) {
				rightHeight += 1;
			}
			aux = (NodeRBT) aux.getR();
		}
		int leftHeight = 0;
		aux = x;
		while (aux != rbt.getNil()) {
			if (aux.getType() == NodeRBT.BLACK) {
				leftHeight += 1;
			}
			aux = (NodeRBT) aux.getL();
		}
		if ((rightHeight - leftHeight) == 0) {
			test = true;
		} else {
			test = false;
		}
		assertTrue(test);
		
		if(x!=rbt.getNil()) {
			invariant((NodeRBT) x.getR());
			invariant((NodeRBT) x.getL());			
		}
	}
	
	private ArrayList inOrderData(NodeRBT x, ArrayList array) {
		if (x != rbt.getNil()) {
			inOrderData((NodeRBT) x.getL(), array);
			array.add(x.getValue());
			inOrderData((NodeRBT) x.getR(), array);
		}
		return array;
	}

	@SuppressWarnings("rawtypes")
	@Test
	void testInsert() {
		setupStage1();
		
		for (int i = 0; i < data.length; i++) {
			rbt.insert(data[i], data[i]);			
		}
		
		ArrayList<Integer> array = inOrderData((NodeRBT) rbt.getRoot(), new ArrayList<Integer>());
		for (int i = 0; i < data.length; i++) {
			boolean test = dataInOrder[i] == array.get(i);
			assertTrue(test);
		}
		
		invariant((NodeRBT) rbt.getRoot());
	}

	@Test
	void testDelete() {
		setupStage2();
		boolean test = false;
		
		rbt.delete(6);
		rbt.delete(22);
		rbt.delete(27);
		
		test = rbt.search(6) == null;
		test = rbt.search(22) == null;
		test = rbt.search(27) == null;
		
		assertTrue(test);
		invariant((NodeRBT) rbt.getRoot());
		
		rbt.delete(13);
		rbt.delete(8);
		rbt.delete(17);
		
		test = rbt.search(13) == null;
		test = rbt.search(8) == null;
		test = rbt.search(17) == null;
		
		assertTrue(test);
		invariant((NodeRBT) rbt.getRoot());
		
		rbt.delete(1);
		rbt.delete(11);
		rbt.delete(15);
		
		test = rbt.search(1) == null;
		test = rbt.search(11) == null;
		test = rbt.search(15) == null;
		
		assertTrue(test);
		invariant((NodeRBT) rbt.getRoot());
		
	}
	
	

}
