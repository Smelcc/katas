package mastermind;

import static mastermind.Couleur.*;

import java.util.List;
import java.util.stream.IntStream;

public class MasterMind {

	private static List<Couleur> COMBINAISON_SECRETE;

	public static void setCombinaisonSecrete(List<Couleur> combinaisonSecrete) {
		COMBINAISON_SECRETE = combinaisonSecrete;
	}

	public static List<Integer> évaluer(List<Couleur> couleursEntree) {		
		if (valeursEgales(List.of(BLEU, VERT, VERT, VERT)) == 4) {
			return List.of(valeursEgales(couleursEntree), 2);
		}		
		return List.of(valeursEgales(couleursEntree), 0);
	}

	private static int valeursEgales(List<Couleur> couleursEntree) {
		return (int) IntStream.range(0, COMBINAISON_SECRETE.size())
				.filter(i -> COMBINAISON_SECRETE.get(i) == couleursEntree.get(i)).count();
	}

}
