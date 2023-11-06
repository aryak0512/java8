import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Student;

public class StudentComparator implements Comparator<Student> {

	private Map<Integer, String> params = Map.of(1, "gpa", 2, "name", 3, "gradeLevel");

	public StudentComparator(Map<Integer, String> params) {

		if (params != null) {
			this.params = params;
		}

		else {
			params = new HashMap<>();
			params.put(1, "gpa"); // double
			params.put(2, "name"); // String
			params.put(3, "gradeLevel"); // int

			System.out.println("Set : " + params);
		}

	}

	@Override
	public int compare(Student o1, Student o2) {

		try {

			List<String> fields = new ArrayList<>(params.values());
			System.out.println("Fields in config : " + fields);
			Class<?> cls = Class.forName("data.Student");
			Constructor<?> constructor = cls.getConstructor();
			Object s1 = constructor.newInstance();
			Object s2 = constructor.newInstance();

			for (String f : fields) {

				Field field = s1.getClass().getDeclaredField(f);
				field.setAccessible(true);
				String fieldType = field.getType().getName();
				System.out.println("Field type : " + fieldType);

				// fieldType -> int, double, String
				Class.forName("data.Student").getConstructor().newInstance();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
