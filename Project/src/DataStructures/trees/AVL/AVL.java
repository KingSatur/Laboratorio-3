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
	private void deleteBalance(NodeAVL N) {
		NodeAVL G = null;
		for(NodeAVL X = (NodeAVL) N.getFather(); X != nil; X = G) { 
		    G = (NodeAVL) X.getFather(); 
		    if (N == X.getL()) {
		        if (X.getBalance() < 0) { 
		        	NodeAVL Z = (NodeAVL) X.getR();
		            int b = Z.getBalance();
		            if (b > 0) {
		            	rightRotate(Z);
		            	Z.updateFactorBalance();
		            	leftRotate(X);
		            	X.updateFactorBalance();
		            }else {
		            	System.out.println("HERE");
		            	leftRotate(X);
		            	X.updateFactorBalance();
		            }
		        } else {
		            if (X.getBalance() == 0) {
		                X.setBalance(-1);
		                break; 
		            }
		            N = X;
		            N.setBalance(0);
		            continue;
		        }
		    } else { 
		        if (X.getBalance() > 0) {
		        	NodeAVL Z = (NodeAVL) X.getL();
		            int b = Z.getBalance();
		            if (b < 0) {
		            	leftRotate(Z);
		            	Z.updateFactorBalance();
		            	rightRotate(X);
		            	X.updateFactorBalance();
		            }else {
		            	rightRotate(X);
		            	X.updateFactorBalance();
		            }
		        } else {
		            if (X.getBalance() == 0) {
		            	X.setBalance(1);
		                break; 
		            }
		            N = X;
		            N.setBalance(0);
		            continue;
		        }
		    }
		}
	}
	

	
	
	


}
