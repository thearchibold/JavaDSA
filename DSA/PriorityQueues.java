import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class PriorityQueues {
	public static void main(String[] args) {

		List<String> events = List.of("ENTER John 3.75 50",
				"ENTER Mark 3.8 24",
				"ENTER Shafaet 3.7 35",
				"SERVED",
				"SERVED",
				"ENTER Samiha 3.85 36",
				"SERVED",
				"ENTER Ashley 3.9 42",
				"ENTER Maria 3.6 46",
				"ENTER Anik 3.95 49",
				"ENTER Dan 3.95 50",
				"SERVED");

		Priorities priorities = new Priorities();
		priorities.getStudents(events).forEach(student -> System.out.println(student.getName()));

	}

	static class Priorities {
		List<Student> prioritiesList = new ArrayList<>();
		Comparator<Student> priority = Comparator.comparing(Student::getCGPA).thenComparing(Student::getName).reversed().thenComparing(Student::getID);

		public List<Student> getStudents(List<String> events) {
			for (String eventSet :
					events) {
				String[] inputSet = eventSet.split("\s");
				String event = inputSet[0];
				if (Objects.equals(event, "ENTER")) {
					prioritiesList.add(new Student(inputSet[1], Double.parseDouble(inputSet[2]), Integer.parseInt(inputSet[3])));
				}
				if (Objects.equals(event, "SERVED")) {
					prioritiesList.sort(priority);
					prioritiesList.remove(0);
				}
			}
			return this.prioritiesList;
		}
	}

	static class Student {
		int id;
		String name;
		double cgpa;

		public Student(String name, double cgpa, int id) {
			this.cgpa = cgpa;
			this.id = id;
			this.name = name;
		}

		public int getID() {
			return this.id;
		}

		public String getName() {
			return this.name;
		}

		public double getCGPA() {
			return this.cgpa;
		}
	}
}
