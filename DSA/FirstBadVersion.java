public class FirstBadVersion {
	public static void main(String[] args) {
		System.out.println(firstBadVersion(10));
	}

	static public int firstBadVersion(int n) {
		var low = 1;

		for (var high = n; low < high; ) {
			var mid = low + (high - low) / 2;

			if (isBadVersion(mid))
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

	static boolean isBadVersion(int n) {
		return false; //this function it given
	}
}
