import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ClosestNumbers {
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		integers.add(6);
		integers.add(2);
		integers.add(4);
		integers.add(10);
		minimumAbsoluteDifference(integers);

	}

	static List<Integer[]> minimumAbsoluteDifference(List<Integer> integers) {
		int minimum = Integer.MAX_VALUE;
		List<Integer[]> pairs = new ArrayList<>();
		HashMap<Integer, List<Integer[]>> container = new HashMap<>();

		for (int i = 0; i < integers.size() - 1; i++) {
			int current = integers.get(i);
			for (int j = i + 1; j < integers.size(); j++) {
				int next = integers.get(j);
				int absoluteDifference = Math.abs(next - current);
				Integer[] pair = new Integer[2];
				if (absoluteDifference <= minimum) {
					minimum = absoluteDifference;
					if (current < next) {
						pair[0] = current;
						pair[1] = next;
					} else {
						pair[1] = current;
						pair[0] = next;
					}
				}
				List<Integer[]> exitingPairs = container.getOrDefault(absoluteDifference, new ArrayList<>());
				exitingPairs.add(pair);
				container.put(absoluteDifference, exitingPairs);
			}
			int minimumKey = Collections.min(container.keySet());
			List<Integer[]> pairsM = container.get(minimumKey);
			pairsM.forEach(pair -> {
				System.out.println(pair[0] + " " + pair[1]);
			});

		}

		return pairs;
	}
}
