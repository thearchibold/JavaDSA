public class Graph {


	public static void main(String[] ags) {
		System.out.println("HELLO GRPAH");

		BST<String> bst = new BST<>("hello");
		bst.add("welcome");
		bst.add("welcom");
		bst.add("hme");
		bst.add("hm");
	}
}

class Node<T> {
	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node(T value) {
		this.data = value;
	}

	public void addNode(Node<T> node) {
		Node<T> current = this;
		while (current != null) {
			if (node.data instanceof String) {
				if (((String) node.data).length() < ((String) current.data).length()) {
					if (current.left == null) {
						current.left = node;
						break;
					}
					current = current.left;
				} else if (((String) node.data).length() > ((String) current.data).length()) {
					if (current.right == null) {
						current.right = node;
						break;
					}
					current = current.right;
				}
			}
		}
	}
}

class BST<T> {
	Node<T> root = null;

	public BST(T rootValue) {
		Node<T> rootNode = new Node<>(rootValue);
		this.root = rootNode;
	}

	public void add(T value) {
		Node<T> node = new Node<>(value);
		root.addNode(node);
	}
}
