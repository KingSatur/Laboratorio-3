package interfaces;
import estructures.*;
public interface iBST<K, V>{
	
	// Methods
	public V search(K key);
	public BTSNode search(K key, BTSNode root); // Support method for method search().
	public K minimum();
	public K minimum(BTSNode node);
	public K maximum();
	public K maximum(BTSNode node); // Support method for method maximum().
	public void insertIterative(K key, V value); // First option to add an element. (Iterative)
	public void insertRecursive(K key, V value); // Second option to add an element. (Recursive)
	public void insertRecursive(BTSNode root, BTSNode add); // Support method for method insertRecursive().
	public void delete(K key);
	public BTSNode sucessor(K key);
	public BTSNode predecessor(K key);
	public boolean isSheet(BTSNode current);
	
}
