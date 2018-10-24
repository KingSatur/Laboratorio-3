package DataStructures.interfaces;

import DataStructures.trees.BST.NodeBST;
import DataStructures.trees.RBT.NodeRBT;

public interface iRBT<K,V> {

	public void leftRotate(NodeBST x);
	public void rightRotate(NodeBST x);
	public void insertFixUp(NodeRBT z);
	public void deleteFixUp(NodeRBT z);
	public NodeBST search(K key);
	public void delete(K key);
	public void insert(NodeBST z);
	public boolean isSheet(NodeBST x);
	public NodeBST successor(K key);
	public NodeBST predecessor(K key);
	public NodeBST minimumTree();
	public NodeBST maximumTree();
	public NodeBST minimum(NodeBST root);
	public NodeBST maximum(NodeBST root);
	
	
	
}
