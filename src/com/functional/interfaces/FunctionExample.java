package com.functional.interfaces;

import java.util.List;
import java.util.function.Function;

public class FunctionExample {

	// Input is string, output is also string
	static Function<String, String> f1 = String::toUpperCase;
	static Function<String, String> f2 = name -> name.concat("default");
	static Function<String, String> upper = String::toUpperCase;
	
	// function to calculate sum of arraylist elements
	static Function<List<Integer>, Integer> sumFunc = (list) -> {

		int sum = 0;

		for (Integer i : list)
			sum = sum + i;

		return sum;
	};
	
	
	// Input is string, output is Integer
	static Function<String, Integer> length = String::length;

	public static void main(String[] args) {

		System.out.println("Function f1 output : " + f1.apply("aryak"));
		System.out.println("Function f1 andThen f2 output : " + f1.andThen(f2).apply("aryak"));
		System.out.println("f1, f2 and then f1 output : " + f1.andThen(f2).andThen(f1).apply("aryak"));
		String composeOutput = f1.compose(f2).apply("Java");
		System.out.println("Function f2 output : " + composeOutput);
		
		/** sum of array elements **/
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
		System.out.println(sumFunc.apply(list));
		
	}

	
}
