public class SearchInsertPosition {
	public static void main(String[] args) {

		int[] arr = {1,3, 5, 6};




		System.out.println(searchInsert(arr, 2));

	}

	static public int searchInsert(int[] arr, int target) {

		if(target < arr[0])
			return 0;
		if(target > arr[arr.length - 1])
			return arr.length;

		int left = 0;
		int right = arr.length - 1;
		int mid = calculateMiddle(left, right);

		return recursiveSearch(left, mid, right, target, arr);

    }



	static int recursiveSearch(int left, int mid, int right, int target, int[]arr){
		int valueAtPosition = arr[mid];

		if(left >=right){
			return mid;
		}

		if(valueAtPosition > target){
			right = mid;
			mid = calculateMiddle(left, right);
		}
		else if(valueAtPosition < target){
			left = mid + 1;
			mid = calculateMiddle(left, right);
		}else {
			return mid;
		}
		return recursiveSearch(left, mid, right, target, arr);
	}

	static int calculateMiddle(int left, int right){
		return left + ((right - left) / 2);
	}
}
