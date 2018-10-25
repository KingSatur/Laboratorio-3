package DataStructures.trees.AVL;

import DataStructures.trees.AVL.*;
import DataStructures.trees.RBT.NodeRBT;
import DataStructures.trees.general.TreesWithRotations;

public class AVL<K extends Comparable<K>, V> extends TreesWithRotations<K, V> {

	private NodeAVL nil;

	public AVL() {
		super.nil = new NodeAVL(null, null);
		super.nil.setL(null);
		super.nil.setR(null);
		nil = new NodeAVL(null, null);
		nil.setL(null);
		nil.setR(null);
		nil.setFather(null);
		super.nil = nil;
		root.setFather(nil);
		super.root = nil;

	}

	public void insert(K key, V value) {

		if (key != null && value != null) {
			NodeAVL z = new NodeAVL(key, value);
			insert(z); // llamado al metodo de bst
			insertBalance((NodeAVL) (z));
		}
	}

	private void insertBalance(NodeAVL<K, V> z) {
		NodeAVL<K, V> nodeInsert = z;
		NodeAVL<K, V> father = (NodeAVL<K, V>) z.getFather();
		if (father != nil) {
			do {

				NodeAVL<K, V> left = (NodeAVL<K, V>) father.getL();

				if (left != nil && nodeInsert.getKey().compareTo(left.getKey()) == 0) {

					if (father.getBalance() == 1) {

						if (nodeInsert.getBalance() == -1) {
							leftRotate((NodeAVL) nodeInsert);
							nodeInsert.updateFactorBalance();
							((NodeAVL) nodeInsert.getFather()).updateFactorBalance();
						}

						rightRotate(father);

						father.updateFactorBalance();

						((NodeAVL) father.getFather()).updateFactorBalance();
						break;
					}
					if (father.getBalance() == -1) {
						father.setBalance(0);
						break;
					}

					father.setBalance(1);
				} else {
					if (father.getBalance() == -1) {

						if (nodeInsert.getBalance() == 1) {
							rightRotate(nodeInsert);
							nodeInsert.updateFactorBalance();
							((NodeAVL) nodeInsert.getFather()).updateFactorBalance();
						}

						leftRotate(father);
						father.updateFactorBalance();
						((NodeAVL) father.getFather()).updateFactorBalance();
						break;
					}
					if (father.getBalance() == 1) {
						father.setBalance(0);
						break;
					}
					father.setBalance(-1);
				}
				nodeInsert = father;
				father = (NodeAVL<K, V>) nodeInsert.getFather();
			} while (father != nil);
		}
	}

	@SuppressWarnings("unchecked")
	public void remove(K key) {
		NodeAVL x = (NodeAVL) search(key);
		NodeAVL father = (NodeAVL) x.getFather();
		boolean leftChildren = x == father.getL();
		super.delete(key);		
		balance(x);
	}

	private void balance(NodeAVL x) {
		NodeAVL error = balanceFactorError();
		if (error != nil) {
			if (error.getBalance() == 2) {
				rightRotate(error);
			}
			if (error.getBalance() == -2) {
				leftRotate(error);
			}
			balance((NodeAVL) error.getFather());
		}
	}

	private NodeAVL balanceFactorError() {
		boolean stop = false;
		NodeAVL x = (NodeAVL) root;
		while (x != nil  && !stop) {
			x.updateFactorBalance();
			if((x.getBalance() >= -1 && x.getBalance() <= 1)) {
				x = (NodeAVL) x.getR();
			}else {
				stop = true;
			}
		}
		
		if(x != nil) {
			return x;
		}else {
			x = (NodeAVL) root;
		}

		boolean stop1 = false;
		while (x != nil  && !stop1) {
			x.updateFactorBalance();
			if((x.getBalance() >= -1 && x.getBalance() <= 1)) {
				x = (NodeAVL) x.getL();
			}else {
				stop1 = true;
			}
		}
		return x;
	}

	public void inOrden(NodeAVL x) {
		if (x != nil) {
			inOrden((NodeAVL) x.getL());
			String papa = null;
			if (x.getFather() != null) {
				papa = x.getFather().getValue() + "";
			}
			System.out.println(x.getKey() + " papa :" + papa);
			inOrden((NodeAVL) x.getR());
		}

	}



}
