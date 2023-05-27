import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		Map<Integer, Integer> map = new HashMap<>();
		int key = 0, value = 0;
		for (int num :
				nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for(Map.Entry<Integer, Integer> set: map.entrySet()){
			if(set.getValue() > value){
				key = set.getKey();
				value = set.getValue();
			}
		}
		System.out.println(key);
	}
}
