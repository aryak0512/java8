package com.streams;

import java.util.List;
import java.util.function.BinaryOperator;

import data.Student;
import data.StudentDatabase;

public class StreamMapReduceExample {

	public int totalNotebooks() {

		List<Student> students = StudentDatabase.getAllStudents();
		BinaryOperator<Integer> bi = (a, b) -> a + b;
		return students.stream()
				.filter(s -> s.getGradeLevel() >= 3)
				.filter(s -> s.getGender().equals("female"))
				.map(Student::getNoteBooks)
				.reduce(0, bi);
	}

	public static void main(String[] args) {

	}

}
