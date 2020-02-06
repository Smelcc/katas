package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Combinaison {
	CARRE(Combinaison::récupérerCarré),
	SUITE(Combinaison::récupérerSuite),
	BRELAN(Combinaison::récupérerBrelan),
	FULL(Combinaison::récupérerFull),
	PAIRES(Combinaison::récupérerPaires);
	private Combinaison(Function<List<Carte>, ValeurCarte> règleAAppliquer) {
		this.règleAAppliquer = règleAAppliquer;
	}

	private Function<List<Carte>, ValeurCarte> règleAAppliquer;

	private static List<ValeurCarte> récupérerBrelan(List<Carte> cartes) {
		List<ValeurCarte> valeursDeLaMain = cartes.stream().map(Carte::getValeurCarte).collect(Collectors.toList());
		return Stream.of(ValeurCarte.values()).filter(value -> Collections.frequency(valeursDeLaMain, value) == 3)
				.collect(Collectors.toList());
	}

	private static List<ValeurCarte> récupérerFull(List<Carte> cartes) {
		ValeurCarte valeurBrelan = récupérerBrelan(cartes);
		if (valeurBrelan != null) {
			List<Carte> mainsSansBrelan = cartes.stream().filter(e -> !e.getValeurCarte().equals(valeurBrelan))
					.collect(Collectors.toList());
			List<ValeurCarte> paires = récupérerPaires(mainsSansBrelan);
			if (!paires.isEmpty()) {
				return valeurBrelan;
			}
		}
		return null;
	}

	private static List<ValeurCarte> récupérerCarré(List<Carte> cartes) {
		List<ValeurCarte> valeursDeLaMain = cartes.stream().map(Carte::getValeurCarte).collect(Collectors.toList());
		return Stream.of(ValeurCarte.values()).filter(value -> Collections.frequency(valeursDeLaMain, value) == 4)
				.collect(Collectors.toList());
	}

//	private List<ValeurCarte> récupérerPaires(Joueur joueur) {
//		Set<ValeurCarte> paires = cartes.stream().filter(this::carteEgale).map(Carte::getValeurCarte)
//				.collect(Collectors.toSet());
//		return paires.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//	}

	private static List<ValeurCarte> récupérerPaires(List<Carte> cartes) {
		List<ValeurCarte> valeursDeLaMain = cartes.stream().map(Carte::getValeurCarte).collect(Collectors.toList());
		return Stream.of(ValeurCarte.values()).filter(value -> Collections.frequency(valeursDeLaMain, value) == 2)
				.collect(Collectors.toList());
	}

	private static List<ValeurCarte> récupérerSuite(List<Carte> cartes) {
		List<Carte> copieDeMain = new ArrayList<>(cartes);
		if (estCarteAs(copieDeMain.get(0)))
			if (estCarteDeux(copieDeMain.get(copieDeMain.size() - 1)))
				déplacerAsEnPetitePosition(copieDeMain);

		for (int i = 1; i < copieDeMain.size(); i++) {
			if (!isSuite(copieDeMain.get(i), copieDeMain.get(i - 1))) {
				return null;
			}
		}
		cartes = copieDeMain;
		return List.of(cartes.get(0).getValeurCarte());
	}

	private static boolean estCarteDeux(Carte carte) {
		return ValeurCarte.DEUX.equals(carte.getValeurCarte());
	}

	private static boolean estCarteAs(Carte carte) {
		return ValeurCarte.AS.equals(carte.getValeurCarte());
	}

	private static void déplacerAsEnPetitePosition(List<Carte> copieDeMain) {
		copieDeMain.add(copieDeMain.size(), copieDeMain.get(0));
		copieDeMain.remove(0);
	}

	private static boolean isSuite(Carte carteBasse, Carte carteHaute) {
		if (estCarteAs(carteBasse)) {
			return estCarteDeux(carteHaute);
		}
		return carteBasse.getValeurCarte().getValeur() - carteHaute.getValeurCarte().getValeur() == -1;
	}

	public Function<List<Carte>, ValeurCarte> getRègleAAppliquer() {
		return règleAAppliquer;
	}
}
