import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
		int m = 3, n = 3;
		merge(nums1, m, nums2, n);


	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		List<Integer> together = new ArrayList<>(), sorted = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			together.add(nums1[i]);
		}
		for (int i = 0; i < n; i++) {
			together.add(nums2[i]);
		}
		sorted = together.stream().sorted().collect(Collectors.toList());
		nums1 = sorted.stream().mapToInt(Integer::intValue).toArray();

	}

	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < n; i++) {
			nums1[m + i] = nums2[i];
		}
		Arrays.sort(nums1);
	}
}
