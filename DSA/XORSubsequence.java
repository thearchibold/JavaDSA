import java.util.ArrayDeque;
import java.util.Deque;

public class XORSubsequence {
	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 1, 5, 2, 1, 3, 1, 3, 1, 3};
		int k = 2;
		int length = 1;
		Deque<Integer> subList = new ArrayDeque<>();


		if (arr.length <= 1) {
			return;
		}

		for (int current : arr) {
			if (subList.peek() != null) {
				int latestItem = subList.peek();
				if (xor(current, latestItem) == k) {
					int _length = subList.size() + 1;
					length = Math.max(_length, length);
				} else {
					subList = new ArrayDeque<>();
				}
			}

			subList.push(current);
		}
		System.out.println(length);
	}


	static int xor(int a, int b) {
		return a ^ b;
	}
}
