package estructures;

import interfaces.*;

public class BTS<K extends Comparable<K>, V> implements iBST<K, V> {

	private BTSNode node;
	
	public BTS() {}

	@Override
	public K search(K Key) {
		return null;
	}

	@Override
	public K minimum() {
		return null;
	}

	@Override
	public K maximum() {
		return null;
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
