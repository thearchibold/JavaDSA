import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
	public static void main(String[] args) {

		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

	static public int lengthOfLongestSubstring(String s) {
		Deque<Character> window = new ArrayDeque<>();
		int longest = 0;
		for (char letter :
				s.toCharArray()) {
			window.addFirst(letter);
			int count = uniqueCount(window);
			if(count > longest)
				longest = count;

			if(count < window.size()){
				window.removeLast();
			}
		}

		return longest;
    }

	public static int uniqueCount(Deque<Character> window){
		HashSet<Character> set = new HashSet<>();
		for (Character c :
				window) {
			set.add(c);
		}

		return set.size();
	}
}
