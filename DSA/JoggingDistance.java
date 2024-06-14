public class JoggingDistance {
	public static void main(String[] args) {
		int[] distances = {1,2,3,4};
		int start = 2;
		int end = 4;
		System.out.println(joggingDistance(distances, start, end));

	}

	public static int joggingDistance(int[] distances, int start, int end) {
		int forwardPass = 0;
		int backwardPass = 0;

		for (int i = start; i < end; i++) {
			forwardPass += distances[i];
		}

		// backward loop end;
		int backend = distances.length + start;
		while (end < backend){
			int index = (end) % distances.length;
			backwardPass += distances[index];
			end++;
		}
		return Math.min(forwardPass, backwardPass);
	}
}
