package com.streams;

import java.util.List;

import data.Student;
import data.StudentDatabase;

public class StreamsMatchExample {
	
	public static boolean allMatch() {
		List<Student> students = StudentDatabase.getAllStudents();
		return students.stream()
				.allMatch(s -> s.getGpa() > 3.9);
	}
	
	public static boolean anyMatch() {
		List<Student> students = StudentDatabase.getAllStudents();
		return students.stream()
				.anyMatch(s -> s.getGpa() > 3.9);
	}
	
	public static void main(String[] args) {
		
	}

}
