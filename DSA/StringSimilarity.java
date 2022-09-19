import java.util.ArrayList;
import java.util.List;

public class StringSimilarity {

	public static void main(String[] args) {
		String s = "ababaa";
		ArrayList<String> suffixes = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			suffixes.add(s.substring(i));
		}

		System.out.println(suffixes);
	}
}
