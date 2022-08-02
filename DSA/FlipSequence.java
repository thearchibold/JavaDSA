public class FlipSequence {
	public static void main(String[] args) {
		int[] seq = {0,1,1, 0};
		int[] original = q(seq);

		int flips = 0;
		for (int i = 0; i < seq.length; i++) {
			if(seq[i] != original[i]){
				flips += 1;
			}
		}
		System.out.println(flips);

	}

	static int[] q(int[] a){
		int first = a[0];
		int[] c = new int[a.length];
		c[0] = first;
		for (int i = 1; i < a.length; i++) {
			c[i] = (int) Math.pow(0, c[i - 1]);
		}
		return  c;
	}

	public static int flipCount(int[] bits) {
        int[] possibleSequence1 = new int[bits.length];
        int[] possibleSequence2 = new int[bits.length];
        boolean flipped = false;
        for (int i = 0; i < bits.length; i++) {
            if (flipped) {
                possibleSequence1[i] = 0;
                possibleSequence2[i] = 1;
            } else {
                possibleSequence1[i] = 1;
                possibleSequence2[i] = 0;
            }
            flipped = !flipped;
        }
        int sequence1Flips = 0;
        int sequence2Flips = 0;


        for (int i = 0; i < bits.length; i++) {
            if(possibleSequence1[i] != bits[i]){
                sequence1Flips += 1;
            }
            if(possibleSequence2[i] != bits[i]){
                sequence2Flips += 1;
            }
        }
        return Math.min(sequence2Flips, sequence1Flips);
    }
}
