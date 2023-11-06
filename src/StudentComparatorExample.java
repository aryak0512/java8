import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDatabase;

public class StudentComparatorExample {

	public static void main(String[] args) {

		List<Student> students = StudentDatabase.getAllStudents();
		Comparator<Student> c1 = (s1, s2) -> s1.getGpa() == s2.getGpa() ? 0 : s1.getGpa() < s2.getGpa() ? -1 : 1;
		Comparator<Student> c2 = (s1, s2) -> s1.getGpa() == s2.getGpa() ? s1.getName().compareTo(s1.getName()) : 0;
		Collections.sort(students, c1);
		Consumer<Student> consumer = student -> System.out.println(student.getName() + "-" + student.getGpa());
		Collections.sort(students, new StudentComparator(null));

	}

}
