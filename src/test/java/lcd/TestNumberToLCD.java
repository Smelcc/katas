package lcd;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TestNumberToLCD {
/*     _  _     _  _  _  _  _  
	 | _| _||_||_ |_   ||_||_|  
	 ||_  _|  | _||_|  ||_| _|  
	 */
	@Test
	public void valeur1() {
		List<String> resultat = NumberToLCD.convertirEnLCD(1);
		Assertions.assertThat(resultat).isEqualTo(List.of("   ",
														  "  |", 
												          "  |"));
	}
	
	@Test
	public void valeur2() {
		List<String> resultat = NumberToLCD.convertirEnLCD(2);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
														  " _|", 
												          "|_ "));
	}
	
	@Test
	public void valeur3() {
		List<String> resultat = NumberToLCD.convertirEnLCD(3);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
														  " _|", 
												          " _|"));
	}
	
	@Test
	public void valeur4() {
		List<String> resultat = NumberToLCD.convertirEnLCD(4);
		Assertions.assertThat(resultat).isEqualTo(List.of("   ",
														  "|_|", 
														  "  |"));
	}
	
	@Test
	public void valeur5() {
		List<String> resultat = NumberToLCD.convertirEnLCD(5);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
													 	  "|_ ", 
														  " _|"));
	}

	@Test
	public void valeur7() {
		List<String> resultat = NumberToLCD.convertirEnLCD(7);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
														  "  |", 
				 										  "  |"));
	}
	
	@Test
	public void valeur6() {
		List<String> resultat = NumberToLCD.convertirEnLCD(6);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
														  "|_ ", 
														  "|_|"));
	}
	
	@Test
	public void valeur8() {
		List<String> resultat = NumberToLCD.convertirEnLCD(8);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
														  "|_|", 
														  "|_|"));
	}
	
	@Test
	public void valeur9() {
		List<String> resultat = NumberToLCD.convertirEnLCD(9);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
														  "|_|", 
				 										  " _|"));
	}
	@Test
	public void valeur0() {
		List<String> resultat = NumberToLCD.convertirEnLCD(0);
		Assertions.assertThat(resultat).isEqualTo(List.of(" _ ",
														  "| |", 
														  "|_|"));
	}
	
	@Test
	public void valeur12() {
		List<String> resultat = NumberToLCD.convertirEnLCD(12);
		Assertions.assertThat(resultat).isEqualTo(List.of("    _ ",
														  "  | _|", 
														  "  ||_ "));
	}
	
	@Test
	public void valeur13() {
		List<String> resultat = NumberToLCD.convertirEnLCD(13);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("    _ ",
						"  | _|", 
						"  | _|"));
	}
	
	@Test
	public void valeur11() {
		List<String> resultat = NumberToLCD.convertirEnLCD(11);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("      ",
						"  |  |", 
						"  |  |"));
	}
	
	@Test
	public void valeur111() {
		List<String> resultat = NumberToLCD.convertirEnLCD(111);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("         ",
						"  |  |  |", 
						"  |  |  |"));
	}
	
	@Test
	public void valeur117() {
		List<String> resultat = NumberToLCD.convertirEnLCD(117);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("       _ ",
						"  |  |  |", 
						"  |  |  |"));
	}
}
