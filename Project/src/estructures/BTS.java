package estructures;

import interfaces.*;

public class BTS<K extends Comparable<K>, V> implements iBST<K, V> {

	private BTSNode root;
	
	public BTS() {}

	@Override
	public V search(K key) {
		if(root.getKey().compareTo(key) == 0) {
			return (V) root.getValue();
		}
		else {
			BTSNode temporary = search(key, root); // Support method
			if(temporary != null) {
				return (V) temporary.getValue();
			}
			else {
				return null;
			}
		}
	}
	
	public BTSNode search(K key, BTSNode root) { // Support method for method search().
		BTSNode output = null;
		if(root.getKey().compareTo(key) == 0) {
			output = root;
		}
		else {
			if(root.getIzq() != null && root.getKey().compareTo(key) > 0) {
				search(key, root.getIzq());
			}
			else if(root.getDer() != null && root.getKey().compareTo(key) < 0) {
				search(key, root.getDer());
			}
		}
		return output;
	}

	@Override
	public K minimum() {
		K iKey = null;
		if(root!=null) {
			BTSNode temporary = root;
			while(root.getIzq()!=null) {
				temporary = root.getIzq();
			}
			iKey = (K) temporary.getKey();
		}
		return iKey;
	}

	@Override
	public K maximum() {
		K iKey = null;
		if(root!=null) {
			if(root.getDer() == null)
				iKey = (K) root.getKey();
			else
				iKey = (K)maximum(root); // Support method.
		}
		return iKey;
	}
	
	@Override
	public K maximum(BTSNode node) {
		K iKey = null;
		BTSNode temporary = node;
		
		while(temporary.getDer()!=null)
			temporary = temporary.getDer();
		
		return iKey = (K)temporary.getDer().getKey();
	}

	@Override
	public void insertIterative(K key, V value) { // First option to add an element. (Iterative)
		BTSNode add = new BTSNode(key, value);
		if(root == null) {
			root = add;
		}
		else {
			BTSNode temporary = root;
			BTSNode previous = null;
			while(temporary!=null) {
				previous = temporary;
				if(temporary.getKey().compareTo(add.getKey()) > 0) { // Take the left path of the tree.
					temporary = temporary.getIzq();
					if(temporary == null) {
						previous.setIzq(add);
						add.setFather(previous);
					}
				}
				else { // Take the right path of the tree.
					temporary = temporary.getDer();
					if(temporary == null) {
						previous.setDer(add);
						add.setFather(previous);
					}
				}
			}
		}
	}

	@Override
	public void insertRecursive(K key, V value) { // Second option to add an element. (Recursive)
		BTSNode add = new BTSNode(key, value);
		if(root == null) {
			root = add;
		}
		else {
			insertRecursive(root, add); // Support method.
		}
	}
	
	@Override
	public void insertRecursive(BTSNode root, BTSNode add) { // Support method for method insertRecursive().
		BTSNode temporary = root;
		if(temporary.getKey().compareTo(add.getKey()) > 0) { // Take the left path of the tree.
			if(temporary.getIzq() != null) {
				insertRecursive(temporary.getIzq(), add);
			}
			else {
				temporary.setIzq(add);
				add.setFather(temporary);
			}
		}
		else { // Take the right path of the tree.
			if(temporary.getDer() != null) {
				insertRecursive(temporary.getDer(), add);
			}
			else {
				temporary.setDer(add);
				add.setFather(temporary);
			}
		}
	}
	
	@Override
	public void delete(K key) {
		
	}

	@Override
	public BTSNode sucessor(K key) {
		return null;
	}

	@Override
	public BTSNode predecessor(K key) {
		return null;
	}
	
}