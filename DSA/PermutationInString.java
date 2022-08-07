import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PermutationInString {

	public static void main(String[] args) {


		String s1 = "abc", s2 = "ba";

		//String substring = s1.length() < s2.length() ? s1: s2;
		System.out.println(checkInclusion(s1, s2));


	}

	static public boolean checkInclusion(String s1, String s2) {
		int start = 0;
		while (start <= s2.length() - s1.length()){
			String subString = s2.substring(start, start + s1.length());
			int count = getTotalSubCount(s1, subString);
			if(count == 0) return true;
			start += 1;
		}
		return false;
    }

    static int getTotalSubCount(String s1, String s2){
		char charArray1[] = s1.toCharArray();
		char charArray2[] = s2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		return String.valueOf(charArray1).equals(String.valueOf(charArray2)) ? 0 : 1;
	}
}
