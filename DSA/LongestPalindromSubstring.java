public class LongestPalindromSubstring {

	public static void main(String[] args) {

		String test = "bb";
		String longestPalindrome = "";


		for (int i = 0; i < test.length(); i++) {
			for (int j = i + 1; j <= test.length(); j++) {
				String sb = test.substring(i, j);
				longestPalindrome = isPalindrome(sb) && sb.length() > longestPalindrome.length() ? sb : longestPalindrome;
			}
		}
		System.out.println(longestPalindrome);

	}

	public static boolean isPalindrome(String s){
		s = s.toLowerCase();
		int length = s.length();
		int left = (int) Math.floor(length / 2);
		int right = length % 2 == 0 ? left : left + 1;
		String leftString = s.substring(0, left);
		String rightString = new StringBuilder(s.substring(right)).reverse().toString();
		return leftString.equals(rightString);
	}
}
