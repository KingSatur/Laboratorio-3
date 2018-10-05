package estructures;

import interfaces.*;

public class BTS<K extends Comparable<K>, V> implements iBST<K, V> {

	private BTSNode root;
	
	public BTS() {}

	@Override
	public K search(K Key) {
		return null;
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
				iKey = (K)max(root);
		}
		return iKey;
	}
	
	public K max(BTSNode node) {
		K iKey = null;
		BTSNode temporary = node;
		while(temporary.getDer()!=null)
			temporary = temporary.getDer();
		
		return iKey = (K)temporary.getDer().getKey();
	}

	@Override
	public void insert(K Key, V Value) {
		
	}

	@Override
	public void delete(K Key) {
		
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
