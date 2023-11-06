package com.functional.interfaces;

import java.util.List;
import java.util.function.Predicate;

import data.Student;
import data.StudentDatabase;

public class PredicateStudentExample {

	static Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
	static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;
	static List<Student> studentList = StudentDatabase.getAllStudents();

	public static void main(String[] args) {
		filterStudentsByGrade();
		filterStudentsByGpa();
		filterStudents();
	}

	public static void filterStudents() {

		System.out.println("In filterStudents method :");
		studentList.forEach(student -> {

			if (p1.and(p2).test(student))
				System.out.println(student);

			if (p1.or(p2).test(student))
				System.out.println(student);

			if (p1.and(p2).negate().test(student))
				System.out.println(student);

		});

	}

	public static void filterStudentsByGrade() {

		System.out.println("In filterStudentsByGrade method :");
		studentList.forEach(student -> {

			if (p1.test(student))
				System.out.println(student);

		});
	}

	public static void filterStudentsByGpa() {

		System.out.println("In filterStudentsByGpa method :");
		studentList.forEach(student -> {

			if (p2.test(student))
				System.out.println(student);

		});
	}

}
