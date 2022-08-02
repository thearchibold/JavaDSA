import java.util.List;

public class GameOnArray {

	public static void main(String[] args) {
		int[] game = {0,0,1,1,1, 0};
		System.out.println(canWin(3, game));
	}


	public static boolean canWin(int leap, int[] game) {
		return isSolvable(leap, game, 0);
	}

	private static boolean isSolvable(int leap, int[] game, int i) {
		// Base Cases
		if (i >= game.length) {
			return true;
		} else if (i < 0 || game[i] == 1) {
			return false;
		}

		game[i] = 1; // marks as visited

		// Recursive Cases
		return isSolvable(leap, game, i + leap) ||
				isSolvable(leap, game, i + 1) ||
				isSolvable(leap, game, i - 1);
	}
}
