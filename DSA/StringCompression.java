public class StringCompression {
	public static void main(String[] args) {
		String message = "abaasass";

		StringBuilder string = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int count = 1;
			char current = message.charAt(i);
			string.append(current);
			for (int j = i + 1; j < message.length(); j++) {
				char next = message.charAt(j);
				if (current == next) {
					count += 1;
				}else{
					i = j - 1;
					break;
				}
			}
			if(count > 1){
				string.append(count);
			}
		}
		System.out.println(string);
	}
}
