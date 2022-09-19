import java.util.LinkedList;

public class CenterOfLinkedList {
	public static void main(String[] args) {

		Node hare;
		Node tortoise;

		Node<Integer> list = new Node<>(1);
		list.add(2).add(3).add(4).add(5).add(6);


		hare = list;
		tortoise = list;

		// if hare == null || hare.next == null
		while (hare != null && hare.next != null){
			hare = hare.next.next;
			tortoise = tortoise.next;
		}
		System.out.println(tortoise.value);
	}


	static class Node<T> {
		T value;

		public Node next;

		public Node(){}

		public Node(T value){
			this.value = value;
		}

		public Node add(Node n){
			this.next = n;
			return this.next;
		}

		public Node add(T n){
			this.next = new Node(n);
			return this.next;
		}

	}
}
