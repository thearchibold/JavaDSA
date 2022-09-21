import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Palinddrome {
	public static void main(String[] args) {
		System.out.println(canBePalindrome("aab"));

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
}
