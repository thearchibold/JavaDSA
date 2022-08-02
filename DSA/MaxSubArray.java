import java.util.*;

public class MaxSubArray {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int total = 6, sub = 3;
		List<Integer> numbers = List.of(5, 3, 5, 2, 3, 2);

		int max = 1;
		// using the deque to hold the temp sub array
		for (Integer n :
				numbers) {
			deque.addFirst(n);

			if (deque.size() == sub) {
				LinkedHashSet<Integer> set = new LinkedHashSet<>(deque);
				max = Math.max(set.size(), max);
				deque.removeLast();
			}
		}
		System.out.println(max);

	}
}
