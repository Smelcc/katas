package onetwo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OneTwo {

	enum Conversion {
		ONE("1", "one"), TWO("2", "two"), THREE("3", "three"), FOUR("4", "four"), FIVE("5", "five"), SIX("6", "six"),
		SEVEN("7", "seven"), EIGHT("8", "eight"), NINE("9", "nine");
		private Conversion(String value, String displayValue) {
			this.value = value;
			this.displayValue = displayValue;
		}

		private String value;
		private String displayValue;

		public static String of(String input) {
			return Stream.of(values()).filter(conversion -> conversion.value.equals(input))
					.map(conversion -> conversion.displayValue).findFirst().get();
		}
	}

	public String readValue(String input) {
		return Stream.of(input.split(" ")).map(value -> "one " + Conversion.of(value)).collect(Collectors.joining(" "));
	}
}
