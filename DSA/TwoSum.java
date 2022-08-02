import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int target = 9;
		int[] indices = new int[2];
		HashMap<Integer, Integer> set = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if(set.containsKey(target - val)){
				int otherIndex = set.get(target - val);
				System.out.println(i);
				System.out.println(otherIndex);
				indices[0] = otherIndex + 1;
				indices[1] = i + 1;
				break;
			}else{
				set.put(val, i);
			}
		}
		System.out.println(indices); ;

	}
}
