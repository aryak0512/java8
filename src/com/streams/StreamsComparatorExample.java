package com.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

public class StreamsComparatorExample {

	public static void main(String[] args) {
		System.out.println("By Name :" + sortStudentsByName());
		System.out.println("By GPA :" + sortStudentsByGpa());
	}

	public static List<Student> sortStudentsByName() {

		return StudentDatabase.getAllStudents().stream() // Stream<Student>
				.sorted(Comparator.comparing(Student::getName)) // Stream<Student>
				.collect(Collectors.toList());
	}

	public static List<Student> sortStudentsByGpa() {

		return StudentDatabase.getAllStudents().stream() // Stream<Student>
				.sorted(Comparator.comparing(Student::getGpa)) // Stream<Student>
				.collect(Collectors.toList());
	}

}
