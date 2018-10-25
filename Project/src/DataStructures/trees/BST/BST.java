
package DataStructures.trees.BST;

import java.io.Serializable;

import DataStructures.interfaces.iBST;

public class BST<K extends Comparable<K>, V> implements iBST<K, V>, Serializable {

	protected NodeBST<K, V> root;
	
	protected NodeBST<K,V> nil;

	public BST() {
		nil = new NodeBST<>(null, null);
		nil.setFather(null);
		nil.setL(null);
		nil.setR(null);
//		root.setFather(nil);
		root = nil;
	}
	
	

	public NodeBST<K, V> getNil() {
		return nil;
	}



	public void setNil(NodeBST<K, V> nil) {
		this.nil = nil;
	}



	public NodeBST<K, V> getRoot() {
		return root;
	}

	public void setRoot(NodeBST<K, V> root) {
		this.root = root;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NodeBST search(K key) {
		if (root == nil) {
			return null;
		} else {
			return search(key, root);
		}
	}

	@SuppressWarnings("rawtypes")
	private NodeBST search(K key, NodeBST<K, V> root) {
		NodeBST searched = null;
		if (root.getKey().compareTo(key) == 0) {
			searched = root;
		} else {
			if (root.getL() != nil && root.getKey().compareTo(key) > 0)
				searched = search(key, root.getL());
			if (root.getR() != nil && root.getKey().compareTo(key) < 0)
				searched = search(key, root.getR());
		}
		return searched;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(K key) {
		NodeBST<K, V> toDelete = search(key);

		if (toDelete != null) {
			NodeBST<K, V> father = toDelete.getFather();

			// Case 1
			if (isSheet(toDelete.getKey())) {
				if (father.getL() != nil && father.getL() == toDelete)
					father.setL(nil);
				if (father.getR() != nil && father.getR() == toDelete)
					father.setR(nil);
			}

			// Case 2
			if (toDelete.getL() != nil && toDelete.getR() == nil) {
				if (father.getL() != nil && father.getL() == toDelete) {
					father.setL(toDelete.getL());
				}
				if (father.getR() != nil && father.getR() == toDelete) {
					father.setR(toDelete.getL());
				}
				toDelete.getL().setFather(father);

			}
			if (toDelete.getL() == nil && toDelete.getR() != nil) {
				if (father.getL() != nil && father.getL() == toDelete) {
					father.setL(toDelete.getR());
				}
				if (father.getR() != nil && father.getR() == toDelete) {
					father.setR(toDelete.getR());
				}
				toDelete.getR().setFather(father);
			}


			if (toDelete.getL() != nil && toDelete.getR() != nil) {

				NodeBST<K, V> successor = successor(key);
				K successorKey = successor.getKey();
				V successorValue = successor.getValue();
				K toDeleteKey = toDelete.getKey();
				V toDeleteValue = toDelete.getValue();
				this.delete(successorKey);
				toDelete.setKey(successorKey);
				toDelete.setValue(successorValue);
				successor.setKey(toDeleteKey);
				successor.setValue(toDeleteValue);

			}

		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void insert(NodeBST z) {
		z.setL(nil);
		z.setR(nil);
		if (root == nil) {
			root = z;
			root.setFather(nil);
		} else {
			insert(z, root);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void insert(NodeBST z, NodeBST<K, V> root) {
		if (root.getKey().compareTo((K) z.getKey()) > 0) { // root es mayor a key, key es izquierda
			if (root.getL() == nil) {
				root.setL(z);
				root.getL().setFather(root);
			} else {
				insert(z, root.getL());
			}
		}
		if (root.getKey().compareTo((K) z.getKey()) <= 0) { // root es menor a key, key es derecha
			if (root.getR() == nil) {
				root.setR(z);
				root.getR().setFather(root);
			} else {
				insert(z, root.getR());
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NodeBST successor(K key) {
		NodeBST x = search(key);
		NodeBST y = null;
		if (x == null) {
			return null;
		} else {
			if (x.getR() != nil) {
				return minimum(x.getR());
			}
			y = x.getFather();
			while (y != nil && x == y.getR()) {
				x = y;
				y = y.getFather();
			}
		}
		return y;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NodeBST predecessor(K key) {
		NodeBST x = search(key);
		NodeBST y = null;
		if (x == null) {
			return null;
		} else {
			if (x.getL() != nil) {
				return maximum(x.getL());
			}
			y = x.getFather();
			while (y != nil && x == y.getL()) {
				x = y;
				y = x.getFather();
			}
		}
		return y;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean isSheet(K key) {
		NodeBST x = search(key);
		return (x.getL() == nil && x.getR() == nil) ? true : false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NodeBST minimumTree() {
		if (root == nil) {
			return null;
		} else {
			return minimum(root);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NodeBST minimum(NodeBST root) {
		NodeBST x = root;
		if (root.getL() != nil) {
			x = minimum(root.getL());
		}
		return x;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NodeBST maximumTree() {
		if (root == nil) {
			return null;
		} else {
			return maximum(root);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NodeBST maximum(NodeBST root) {
		NodeBST x = root;
		if (root.getR() != nil) {
			x = maximum(root.getR());
		}
		return x;
	}

//	@SuppressWarnings("rawtypes")
//	public void inOrder(NodeBST x) {
//		if (x != nil) {
//			inOrder(x.getL());
//			String papa = null;
//			if (x.getFather() != null) {
//				papa = x.getFather().getValue() + "";
//			}
//			System.out.println(x.getKey() + " papa :" + papa);
//			inOrder(x.getR());
//		}
//
//	}
}
