package com.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsFactoryExample {

	public static void main(String[] args) {

		// 1. of() method
		Stream<String> s = Stream.of("alex", "ben", "chloe");
		s.forEach(System.out::println);

		// 2. iterate() method : creates infinite stream
		// Stream.iterate(1, t -> t * 2).forEach(System.out::println);

		// 3. generate() method. Takes supplier as argument
		Supplier<Integer> supplier = () -> new Random().nextInt();
		Stream.generate(supplier).limit(5).forEach(System.out::println);
	}

}
