public class FloodFill {
	public static void main(String[] args) {
		int image[][] = {
				{0,0,0},
				{0,0,0}};
		int sr = 1, sc = 0, color = 2;
		floodFill(image, sr, sc, color);
	}

	 static public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int height = image.length;
		int width = image[0].length;
		int initialColor = image[sr][sc];
		if(initialColor == color){
			return image;
		}

		fillRecursion(image,sr, sc, color, initialColor, height, width);
		return image;
    }

	static public void fillRecursion(int[][] image, int sr, int sc, int color,int initialColor, int height, int width){

		if(sc < 0 || sc >= width  || sr < 0 || sr >= height ){
			return;
		}
		int colorAtPosition = image[sr][sc];
		if(colorAtPosition == initialColor){
			image[sr][sc] = color;
			fillRecursion(image,sr, sc - 1,color, initialColor, height, width);
			fillRecursion(image,sr, sc + 1,color, initialColor, height, width);
			fillRecursion(image,sr - 1, sc,color, initialColor, height, width);
			fillRecursion(image,sr + 1, sc,color, initialColor, height, width);
		}

		// check left = sr, sc - 1
		// check right = sr, sc + 1
		// check top = sr - 1, sc
		// check bottom = sr + 1, sc



	}



}
