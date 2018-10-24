package DataStructures.trees.AVL;

import DataStructures.trees.BST.NodeBST;

public class NodeAVL<K extends Comparable<K>,V> extends NodeBST<K,V> {

	private int height;
	private int balance;
	
	public NodeAVL(K key, V value) {
		super(key, value);
		
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void updateFactorBalance() {
		((NodeAVL) this.getR()).updateheight();
		((NodeAVL) this.getL()).updateheight();
		
		if(getR() == null && getL() == null) {
			balance = 0;
		}
		else if(getR() == null) {
			balance = ((NodeAVL) getL()).getHeight();
		}
		else if(getL() == null) {
			balance = -((NodeAVL) getR()).getHeight();
		}
		else {
			balance = ((NodeAVL) getL()).getHeight()-((NodeAVL) getR()).getHeight();
		}
	}
	
	
	public void updateheight() {
		
		if(getR() == null && getL() == null) {
			height=-1;
		}
		else if (getR()  == null) {
			((NodeAVL) this.getL()).updateheight();
			height=((NodeAVL) getL()).getHeight();
		}
		else if (getL() == null) {
			((NodeAVL) this.getR()).updateheight();
			height = ((NodeAVL) getR()).getHeight();
		}else {
			((NodeAVL) this.getR()).updateheight();
			((NodeAVL) this.getL()).updateheight();
			height = Math.max(((NodeAVL) getR()).getHeight(), ((NodeAVL) getL()).getHeight());
		}
		height++;
	}
	
	
	
	
	
	

}
