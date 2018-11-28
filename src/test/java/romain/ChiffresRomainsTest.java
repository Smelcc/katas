package romain;

import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

public class ChiffresRomainsTest {

	@Test
	public void test_devrait_retourner_I_pour_1() {
		// given
		int nombreEntier = 1;
		String resultatAttendu = "I";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_II_pour_2() {
		// given
		int nombreEntier = 2;
		String resultatAttendu = "II";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}

	@Test
	public void test_devrait_retourner_III_pour_3() {
		// given
		int nombreEntier = 3;
		String resultatAttendu = "III";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_IV_pour_4() {
		// given
		int nombreEntier = 4;
		String resultatAttendu = "IV";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_V_pour_5() {
		// given
		int nombreEntier = 5;
		String resultatAttendu = "V";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_VI_pour_6() {
		// given
		int nombreEntier = 6;
		String resultatAttendu = "VI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_VII_pour_7() {
		// given
		int nombreEntier = 7;
		String resultatAttendu = "VII";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_VIII_pour_8() {
		// given
		int nombreEntier = 8;
		String resultatAttendu = "VIII";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_IX_pour_9() {
		// given
		int nombreEntier = 9;
		String resultatAttendu = "IX";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_X_pour_10() {
		// given
		int nombreEntier = 10;
		String resultatAttendu = "X";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
		@Test
	public void test_devrait_retourner_XI_pour_11() {
		// given
		int nombreEntier = 11;
		String resultatAttendu = "XI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XIII_pour_13() {
		// given
		int nombreEntier = 13;
		String resultatAttendu = "XIII";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XVI_pour_16() {
		// given
		int nombreEntier = 16;
		String resultatAttendu = "XVI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XX_pour_20() {
		// given
		int nombreEntier = 20;
		String resultatAttendu = "XX";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XIX_pour_19() {
		// given
		int nombreEntier = 19;
		String resultatAttendu = "XIX";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XIX_pour_21() {
		// given
		int nombreEntier = 21;
		String resultatAttendu = "XXI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XXV_pour_25() {
		// given
		int nombreEntier = 25;
		String resultatAttendu = "XXV";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XXVI_pour_26() {
		// given
		int nombreEntier = 26;
		String resultatAttendu = "XXVI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XXIX_pour_29() {
		// given
		int nombreEntier = 29;
		String resultatAttendu = "XXIX";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XL_pour_40() {
		// given
		int nombreEntier = 40;
		String resultatAttendu = "XL";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	
	@Test
	public void test_devrait_retourner_L_pour_50() {
		// given
		int nombreEntier = 50;
		String resultatAttendu = "L";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}

	@Test
	public void test_devrait_retourner_XLIV_pour_44() {
		// given
		int nombreEntier = 44;
		String resultatAttendu = "XLIV";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_XLVI_pour_46() {
		// given
		int nombreEntier = 46;
		String resultatAttendu = "XLVI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_LI_pour_51() {
		// given
		int nombreEntier = 51;
		String resultatAttendu = "LI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_LIV_pour_54() {
		// given
		int nombreEntier = 54;
		String resultatAttendu = "LIV";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_LXIX_pour_69() {
		// given
		int nombreEntier = 69;
		String resultatAttendu = "LXIX";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_C_pour_100() {
		// given
		int nombreEntier = 100;
		String resultatAttendu = "C";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_IC_pour_90() {
		// given
		int nombreEntier = 90;
		String resultatAttendu = "XC";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_IC_pour_92() {
		// given
		int nombreEntier = 92;
		String resultatAttendu = "XCII";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_D_pour_500() {
		// given
		int nombreEntier = 500;
		String resultatAttendu = "D";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_M_pour_1000() {
		// given
		int nombreEntier = 1000;
		String resultatAttendu = "M";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}

	@Test
	public void test_devrait_retourner_CD_pour_400() {
		// given
		int nombreEntier = 400;
		String resultatAttendu = "CD";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_CDI_pour_401() {
		// given
		int nombreEntier = 401;
		String resultatAttendu = "CDI";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_CM_pour_900() {
		// given
		int nombreEntier = 900;
		String resultatAttendu = "CM";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_MCMXCIX_pour_1999() {
		// given
		int nombreEntier = 1999;
		String resultatAttendu = "MCMXCIX";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_MMCDXCIV_pour_2494() {
		// given
		int nombreEntier = 2494;
		String resultatAttendu = "MMCDXCIV";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}
	@Test
	public void test_devrait_retourner_MMM_pour_3000() {
		// given
		int nombreEntier = 3000;
		String resultatAttendu = "MMM";
		// when
		String resultat = ChiffreRomain.convertirEnChiffreRomain(nombreEntier);
		// then
		Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
	}

}
