import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
	public static void main(String[] args) {
		String[] words = {"code", "doce", "ecod", "framer", "frame"};
		HashMap<String, Integer> anagramMap = new HashMap<>();
		for (String word :
				words) {
			word = sort(word);
			anagramMap.put(word, anagramMap.getOrDefault(word, 0));
		}
		ArrayList<String> finalWords = new ArrayList<>();
		anagramMap.forEach((key, count) -> {
			if(count > 1){
				finalWords.add(key);
			}
		});

	}

	static String sort(String string) {
		char[] chars = string.toCharArray();
		Arrays.sort(chars);
		return chars.toString();
	}

}
