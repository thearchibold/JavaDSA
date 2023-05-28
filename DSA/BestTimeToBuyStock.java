public class BestTimeToBuyStock {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int[][] sellingMap = new int[prices.length][prices.length];
		int profit = 0, buyIndex = 0, sellIndex = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int _profit = prices[j] - prices[i];
				sellingMap[j][i] = _profit;
				if(_profit > profit){
					profit = _profit;
					buyIndex = j;
					sellIndex = i;
				}
			}
		}
	}
}
