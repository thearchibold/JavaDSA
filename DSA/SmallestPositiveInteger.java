import java.util.Arrays;

public class SmallestPositiveInteger {
	public static void main(String[] args) {
		int[] A = {6,1,2, 4, 5};
		Arrays.sort(A);
		int min = 1;
		for (int i = 0; i < A.length; i++) {
			if(A[i] == min){
				min++;
			}
		}
		System.out.println(min);
	}
}
