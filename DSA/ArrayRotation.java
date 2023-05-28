import java.util.Arrays;

public class ArrayRotation {
	public static void main(String[] args) {
		int[] nums = {1,2};
		int k = 3;

		rotateBigValues(nums, k);

	}

	public static void rotateSmallValues(int[] nums, int k){
		int rotateBy = k % nums.length;
		int temp = nums[nums.length - 1];
		for (int j = 0; j < rotateBy; j++) {
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = temp;
			temp = nums[nums.length - 1];
		}
	}

	public static void rotateBigValues(int[] nums, int k){
		int rotateBy = k % nums.length;

		if(k > rotateBy && rotateBy % 2 != 0){
			rotateBy+=1;
		}

		int[] rightArray = Arrays.copyOfRange(nums, rotateBy , nums.length);
		int[] leftArray = Arrays.copyOfRange(nums, 0, rotateBy);

		System.arraycopy(rightArray, 0, nums, 0, rightArray.length);
		System.arraycopy(leftArray, 0, nums, rightArray.length, leftArray.length);

		System.out.println(Arrays.toString(leftArray));

	}
}
