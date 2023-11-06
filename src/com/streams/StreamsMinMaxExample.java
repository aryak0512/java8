package com.streams;

import java.util.List;

public class StreamsMinMaxExample {
	
	public static void main(String[] args) {
		
		List<Integer> integers = List.of(6,7,8,9,41);
		System.out.println(findMaxValue(integers));
		System.out.println(findMinValue(integers));
		
	}

	
	public static int findMaxValue(List<Integer> integers ) {
		return integers.stream()
				// y -> 6
				// y -> 7
				// y -> 8
				// y -> 9
				// y -> 41
				// x holds the max value after all iterations
				.reduce(0, (x, y) -> x > y ? x : y);
	}
	
	public static int findMinValue(List<Integer> integers ) {
		return integers.stream()
				// y -> 6
				// y -> 7
				// y -> 8
				// y -> 9
				// y -> 41
				// x holds the min value after all iterations
				.reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
	}
}
