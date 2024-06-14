import java.util.HashMap;
import java.util.Map;

public class NumberGenerator {
	public static void main(String[] args) {
		System.out.println("Working");
		String digits = "8459761203";
		String num = "5439";
		System.out.println(calculate(digits, num));;
	}

	public static int calculate(String digits, String num){
		char[] chars = digits.toCharArray();
		Map<Character, Integer> lookup = new HashMap();
		int lastIndex = 0;
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			lookup.put(chars[i], i);
		}

		for (char c : num.toCharArray()) {
			int index = lookup.get(c);
			count += Math.abs(index - lastIndex);
			lastIndex = index;
		}

		return count;
	}
}
