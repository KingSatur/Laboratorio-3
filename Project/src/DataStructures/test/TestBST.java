package DataStructures.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import DataStructures.trees.BST.BST;
import DataStructures.trees.BST.NodeBST;


class TestBST {

	private int[] inOrderData1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private BST<Integer, Integer> bst;
	private int[] data = { 10, 5, 16, 2, 8, 13, 19, 1, 4, 7, 9, 12, 15, 18, 20, 3, 6, 11, 14, 17 };

	private ArrayList inOrderData(NodeBST x, ArrayList array) {

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

		ArrayList<Integer> array = inOrderData(bst.getRoot(), new ArrayList<Integer>());
		for (int i = 0; i < data.length; i++) {
			boolean test = inOrderData1[i] == array.get(i);
			assertTrue(test);
		}

	}

	@Test
	void testSearch() {
		setupStage2();
		boolean test = false;
		for (int i = 1; i < data.length + 1; i++) {
			test = bst.search(i).getKey().compareTo(i) == 0;
			assertTrue(test);
		}

		NodeBST x = bst.search(-1);
		NodeBST y = bst.search(-2);
		NodeBST z = bst.search(-3);
		NodeBST w = bst.search(-4);

		test = x == null;
		test = y == null;
		test = z == null;
		test = w == null;

		assertTrue(test);
	}

	@Test
	void testDelete() {
		setupStage2();

		boolean test = false;

		// Elimino las hojas caso 1
		bst.delete(1);
		bst.delete(3);
		bst.delete(6);
		bst.delete(11);
		bst.delete(14);
		bst.delete(17);
		bst.delete(20);

		test = bst.search(1) == null;
		test = bst.search(3) == null;
		test = bst.search(6) == null;
		test = bst.search(11) == null;
		test = bst.search(14) == null;
		test = bst.search(17) == null;
		test = bst.search(20) == null;

		assertTrue(test);

		// Elimino Caso 2
		bst.delete(2);
		bst.delete(19);

		test = bst.search(2) == null;
		test = bst.search(19) == null;

		assertTrue(test);

		// Elimino caso 3
		bst.delete(8);
		bst.delete(13);
		bst.delete(5);
		bst.delete(16);
		bst.delete(10);

		test = bst.search(8) == null;
		test = bst.search(13) == null;
		test = bst.search(5) == null;
		test = bst.search(16) == null;
		test = bst.search(10) == null;

		assertTrue(test);

		test = bst.getRoot().getKey() == 12;
		test = bst.getRoot().getL().getKey() == 7;
		test = bst.getRoot().getL().getL().getKey() == 4;
		test = bst.getRoot().getL().getR().getKey() == 9;
		test = bst.getRoot().getR().getKey() == 18;
		test = bst.getRoot().getR().getL().getKey() == 15;

		assertTrue(test);

	}

	@Test
	void testSuccessor() {
		setupStage2();
		boolean test;

		for (int i = 1; (i + 1) < data.length + 1; i++) {
			test = (Integer) bst.successor(i).getKey() == (i + 1);
			assertTrue(test);
		}

	}

	@Test
	void testPredecessor() {
		setupStage2();
		boolean test;
		for (int i = 20; (i - 1) > 0; i--) {
			test = (Integer) bst.predecessor(i).getKey() == (i - 1);
			assertTrue(test);
		}

	}
	
	@Test
	void testIsSheet() {
		setupStage2();
		boolean test = false;
		
		test = bst.isSheet(1);
		test = bst.isSheet(3);
		test = bst.isSheet(6);
		test = bst.isSheet(9);
		test = bst.isSheet(11);
		test = bst.isSheet(14);
		test = bst.isSheet(17);
		test = bst.isSheet(20);
		
		assertTrue(test);
		
		test = bst.isSheet(10);
		test = bst.isSheet(5);
		test = bst.isSheet(16);
		test = bst.isSheet(2);
		test = bst.isSheet(8);
		test = bst.isSheet(13);
		test = bst.isSheet(19);
		test = bst.isSheet(4);
		test = bst.isSheet(7);
		test = bst.isSheet(12);
		test = bst.isSheet(15);
		test = bst.isSheet(18);
		
		assertTrue(!test);
		
	}
	
	
	@Test 
	void treeMinimumTree() {
		setupStage2();
		boolean test = false;
		test = (Integer)bst.minimumTree().getValue() == 1;		
	}
	
	@Test
	void treeMinimum() {
		setupStage2();
		boolean test = false;
		
		test = (Integer)bst.minimum(bst.getRoot()).getKey() == 1;
		test = (Integer)bst.minimum(bst.search(5)).getKey() == 6;
		test = (Integer)bst.minimum(bst.search(16)).getKey() == 17;
		test = (Integer)bst.minimum(bst.search(2)).getKey() == 3;
		test = (Integer)bst.minimum(bst.search(8)).getKey() == 9;
		test = (Integer)bst.minimum(bst.search(13)).getKey() == 14;
		test = (Integer)bst.minimum(bst.search(19)).getKey() == 20;
	
		assertTrue(true);
		
	}
	
	
	@Test 
	void treeMaximumTree() {
		setupStage2();
		boolean test = false;
		test = (Integer)bst.maximumTree().getValue() == 20;		
	}
	
	@Test
	void treeMaximum() {
		setupStage2();
		boolean test = false;
		
		test = (Integer)bst.maximum(bst.getRoot()).getKey() == 20;
		test = (Integer)bst.maximum(bst.search(5)).getKey() == 0;
		test = (Integer)bst.maximum(bst.search(16)).getKey() == 20;
		test = (Integer)bst.maximum(bst.search(2)).getKey() == 4;
		test = (Integer)bst.maximum(bst.search(8)).getKey() == 9;
		test = (Integer)bst.maximum(bst.search(13)).getKey() == 15;
		test = (Integer)bst.maximum(bst.search(19)).getKey() == 20;
	
		assertTrue(true);
		
	}
	
	

}
