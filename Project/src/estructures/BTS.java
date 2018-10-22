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
			while(temporary.getIzq()!=null) {
				temporary = temporary.getIzq();
			}
			iKey = (K) temporary.getKey();
		}
		return iKey;
	}
	
	@Override
	public K minimum(BTSNode node) {
		K iKey = null;
		BTSNode temporary = node;
		
		while(temporary.getIzq()!=null)
			temporary = temporary.getIzq();
		
		return iKey = (K)temporary.getIzq().getKey();
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
		BTSNode toDelete = (BTSNode)search(key);
		// Case special when is the root
		if(toDelete.equals(root)) {
			removeRoot();
		}
		// First case if is sheet
		else if(isSheet(toDelete)) {
			removeSheet(toDelete);
		}
		// Second case when the node toDelete have two or one son
		else {
			BTSNode sucessor = sucessor((K)toDelete.getKey());
			if(sucessor == null)
				sucessor = (BTSNode) predecessor((K)toDelete.getKey());
			
			if(toDelete.getDer()!=null)
				sucessor.setDer(toDelete.getDer());
			if(toDelete.getIzq()!=null)
				sucessor.setIzq(toDelete.getIzq());
			
			if(toDelete.getFather().getKey().compareTo(toDelete.getKey()) > 0) {
				toDelete.getFather().setIzq(sucessor);
			}
			else {
				toDelete.getFather().setDer(sucessor);
			}
		}
	}
	
	public void removeRoot() {
		if(isSheet(root)) {
			root = null;
		}
		else {
			BTSNode sucessor = (BTSNode)sucessor((K)root.getKey());
			if(sucessor != null) {
				if(root.getIzq()!=null)
					sucessor.setIzq(root.getIzq());
				if(root.getDer()!=null)
					sucessor.setDer(root.getDer());
				root = sucessor;
			}
			else {
				BTSNode predecessor = (BTSNode)predecessor((K)root.getKey());
				if(root.getDer()!=null) 
					predecessor.setDer(root.getDer());
				if(root.getIzq()!=null)
					predecessor.setIzq(root.getIzq());
				root = predecessor;
			}
		}
	}
	
	public void removeSheet(BTSNode current) {
		if(current.getFather().getKey().compareTo(current.getKey()) > 0) {
			current.getFather().setIzq(null);
		}
		else {
			current.getFather().setDer(null);
		}
	}

	@Override
	public BTSNode sucessor(K key) {
		BTSNode search = search(key, root);
		BTSNode sucessor = null;
		if(search!=null) {
			if(search.getDer()!=null) {
				sucessor = (BTSNode) search(minimum(search.getDer()));
				delete((K)sucessor.getKey());
			}
		}
		return sucessor;
	}

	@Override
	public BTSNode predecessor(K key) {
		BTSNode search = search(key, root);
		BTSNode predecessor = null;
		if(search!=null) {
			if(search.getIzq()!=null) {
				predecessor = (BTSNode) search(maximum(search.getIzq()));
				delete((K)predecessor.getKey());
			}
		}
			
		return predecessor;
	}

	@Override
	public boolean isSheet(BTSNode current) {
		boolean value = false;
		if(current.getIzq()==null && current.getDer()==null)
			value = true;
		return value;
	}
	
	
}