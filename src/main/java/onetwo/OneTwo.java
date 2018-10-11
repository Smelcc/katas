package onetwo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
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
		StringJoiner result = new StringJoiner(" ");
		Deque<String> pile = new ArrayDeque<>();
		for (String chiffre : input.split(" ")) {
			if (!pile.isEmpty() && !chiffre.equals(pile.peek())) {
				result.add(ecrireResultat(pile));
				pile.clear();
			}
			pile.add(chiffre);
		}
		result.add(ecrireResultat(pile));
		return result.toString();
	}

	private String ecrireResultat(Deque<String> pile) {
		return convert(pile.size(), pile.peek());
	}

	private String convert(int nombre, String value) {
		return Conversion.of(String.valueOf(nombre)) + " " + Conversion.of(value);
	}
}
