public class BinarySearch {
	public static void main(String[] args) {
		int[] numbers = {2,5};
		int target = 5;
		int ans = 1;
		int leftPtr = 0;

		int rightPtr = numbers.length;
		int mid = calculateMid(leftPtr, rightPtr);
		int index = printMids(leftPtr, mid, rightPtr, numbers, target);
		System.out.println(index == ans ? "PASSED" : "FAILED");

	}

	static int printMids(int left, int mid, int rgt, int[] arr, int target) {

		if (arr[mid] == target) {
			return mid;
		} else {
			if (left <= rgt) {
				return -1;
			}
			if (arr[mid] > target) {
				rgt = mid;
			}
			if (arr[mid] < target) {
				left = mid;
			}
			mid = calculateMid(left, rgt);
			return printMids(left, mid, rgt, arr, target);
		}
	}

	static int calculateMid(int left, int right) {
		if (left == right)
			return right;
		return left + (right - left) / 2;
	}
	// base case is

}
