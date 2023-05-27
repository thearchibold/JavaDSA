import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicatesInPlace2 {
	public static void main(String[] args) {
		int[] nums = {-3,-1,0,0,0,3,3};

		// used LinkedHashMap because there was a need to maintain order.
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (int num : nums) {
			int mapValue = map.getOrDefault(num, 0);
			if (mapValue < 2) {
				map.put(num, mapValue + 1);
			}
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> set: map.entrySet()){
			Integer value = set.getKey();
			Integer iterator = set.getValue();
			for (int i = 0; i < iterator; i++) {
				nums[count] = value;
				count++;
			}
		}
		System.out.println(count);
	}
}
