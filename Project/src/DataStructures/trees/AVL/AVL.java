package DataStructures.trees.AVL;

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
		NodeAVL<K,V> nodeInsert = z;
		NodeAVL<K,V> father = (NodeAVL<K, V>) z.getFather();
		if(father!=nil) {
			do {
		
				NodeAVL<K,V> left = (NodeAVL<K, V>) father.getL();
				
				 if (left != nil && nodeInsert.getKey().compareTo(left.getKey())==0) {  
					 
					 if (father.getBalance() == 1) { 
						
						 if (nodeInsert.getBalance() == -1) { 
							 leftRotate((NodeAVL)nodeInsert); 
							 nodeInsert.updateFactorBalance();
							 ((NodeAVL)nodeInsert.getFather()).updateFactorBalance();
						 }
			
						 rightRotate(father);
						 
						 father.updateFactorBalance();
						 
						 ((NodeAVL)father.getFather()).updateFactorBalance();
						 break; 
					 }
					 if (father.getBalance() == -1) {
						 father.setBalance(0); 
						 break; 
					 }
					 
					 father.setBalance(1); 
				 } 
				 else { 
					 if (father.getBalance() == -1) { 
						 
						 if (nodeInsert.getBalance() == 1) { 
							 rightRotate(nodeInsert); 
							 nodeInsert.updateFactorBalance();
							 ((NodeAVL)nodeInsert.getFather()).updateFactorBalance();
						 }
						
						 leftRotate(father);
						 father.updateFactorBalance();
						 ((NodeAVL)father.getFather()).updateFactorBalance();
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
			}while(father!=nil);
		}
	}
	@SuppressWarnings("unchecked")
	public void remove(K key) {
		NodeAVL x = (NodeAVL) search(key);
		NodeAVL father = (NodeAVL) x.getFather();
		super.delete(key);		
		deleteBalance((NodeAVL) father);	
	}
	
	/**
	 * @param toDelete
	 */
	@SuppressWarnings("unchecked")
	private void deleteBalance(NodeAVL toDelete) {
		NodeAVL x = null;
		for(NodeAVL aux = (NodeAVL) toDelete.getFather(); aux != null; aux = x) { 
		    x = (NodeAVL) aux.getFather(); 
		    if (toDelete == aux.getL()) {
		        if (aux.getBalance() < 0) { 
		        	NodeAVL y = (NodeAVL) aux.getR();
		            int b = y.getBalance();
		            if (b > 0) {
		            	rightRotate(y);
		            	y.updateFactorBalance();
		            	leftRotate(aux);
		            	aux.updateFactorBalance();
		            }else {
		            	leftRotate(aux);
		            	aux.updateFactorBalance();
		            }
		        } else {
		            if (aux.getBalance() == 0) {
		                aux.setBalance(-1);
		                break; 
		            }
		            toDelete = aux;
		            toDelete.setBalance(0);
		            continue;
		        }
		    } else { 
		        if (aux.getBalance() > 0) {
		            NodeAVL Z = (NodeAVL) aux.getL();
		            int b = Z.getBalance();
		            if (b < 0) {
		            	leftRotate(Z);
		            	Z.updateFactorBalance();
		            	rightRotate(aux);
		            	aux.updateFactorBalance();
		            }else {
		            	rightRotate(aux);
		            	aux.updateFactorBalance();
		            }
		        } else {
		            if (aux.getBalance() == 0) {
		            	aux.setBalance(1);
		                break; 
		            }
		            toDelete = aux;
		            toDelete.setBalance(0);
		            continue;
		        }
		    }
		}
	}


}
