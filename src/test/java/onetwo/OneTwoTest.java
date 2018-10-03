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
}
