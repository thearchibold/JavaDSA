import java.util.ArrayList;

public class RemoveNthNodeFromList {
	public static void main(String[] args) {


		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);

		ListNode sre = removeNthFromEnd(head, 2);

		System.out.println(sre);


	}

	static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getLinkedListSize(head, 1);

		if(size <= n){
			return head.next;
		}
		int iterCount = size - n;
		ListNode temp = null;


		for (int i = 0; i < iterCount; i++) {
			if(i == iterCount - 1){

				head.next = head.next.next;

				for(ListNode p = head; p != null; p=p.next){
					temp = new ListNode(p.val, temp);
				}
				break;
			}
			temp = new ListNode(head.val, temp);
			head = head.next;
		}

		return reverse(temp);
    }

	static ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

	static int getLinkedListSize(ListNode node, int count){
		if(node.next == null){
			return count;
		}
		count += 1;
		node = node.next;
		return getLinkedListSize(node, count);
	}


	static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
