package dynamicprogramming;

import java.util.HashMap;
import java.util.Vector;

public class FibonacciSeries {
	public static void main(String[] args) {
		// f(n) = f(n - 1) + f(n - 2)

		HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();


		//System.out.println(fib(20, 0, memo));
		System.out.println(fibBU(10));
	}


	static int fib(int n, int sum, HashMap<Integer, Integer> memo){

		if(memo.get(n) != null){
			return memo.get(n);
		}

		if(n < 0){
			return sum;
		}
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		sum = fib(n - 1, sum, memo) + fib(n - 2, sum, memo);
		memo.put(n, sum);
		return sum;
	}

	static int fibBU(int n){
		Vector<Integer> map = new Vector<>();
		map.add(0, 0);
		map.add(1, 1);

		for (int i = 2; i <= n; i++) {
			map.add(i,map.get(i - 1) + map.get(i - 2));
		}
		return map.get(n);
	}
}
