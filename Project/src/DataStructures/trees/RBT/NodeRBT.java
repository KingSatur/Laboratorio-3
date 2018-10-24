
package DataStructures.trees.RBT;

import DataStructures.trees.BST.NodeBST;

@SuppressWarnings("rawtypes")
public class NodeRBT<K extends Comparable<K>, V> extends NodeBST{

	public static final int RED = 1;
	public static final int BLACK = 0;

	private int type;


	@SuppressWarnings("unchecked")
	public NodeRBT(K key, V value) {
		super(key, value);
		this.type = RED;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}



}

