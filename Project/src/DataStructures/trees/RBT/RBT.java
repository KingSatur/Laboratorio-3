
package DataStructures.trees.RBT;

import DataStructures.interfaces.iRBT;
import DataStructures.trees.general.TreesWithRotations;


@SuppressWarnings("unused")
public class RBT<K extends Comparable<K>, V> extends TreesWithRotations<K, V> implements iRBT<K, V> {

	private NodeRBT nil;

	public RBT() {
		nil = new NodeRBT(null, null);
		nil.setL(null);
		nil.setR(null);
		nil.setFather(null);
		nil.setType(NodeRBT.BLACK);
		super.nil = nil;
		root.setFather(nil);
		super.root = nil;
	}

	@SuppressWarnings("rawtypes")
	public void insert(K key, V value) {

		if (key != null && value != null) {
			NodeRBT z = new NodeRBT(key, value);
			insert(z); // llamado al metodo de bst
			insertFixUp(z);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insertFixUp(NodeRBT z) {

		if (z == root) {
			z.setType(NodeRBT.BLACK);
		} else {
			while (((NodeRBT) z.getFather()).getType() == NodeRBT.RED) {
				if (z.getFather() == z.getFather().getFather().getL()) {
					NodeRBT y = (NodeRBT) z.getFather().getFather().getR(); // Y es el tio de z
					if (y.getType() == NodeRBT.RED) { // caso tio rojo y papa rojo
						((NodeRBT) z.getFather()).setType(NodeRBT.BLACK);
						y.setType(NodeRBT.BLACK);
						((NodeRBT) z.getFather().getFather()).setType(NodeRBT.RED);
						z = ((NodeRBT) z.getFather().getFather());
					} else {

						if (z == z.getFather().getR()) { // caso papa rojo tio negro
							z = (NodeRBT) z.getFather();
							leftRotate(z);
						}

						((NodeRBT) z.getFather()).setType(NodeRBT.BLACK);
						((NodeRBT) z.getFather().getFather()).setType(NodeRBT.RED);
						rightRotate(((NodeRBT) z.getFather().getFather()));
					}

				} else {

					NodeRBT y = (NodeRBT) z.getFather().getFather().getL();
					if (y.getType() == NodeRBT.RED) {
						((NodeRBT) z.getFather()).setType(NodeRBT.BLACK);
						y.setType(NodeRBT.BLACK);
						((NodeRBT) z.getFather().getFather()).setType(NodeRBT.RED);
						z = (NodeRBT) z.getFather().getFather();
					} else {
						if (z == z.getFather().getL()) {
							z = (NodeRBT) z.getFather();
							rightRotate(z);
						}

						((NodeRBT) z.getFather()).setType(NodeRBT.BLACK);
						((NodeRBT) z.getFather().getFather()).setType(NodeRBT.RED);
						leftRotate((NodeRBT) z.getFather().getFather());
					}

				}
				((NodeRBT) root).setType(NodeRBT.BLACK); // Case 1 cuando es la raiz la cambio de color
			}

		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void delete(K key) {
		NodeRBT z = (NodeRBT) search(key);
		NodeRBT y = (NodeRBT) nil;

		if (z.getL() == nil || z.getR() == nil) {
			y = z;
		} else {
			y = (NodeRBT) super.successor((K) z.getKey());
		}

		NodeRBT x = (NodeRBT) nil;

		if (y.getL() != nil) {
			x = (NodeRBT) y.getL();
		} else {
			x = (NodeRBT) y.getR();
		}

		if (x != null) {
			x.setFather(y.getFather());
		}

		if (y.getFather() == nil) {
			root = x;
		} else if (y == y.getFather().getL()) {
			y.getFather().setL(x);
		} else {
			y.getFather().setR(x);
		}

		if (nil == null && x == null) {
			x = (NodeRBT) y.getFather();
		}

		if (y != z) {
			z.setKey(y.getKey());
			z.setValue(y.getValue());
		}
	

		if (((NodeRBT)y).getType() == NodeRBT.BLACK) {
			deleteFixUp((NodeRBT) x);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteFixUp(NodeRBT x) {

		while (x != root && x.getType() == NodeRBT.BLACK) {

			if (x == x.getFather().getL()) {
				NodeRBT w = (NodeRBT) x.getFather().getR();

				if (w.getType() == NodeRBT.RED) {
					w.setType(NodeRBT.BLACK);
					((NodeRBT) x.getFather()).setType(NodeRBT.RED);
					leftRotate((NodeRBT) x.getFather());
					w = (NodeRBT) x.getFather().getR();
				}

				if (((NodeRBT) w.getL()).getType() == NodeRBT.BLACK
						&& ((NodeRBT) w.getR()).getType() == NodeRBT.BLACK) {
					w.setType(NodeRBT.RED);
					x = (NodeRBT) x.getFather();

				} else {
					if (((NodeRBT) w.getR()).getType() == NodeRBT.BLACK) {
						((NodeRBT) w.getL()).setType(NodeRBT.BLACK);
						w.setType(NodeRBT.RED);
						rightRotate(w);
						w = (NodeRBT) x.getFather().getR();
					}
					w.setType(((NodeRBT) x.getFather()).getType());
					((NodeRBT) x.getFather()).setType(NodeRBT.BLACK);
					((NodeRBT) w.getR()).setType(NodeRBT.BLACK);
					leftRotate((NodeRBT) x.getFather());
					x = (NodeRBT) root;
				}

			} else {

				NodeRBT w = (NodeRBT) x.getFather().getL();

				if (w.getType() == NodeRBT.RED) {
					w.setType(NodeRBT.BLACK);
					((NodeRBT) x.getFather()).setType(NodeRBT.RED);
					rightRotate((NodeRBT) x.getFather());
					w = (NodeRBT) x.getFather().getL();
				}

				if (((NodeRBT) w.getR()).getType() == NodeRBT.BLACK
						&& ((NodeRBT) w.getL()).getType() == NodeRBT.BLACK) {
					w.setType(NodeRBT.RED);
					x = (NodeRBT) x.getFather();

				} else {
					if (((NodeRBT) w.getL()).getType() == NodeRBT.BLACK) {
						((NodeRBT) w.getR()).setType(NodeRBT.BLACK);
						w.setType(NodeRBT.RED);
						leftRotate(w);
						w = (NodeRBT) x.getFather().getL();
					}
					w.setType(((NodeRBT) x.getFather()).getType());
					((NodeRBT) x.getFather()).setType(NodeRBT.BLACK);
					((NodeRBT) w.getL()).setType(NodeRBT.BLACK);
					rightRotate((NodeRBT) x.getFather());
					x = (NodeRBT) root;
				}

			}
		}
		x.setType(NodeRBT.BLACK);

	}

	public void inOrden(NodeRBT x) {
		if (x != nil) {
			inOrden((NodeRBT) x.getL());
			String papa = null;
			if (x.getFather() != null) {
				papa = x.getFather().getValue() + "";
			}
			System.out.println(x.getKey() + " papa :" + papa + " color :" + x.getType());
			inOrden((NodeRBT) x.getR());
		}

	}
	

}
