package DataStructures.interfaces;

import DataStructures.trees.BST.NodeBST;

public interface iAVL<K,V> {

	public NodeBST search(K key);
	public void delete(K key);
	public void insert(NodeBST z);
	public boolean isSheet(K key);
	public NodeBST successor(K key);
	public NodeBST predecessor(K key);
	public NodeBST minimumTree();
	public NodeBST maximumTree();
	public NodeBST minimum(NodeBST root);
	public NodeBST maximum(NodeBST root);
	public void leftRotate(NodeBST x);
	public void rightRotate(NodeBST x);
}
