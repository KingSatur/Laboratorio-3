package estructures;

public class BTSNode<K extends Comparable<K>, V> {

	
	private K Key;
	private V Value;
	private BTSNode izq;
	private BTSNode der;
	private BTSNode father;
	
	
	public BTSNode(K Key, V Value) {
		this.Key = Key;
		this.Value = Value;
	}
	
	public K getKey() {
		return Key;
	}
	
	public void setKey(K Key) {
		this.Key = Key;
	}
	
	public V getValue() {
		return Value;
	}
	
	public void setValue(V Value) {
		this.Value = Value;
	}
	
	public BTSNode getIzq() {
		return izq;
	}
	
	public void setIzq(BTSNode node) {
		izq = node;
	}
	
	public BTSNode getDer() {
		return der;
	}
	
	public void setDer(BTSNode node) {
		der = node;
	}
	
	public BTSNode getFather() {
		return father;
	}
	
	public void setFather(BTSNode node) {
		this.father = node;
	}
}
