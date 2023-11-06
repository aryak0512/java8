package com.streams;

import java.util.List;
import java.util.Optional;

import data.Student;
import data.StudentDatabase;

public class StreamsFindAnyFirstExample {

	public static void main(String[] args) {

		Optional<Student> opt = findAnyStudent();

		if (opt.isPresent())
			System.out.println(opt.get());
		else
			System.out.println("Not found");
	}

	public static Optional<Student> findAnyStudent() {
		List<Student> students = StudentDatabase.getAllStudents();
		return students.stream().filter(s -> s.getGpa() > 3.9).findAny();
	}

	public static Optional<Student> findFirstStudent() {
		List<Student> students = StudentDatabase.getAllStudents();
		return students.stream().filter(s -> s.getGpa() > 3.9).findFirst();
	}

}
