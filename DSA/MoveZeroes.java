import java.util.ArrayDeque;
import java.util.Deque;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};

		// using Deque O(n)
		Deque<Integer> moved = new ArrayDeque<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if(nums[i] == 0){
				moved.addLast(nums[i]);
			}else{
				moved.addFirst(nums[i]);
			}
		}
		int[] result = moved.stream().mapToInt(Integer::intValue).toArray();

		// using inplace method, O(n2)
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if(nums[i] == 0){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		System.out.println(nums);
		System.out.println(result);
	}
}
