package interfaces;
import estructures.*;
public interface iBST<K, V>{
	
	// Methods
	public K search(K Key);
	public K minimum();
	public K maximum();
	public void insert(K Key, V Value);
	public void delete(K Key);
	public BTSNode sucessor(K key);
	public BTSNode predecessor(K key);
	
}
