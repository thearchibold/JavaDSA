import java.util.Arrays;

public class SquaresOfSortedArray {
	public static void main(String[] args) {
		int[] arr = {-4,-1,0,3,10};

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.pow(arr[i], 2);
		}
		Arrays.sort(arr);
		System.out.println(arr);
	}
}
