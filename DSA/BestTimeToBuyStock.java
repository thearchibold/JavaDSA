public class BestTimeToBuyStock {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		profitWithLarge(prices);
	}

	public static int doubleLoop(int[] prices){
		int[][] sellingMap = new int[prices.length][prices.length];
		int profit = 0, buyIndex = 0, sellIndex = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int _profit = prices[j] - prices[i];
				sellingMap[j][i] = _profit;
				if(_profit > profit){
					profit = _profit;
				}
			}
		}
		return profit;
	}

	public static int profitWithLarge(int[] prices){
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;

		// so basically keep track of the min price and subtract from all the others.
		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			profit = Math.max(profit, prices[i] - minPrice);
		}
		return profit;
	}
}
