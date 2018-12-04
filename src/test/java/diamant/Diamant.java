package diamant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Diamant {

	public static List<String> générerDiamant(char input) {
		List<String> list = new ArrayList<>();
		list = initialiserDiamantAvecLeA(list);
		list = itererSurLAlphabet(list, input);
		dupliquerLignes(list);
		return list;
	}

	private static List<String> itererSurLAlphabet(List<String> list, char input) {
		String espaces = "";
		for (char lettreCourante = 'B'; lettreCourante <= input; lettreCourante++) {
			espaces += (list.size() == 1) ? " " : "  ";
			list = ajouterLettre(list, String.valueOf(lettreCourante) + espaces + String.valueOf(lettreCourante));
		}
		return list;
	}

	private static List<String> initialiserDiamantAvecLeA(List<String> list) {
		if (list.size() == 0) {
			list = ajouterLettre(list, "A");
		}
		return list;
	}

	private static void dupliquerLignes(List<String> list) {
		for (int i = list.size() - 1; i > 0; i--) {
			list.add(list.get(i - 1));
		}
	}

	private static List<String> ajouterLettre(List<String> list, String chaineLettre) {
		list = ajouterEspaces(list);
		list.add(chaineLettre);
		return list;
	}

	private static List<String> ajouterEspaces(List<String> list) {
		return list.stream().map(s -> " " + s + " ").collect(Collectors.toList());
	}
}
