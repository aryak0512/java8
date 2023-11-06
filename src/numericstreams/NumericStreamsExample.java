package numericstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NumericStreamsExample {

	public Optional<Integer> sumOfNumbers(List<Integer> list) {
		return list.stream().reduce(Integer::sum);
	}

	public static void main(String[] args) {
		List<Integer> removeables = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(87);
		list.add(87);
		list.add(87);
		list.add(84);

		for (int p : list) {
			if (p == 87) {
				removeables.add(p);
			}
		}

		list.removeAll(removeables);
		System.out.println(list);
	}

}
