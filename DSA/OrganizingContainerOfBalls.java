import java.util.*;

public class OrganizingContainerOfBalls {

	public static String organizingContainers(List<List<Integer>> containerBalls) {
    // Write your code here
		List<Integer> containerSum = new ArrayList<>();
		List<Integer> types = new ArrayList<>();


		for (List<Integer> con :
				containerBalls) {
			containerSum.add(con.stream().reduce(0, Integer::sum));
		}
		for (int i = 0; i < containerBalls.size(); i++) {
			List<Integer> tempTypes = new ArrayList<>();
			for (int j = 0; j < containerBalls.size(); j++) {
				tempTypes.add(containerBalls.get(j).get(i));
			}
			types.add(tempTypes.stream().reduce(0, Integer::sum));
		}
		Collections.sort(containerSum);
		Collections.sort(types);

		String feedback = "Possible";
		for (int i = 0; i < containerSum.size(); i++){
			if(!Objects.equals(containerSum.get(i), types.get(i))){
				feedback = "Impossible";
				break;
			}
		}

		return feedback;
    }

	public static void main(String[] args){
		List<List<Integer>> containerBalls = List.of(
				List.of(1, 1),
				List.of(1, 1)
		);

		System.out.println(organizingContainers(containerBalls));


	}
}
