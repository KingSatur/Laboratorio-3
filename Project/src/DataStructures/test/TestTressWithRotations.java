package DataStructures.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import DataStructures.trees.BST.NodeBST;
import DataStructures.trees.general.TreesWithRotations;

class TestTressWithRotations {

	private TreesWithRotations<Integer, Integer> rotation; 
	
	
	private void setupStage1() {
		rotation =  new TreesWithRotations<Integer, Integer>();
		rotation.insert(new NodeBST<Integer, Integer>(10,10 ));
		rotation.insert(new NodeBST<Integer, Integer>(5, 5));
		rotation.insert(new NodeBST<Integer, Integer>(15,15 ));
		rotation.insert(new NodeBST<Integer, Integer>(1,1 ));
		rotation.insert(new NodeBST<Integer, Integer>(7,7 ));
	}
	
	private void setupStage2() {
		setupStage1();
		rotation.rightRotate(rotation.getRoot());
	}
	
	@Test
	void testRightRotate() {
		setupStage1();
		rotation.rightRotate(rotation.getRoot());
		boolean test = false;
		
		test = rotation.getRoot().getKey().compareTo(5) == 0;
		test = rotation.getRoot().getL().getKey().compareTo(1) == 0;
		test = rotation.getRoot().getR().getKey().compareTo(10) == 0;
		test = rotation.getRoot().getR().getL().getKey().compareTo(7) == 0;
		test = rotation.getRoot().getR().getR().getKey().compareTo(15) == 0;
		
		assertTrue(test);
	}
	
	@Test
	void testLeftRotate() {
		setupStage2();
		rotation.leftRotate(rotation.getRoot());
		boolean test = false;
		
		test = rotation.getRoot().getKey().compareTo(10) == 0;
		test = rotation.getRoot().getL().getKey().compareTo(5) == 0;
		test = rotation.getRoot().getR().getKey().compareTo(15) == 0;
		test = rotation.getRoot().getL().getL().getKey().compareTo(1) == 0;
		test = rotation.getRoot().getL().getR().getKey().compareTo(7) == 0;
		
		assertTrue(test);
	}

}
