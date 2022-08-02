import java.util.*;

public class ArrayRotation {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 10;
		int rotateBy = k % arr.length;
		System.out.println(rotateBy);
		int[] subList = Arrays.copyOfRange(arr, arr.length - rotateBy, arr.length);
		int[] remainingArray = Arrays.copyOfRange(arr, 0, arr.length - rotateBy);

	}
}
