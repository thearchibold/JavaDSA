import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Palinddrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("abba"));

	}

	static boolean canBePalindrome(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		AtomicInteger numberOfOddCharacters = new AtomicInteger();
		for (Character c :
				s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		map.forEach((c, n) ->{
			if(n % 2 != 0){
				numberOfOddCharacters.addAndGet(1);
			}
		});

		return numberOfOddCharacters.get() <= 1;
	}

	static boolean isPalindrome(String s){
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		if(s.equals("")){
			return true;
		}
		int stringLength = s.length();
		boolean isEven = stringLength % 2 == 0;
		int leftIndex = stringLength / 2;
		String leftString = s.substring(0, leftIndex);
		String rightString;
		if(isEven){
			rightString = s.substring(leftIndex);
		}else{
			rightString = s.substring(leftIndex + 1);
		}
		rightString = new StringBuilder(rightString).reverse().toString();
		return leftString.equals(rightString);
	}
}
