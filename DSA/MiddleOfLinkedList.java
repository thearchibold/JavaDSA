import java.util.ArrayList;
import java.util.List;

public class MiddleOfLinkedList {
	public static void main(String[] args) {
	}

	public ListNode middleNode(ListNode head) {
        int size = 1;
        ListNode mid = head;
		while (head.next !=null){
			size += 1;
			head = head.next;
		}
		for (int i = 0; i < getMid(size); i++) {
			mid = mid.next;
		}
        return mid;

    }

    int getMid(int size){
        if(size % 2 == 0){
            return (size / 2 );
        }else {
            return Math.round(size / 2);
        }
    }

	static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
