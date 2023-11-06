package com.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class FileFormat {

	public static void main(String[] args) {

		Map<Integer, String> config = new HashMap<>();
		config.put(0, "header");
		config.put(1, "firstName");
		config.put(2, "middleName"); // optional
		config.put(3, "lastName"); // optional

		List<String> lines =

				List.of("10|Aryak|Vinod|Deshpande|", "10|Aryak||", "10|||", "10|Aryak||Deshpande",
						"10|Aryak|Vinod|Deshpande", "10|Aryak|Vinod|Deshpande|");

		Consumer<String> c = line -> {

			String[] tokens = line.split("\\|");
			System.out.println(tokens.length);

		};

		lines.forEach(c);

	}

}
