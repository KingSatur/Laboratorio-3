package DataStructures.trees.general;

import DataStructures.trees.BST.BST;
import DataStructures.trees.BST.NodeBST;


public class TreesWithRotations<K extends Comparable<K>, V> extends BST<K, V> {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void leftRotate(NodeBST x) {
		if (x.getR() != nil) {

			NodeBST y = (NodeBST) x.getR();
			x.setR(y.getL());
			if (y.getL() != nil) {
				y.getL().setFather(x);
			}
			y.setFather(x.getFather());
			if (x.getFather() == nil) {
				root = y;
			} else if (x == x.getFather().getL()) {
				x.getFather().setL(y);
			} else {
				x.getFather().setR(y);
			}
			y.setL(x);
			x.setFather(y);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void rightRotate(NodeBST x) {
		if (x.getL() != nil) {

			NodeBST y = (NodeBST) x.getL();
			x.setL(y.getR());
			if (y.getR() != nil) {
				y.getR().setFather(x);
			}
			y.setFather(x.getFather());
			if (x.getFather() == nil) {
				this.root = y;
			} else if (x == x.getFather().getL()) {
				x.getFather().setL(y);
			} else {
				x.getFather().setR(y);
			}
			y.setR(x);
			x.setFather(y);
		}
	}
	

	
}
