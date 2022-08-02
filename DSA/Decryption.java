import java.util.ArrayList;
import java.util.List;

public class Decryption {

	public static String encryption(String s) {
		// Write your code here
		String sentencesWithoutSpace = s.replace(" ", "");
		double root = Math.sqrt(sentencesWithoutSpace.length());
		double row = Math.floor(root);
		double column = Math.ceil(root);

		List<String> arr = new ArrayList<>();
		for (int i = 0; i < sentencesWithoutSpace.length(); i += column) {
			arr.add(sentencesWithoutSpace.substring(i,
					i + column < sentencesWithoutSpace.length() ?
							i + (int) column : sentencesWithoutSpace.length()));
		}
		System.out.println(arr);

		StringBuilder output = new StringBuilder();
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < column; j++) {
				try {
					output.append(arr.get(j).charAt(i));
				} catch (Exception e) {
					//ignore
				}
			}
			output.append(" ");
		}
		return output.toString();
	}


	public static void main(String[] args){
		String sentence =  "haveaniceday";


		System.out.println(encryption(sentence));


	}
}
