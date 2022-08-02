public class ReverseWordInString {
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		String[] splited = s.split("\\s+");
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < splited.length; i++) {
			output.append(reverseWord(splited[i], 0, splited[i].length() - 1));

			if (i < splited.length - 1) {
				output.append(' ');
			}
		}
		System.out.println(output.toString());

	}

	static String reverseWord(String word, int start, int end) {
		char[] w = word.toCharArray();
		if (start >= end) {
			return String.valueOf(w);
		}
		char temp = w[start];
		w[start] = w[end];
		w[end] = temp;
		start++;
		end--;
		return reverseWord(String.valueOf(w), start, end);
	}
}
