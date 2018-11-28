package romain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TestChiffreRomainVersNombreArabe {

	@Test
	public void test_devrait_retourner_1_pour_I() {
		// given
		String chiffreRomain = "I";
		int resultatAttendu = 1;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_2_pour_II() {
		// given
		String chiffreRomain = "II";
		int resultatAttendu = 2;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_3_pour_III() {
		// given
		String chiffreRomain = "III";
		int resultatAttendu = 3;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_4_pour_IV() {
		// given
		String chiffreRomain = "IV";
		int resultatAttendu = 4;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_5_pour_V() {
		// given
		String chiffreRomain = "V";
		int resultatAttendu = 5;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_6_pour_VI() {
		// given
		String chiffreRomain = "VI";
		int resultatAttendu = 6;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_10_pour_X() {
		// given
		String chiffreRomain = "X";
		int resultatAttendu = 10;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_11_pour_XI() {
		// given
		String chiffreRomain = "XI";
		int resultatAttendu = 11;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_9_pour_IX() {
		// given
		String chiffreRomain = "IX";
		int resultatAttendu = 9;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}

	@Test
	public void test_devrait_retourner_41_pour_XLI() {
		// given
		String chiffreRomain = "XLI";
		int resultatAttendu = 41;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_2494_pour_MMCDXCIV() {
		// given
		String chiffreRomain = "MMCDXCIV";
		int resultatAttendu = 2494;
		// when
		int resultat = ChiffreRomain.convertirEnNombreArabe(chiffreRomain);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
}
