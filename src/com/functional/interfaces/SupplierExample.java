package com.functional.interfaces;

import java.util.List;
import java.util.function.Supplier;

import data.Student;
import data.StudentDatabase;

public class SupplierExample {

	static Supplier<List<Student>> supplier = () -> StudentDatabase.getAllStudents();

	public static void main(String[] args) {

		System.out.println(supplier.get());
	}
}
