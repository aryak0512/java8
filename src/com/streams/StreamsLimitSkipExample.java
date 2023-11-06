package com.streams;

import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

	public static void main(String[] args) {
		List<Integer> list = List.of(6, 7, 8, 9, 41);
		System.out.println(skip(list));
		System.out.println(limit(list));
	}

	// 58
	public static Optional<Integer> skip(List<Integer> list) {

		return list.stream()
				.skip(2)
				.reduce((a, b) -> a + b);
	}

	// 13
	public static Optional<Integer> limit(List<Integer> list) {
		
		return list.stream()
				.limit(2)
				.reduce((a, b) -> a + b);
	}

}
