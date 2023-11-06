package com.streams.terminal;

import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

public class StreamsCountingExample {

	public static void main(String[] args) {
		List<Student> students = StudentDatabase.getAllStudents();
		Long count = students.stream()
				.filter(s -> s.getGpa() >= 3.9)
				.collect(Collectors.counting());
		System.out.println(count);
	}

}
