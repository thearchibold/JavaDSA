import java.util.regex.Pattern;

public class RegexIPValidator {

	public static void main(String[] args){
		String ipAddress = "123.123.124.12";
		System.out.println("Regex Matcher");
		String block = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
		String pattern = block + "\\." + block + "\\." + block + "\\." + block;
		System.out.println(pattern);
		boolean matches = Pattern.matches(pattern, ipAddress);
		System.out.println(matches);
	}
}
