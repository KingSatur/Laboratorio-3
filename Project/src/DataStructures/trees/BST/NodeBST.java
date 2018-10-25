
package DataStructures.trees.BST;

import java.io.Serializable;

public class NodeBST<K extends Comparable<K>, V> implements Serializable {

	private K key;
	private V value;
	private NodeBST<K, V> l;
	private NodeBST<K, V> r;
	private NodeBST<K, V> father;
	


	public NodeBST(K key, V value) {
		this.key = key;
		this.value = value;
		this.father = null;
		this.l = null;
		this.r = null;
	}

	public NodeBST<K, V> getL() {
		return l;
	}

	public void setL(NodeBST<K, V> l) {
		this.l = l;
	}

	public NodeBST<K, V> getR() {
		return r;
	}

	public void setR(NodeBST<K, V> r) {
		this.r = r;
	}

	public NodeBST<K, V> getFather() {
		return father;
	}

	public void setFather(NodeBST<K, V> father) {
		this.father = father;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	 
	
	
	

}
