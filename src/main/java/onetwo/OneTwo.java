package onetwo;

import java.util.stream.Stream;

public class OneTwo {

	public String transformation(String parametres) {
		int count = parametres.split(" ").length;

		return Chiffre.of(count) + " un";
	}

	enum Chiffre {
		un(1), deux(2), trois(3), quatre(4);

		int valeur;

		Chiffre(int nombre) {
			valeur = nombre;
		}

		public static String of(int count) {
			return Stream.of(values())
					.filter(value -> value.valeur == count)
					.findFirst()
					.get().toString();
		}
	}
}
