package com.functional.interfaces;

import java.util.function.Predicate;

public class PredicateExample {

	static Predicate<Integer> p1 = (t) -> t % 2 == 0;
	static Predicate<Integer> p2 = (t) -> t % 5 == 0;
	static Predicate<Integer> p3 = (t) -> t > 10;
	
	
	public static void main(String[] args) {
		
		boolean p1Result = p1.test(8);
		System.out.println(p1Result);
		
		// predicate chaining

		// and
		System.out.println(p1.or(p2).test(15));

		// or
		System.out.println(p1.and(p2).test(15));

		// negate
		System.out.println(p1.and(p2).negate().test(15));
		
		System.out.println("Results : ");
		System.out.println(p1.and(p2).and(p3).test(15));
		System.out.println(p1.and(p2).and(p3).test(30));
	}
}
