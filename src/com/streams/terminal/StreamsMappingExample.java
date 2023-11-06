package com.streams.terminal;

import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

public class StreamsMappingExample {

	public static void main(String[] args) {
		
		List<Student> students = StudentDatabase.getAllStudents();
		List<String> name = students.stream().collect(Collectors.mapping(s -> s.getName(), Collectors.toList()));
		System.out.println(name);
	}

}
