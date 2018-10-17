package onetwo;

import org.junit.Test;

import org.junit.Assert;

public class OneTwoTest {

	@Test
	public void test_devrait_retourner_one_one_quand_valeur_1() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "one one";
		String input = "1";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void test_devrait_retourner_one_two_quand_valeur_2() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "one two";
		String input = "2";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void test_devrait_retourner_one_three_quand_valeur_3() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "one three";
		String input = "3";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void test_devrait_retourner_one_nine_quand_valeur_9() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "one nine";
		String input = "9";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_one_one_one_two_quand_valeur_1_2() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "one one one two";
		String input = "1 2";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_one_one_one_three_quand_valeur_1_3() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "one one one three";
		String input = "1 3";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_two_one_quand_valeur_1_1() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "two one";
		String input = "1 1";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_two_two_quand_valeur_2_2() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "two two";
		String input = "2 2";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_two_three_quand_valeur_3_3() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "two three";
		String input = "3 3";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_three_three_quand_valeur_3_3_3() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "three three";
		String input = "3 3 3";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_four_three_quand_valeur_3_3_3_3() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "four three";
		String input = "3 3 3 3";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_nine_five_one_five_quand_valeur_5_5_5_5_5_5_5_5_5_5() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "nine five one five";
		String input = "5 5 5 5 5 5 5 5 5 5";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_nine_five_two_five_quand_valeur_5_5_5_5_5_5_5_5_5_5_5() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "nine five two five";
		String input = "5 5 5 5 5 5 5 5 5 5 5";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_nine_six_two_six_quand_valeur_6_6_6_6_6_6_6_6_6_6_6() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "nine six two six";
		String input = "6 6 6 6 6 6 6 6 6 6 6";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_nine_six_nine_six_two_six_quand_valeur_20x6() {
		// given
		OneTwo onetwo = new OneTwo();
		String expected = "nine six nine six two six";
		String input = "6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6";
		// when
		String result = onetwo.readValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_1_quand_valeur_one_one() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "one one";
		String expected = "1";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_2_quand_valeur_one_two() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "one two";
		String expected = "2";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_3_quand_valeur_one_three() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "one three";
		String expected = "3";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_3_3_quand_valeur_two_three() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "two three";
		String expected = "3 3";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_4_4_quand_valeur_two_four() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "two four";
		String expected = "4 4";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_1_1_1_quand_valeur_three_one() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "three one";
		String expected = "1 1 1";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_1_2_quand_valeur_one_one_one_two() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "one one one two";
		String expected = "1 2";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void test_devrait_retourner_1_3_quand_valeur_one_one_one_three() {
		// given
		OneTwo onetwo = new OneTwo();
		String input = "one one one three";
		String expected = "1 3";
		// when
		String result = onetwo.writeValue(input);
		// then
		Assert.assertEquals(expected, result);
	}
}
