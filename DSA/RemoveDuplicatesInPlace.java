import java.util.HashMap;

public class RemoveDuplicatesInPlace {
	public static void main(String[] args) {
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int[] newArr = new int[nums.length];
		HashMap<Integer, Integer> map = new HashMap();
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			int currNum = nums[i];
			if (map.get(currNum) == null) {
				newArr[count] = currNum;
				count++;
			}
			map.put(currNum, i);
		}
		for (int i = 0; i < count; i++) {
			nums[i] = newArr[i];
		}
	}
}
