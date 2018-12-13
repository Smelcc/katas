package mastermind;

import static mastermind.Couleur.BLEU;
import static mastermind.Couleur.ROUGE;
import static mastermind.Couleur.VERT;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TestMasterMind {

	@Test
	public void tester_cas_RRRR_pourRRRR_retourne_4_0() {
		List<Couleur> couleursEntree = List.of(ROUGE, ROUGE, ROUGE, ROUGE);
		List<Couleur> combinaisonSecrete = List.of(ROUGE, ROUGE, ROUGE, ROUGE);
		List<Integer> resultatEscompte = List.of(4, 0);
		MasterMind.setCombinaisonSecrete(combinaisonSecrete);
		List<Integer> resultat = MasterMind.évaluer(couleursEntree);
		Assertions.assertThat(resultatEscompte).containsExactlyElementsOf(resultat);
	}
	
	@Test
	public void tester_cas_BBBB_pour_BBBB_retourne_4_0() {
		List<Couleur> couleursEntree = List.of(BLEU, BLEU, BLEU, BLEU);
		List<Couleur> combinaisonSecrete = List.of(BLEU, BLEU, BLEU, BLEU);
		List<Integer> resultatEscompte = List.of(4, 0);
		MasterMind.setCombinaisonSecrete(combinaisonSecrete);
		List<Integer> resultat = MasterMind.évaluer(couleursEntree);
		Assertions.assertThat(resultatEscompte).containsExactlyElementsOf(resultat);
	}
	
	@Test
	public void tester_cas_RRRR_pour_RRRB_retourne_3_0() {
		List<Couleur> couleursEntree = List.of(ROUGE, ROUGE, ROUGE, ROUGE);
		List<Couleur> combinaisonSecrete = List.of(ROUGE, ROUGE, ROUGE, BLEU);
		List<Integer> resultatEscompte = List.of(3, 0);
		MasterMind.setCombinaisonSecrete(combinaisonSecrete);
		List<Integer> resultat = MasterMind.évaluer(couleursEntree);
		Assertions.assertThat(resultatEscompte).containsExactlyElementsOf(resultat);
	}
	
	@Test
	public void tester_cas_RRRR_pour_RRBB_retourne_2_0() {
		List<Couleur> couleursEntree = List.of(ROUGE, ROUGE, ROUGE, ROUGE);
		List<Couleur> combinaisonSecrete = List.of(ROUGE, ROUGE, BLEU, BLEU);
		List<Integer> resultatEscompte = List.of(2, 0);
		MasterMind.setCombinaisonSecrete(combinaisonSecrete);
		List<Integer> resultat = MasterMind.évaluer(couleursEntree);
		Assertions.assertThat(resultatEscompte).containsExactlyElementsOf(resultat);
	}
	
	@Test
	public void tester_cas_VVVV_pour_RVVV_retourne_3_0() {
		List<Couleur> couleursEntree = List.of(VERT, VERT, VERT, VERT);
		List<Couleur> combinaisonSecrete = List.of(ROUGE, VERT, VERT, VERT);
		List<Integer> resultatEscompte = List.of(3, 0);
		MasterMind.setCombinaisonSecrete(combinaisonSecrete);
		List<Integer> resultat = MasterMind.évaluer(couleursEntree);
		Assertions.assertThat(resultatEscompte).containsExactlyElementsOf(resultat);
	}
	
	@Test
	public void tester_cas_VVVB_pour_BVVV_retourne_2_2() {
		List<Couleur> couleursEntree = List.of(VERT, VERT, VERT, BLEU);
		List<Couleur> combinaisonSecrete = List.of(BLEU, VERT, VERT, VERT);
		List<Integer> resultatEscompte = List.of(2, 2);
		MasterMind.setCombinaisonSecrete(combinaisonSecrete);
		List<Integer> resultat = MasterMind.évaluer(couleursEntree);
		Assertions.assertThat(resultatEscompte).containsExactlyElementsOf(resultat);
	}
	
	@Test
	public void tester_cas_VVVB_pour_BVVR_retourne_2_1() {
		List<Couleur> couleursEntree = List.of(VERT, VERT, VERT, BLEU);
		List<Couleur> combinaisonSecrete = List.of(BLEU, VERT, VERT, ROUGE);
		List<Integer> resultatEscompte = List.of(2, 1);
		MasterMind.setCombinaisonSecrete(combinaisonSecrete);
		List<Integer> resultat = MasterMind.évaluer(couleursEntree);
		Assertions.assertThat(resultatEscompte).containsExactlyElementsOf(resultat);
	}
}
