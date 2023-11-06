package com.streams;

import java.util.List;
import java.util.stream.Collectors;

import data.StudentDatabase;

public class StreamsMapExample {

	static void printNamesList() {

		StudentDatabase.getAllStudents().stream() // Stream<Student>
				.map(student -> student.getName()) // Stream<String>
				.map(name -> name.toUpperCase()) // Stream<String>
				.collect(Collectors.toList()) // List<String>
				.forEach(s -> System.out.println(s));
	}
	
	static List<String> namesList() {

		return StudentDatabase.getAllStudents().stream() // Stream<Student>
				.map(student -> student.getName()) // Stream<String>
				.collect(Collectors.toList()) // List<String>
		;
	}

	static void printNamesSet() {

		StudentDatabase.getAllStudents().stream() // Stream<Student>
				.map(student -> student.getName()) // Stream<String>
				.map(name -> name.toUpperCase()) // Stream<String>
				.collect(Collectors.toSet()) // List<String>
				.forEach(s -> System.out.println(s));
	}

	public static void main(String[] args) {
		//printNamesList();
		System.out.println(namesList());
		;
	}

}
