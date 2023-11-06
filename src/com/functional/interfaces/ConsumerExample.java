package com.functional.interfaces;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDatabase;

public class ConsumerExample {

	static Consumer<Student> c1 = student -> System.out.print(student.getName());
	static Consumer<Student> c2 = student -> System.out.println(student.getActivities());
	static List<Student> studentList = StudentDatabase.getAllStudents();

	public static void main(String[] args) {

		// decalring the consumer
		Consumer<String> c = s -> System.out.println(s.toUpperCase());

		// passing input to the consumer
		c.accept("aryak");

		printAllStudentsGreaterThanGrade3();
		printAllStudents();
	}

	public static void printAllStudents() {
		studentList.forEach(c1.andThen(c2));
	}

	public static void printAllStudentsGreaterThanGrade3() {

		studentList.forEach((student) -> {
			if (student.getGradeLevel() >= 3) {

				// consumers chained & input passed thorugh .accept() method
				c1.andThen(c2).accept(student);
			}
		});

	}

}
