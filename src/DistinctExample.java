import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DistinctExample {

	public static void main(String[] args) {

		Employee e1 = new Employee("muddu", "34");
		Employee e2 = new Employee("maryak", "34");
		Employee e3 = new Employee("mashi", "C");
		Employee e4 = new Employee("mohasin", "40");

		boolean linked = false;
		List<Employee> employees = new ArrayList<>();
		employees.add(e4);
		employees.add(e3);
		employees.add(e2);
		employees.add(e1);
		Collection<Employee> nonDuplicatedEmployees = null;

		if (linked) {

			nonDuplicatedEmployees = employees.stream().<Map<String, Employee>>collect(
					LinkedHashMap<String, Employee>::new, (m, e) -> m.put(e.getAges(), e), Map::putAll).values();
		
		} else {
			
			nonDuplicatedEmployees = employees.stream()
					.<Map<String, Employee>>collect(HashMap::new, (m, e) -> m.put(e.getAges(), e), Map::putAll)
					.values();
		}

		nonDuplicatedEmployees.forEach(System.out::println);

	}

}
