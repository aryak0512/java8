package com.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

public class StreamsExample {

	static Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
	static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;

	public static void main(String[] args) {

		List<Student> studentList = StudentDatabase.getAllStudents();
		
		Map<String, List<String>> result = studentList
				.parallelStream() // Stream<Student>
				.peek(System.out ::println)
				.filter(p1.and(p2)) // Stream<Student>
				.collect(Collectors.toMap(Student::getName, Student::getActivities)); // Map<String, List<String>>

		System.out.println(result);
	}

}
