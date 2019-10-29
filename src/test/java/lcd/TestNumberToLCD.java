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
	
	@Test
	public void valeur11111() {
		List<String> resultat = NumberToLCD.convertirEnLCD(11111);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("               ",
						"  |  |  |  |  |", 
						"  |  |  |  |  |"));
	}
	
	/*@Test
	public void valeur2_avec_3largeur_2hauteur() {
		int largeur = 3;
		int hauteur = 2;
		int entrée = 2;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" ___ ", 
						"    |", 
						"    |", 
						" ___ ", 
						"|    ", 
						"|    ", 
						" ___ "));
	}
	
	@Test
	public void valeur1_avec_3largeur_2hauteur() {
		int largeur = 3;
		int hauteur = 2;
		int entrée = 1;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("     ", 
						"    |", 
						"    |", 
						"     ", 
						"    |", 
						"    |", 
						"     "));
	}*/
	
	@Test
	public void valeur1_avec_1largeur_1hauteur() {
		int largeur = 1;
		int hauteur = 1;
		int entrée = 1;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("   ", 
						"  |",  
						"  |"));
	}

	@Test
	public void valeur1_avec_1largeur_2hauteur() {
		int largeur = 1;
		int hauteur = 2;
		int entrée = 1;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("   ", 
						"  |",  
						"  |",
						"   ", 
						"  |",  
						"  |",
						"   "));
	}

	@Test
	public void valeur1_avec_1largeur_3hauteur() {
		int largeur = 1;
		int hauteur = 3;
		int entrée = 1;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("   ", 
						"  |",  
						"  |",  
						"  |",
						"   ", 
						"  |",  
						"  |",  
						"  |",
						"   "));
	}
	
	@Test
	public void valeur1_avec_1largeur_5hauteur() {
		int largeur = 1;
		int hauteur = 5;
		int entrée = 1;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("   ", 
						"  |",  
						"  |",  
						"  |",
						"  |",
						"  |",
						"   ", 
						"  |",
						"  |",
						"  |",  
						"  |",  
						"  |",
						"   "));
	}
	
	@Test
	public void valeur1_avec_1largeur_4hauteur() {
		int largeur = 1;
		int hauteur = 4;
		int entrée = 1;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("   ", 
						"  |",  
						"  |",  
						"  |",
						"  |",
						"   ", 
						"  |",  
						"  |",  
						"  |",  
						"  |",
						"   "));
	}
	@Test
	public void valeur2_avec_1largeur_2hauteur() {
		int largeur = 1;
		int hauteur = 2;
		int entrée = 2;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" _ ", 
						"  |",  
						"  |",
						" _ ", 
						"|  ",  
						"|  ",
						" _ "));
	}
	@Test
	public void valeur2_avec_1largeur_3hauteur() {
		int largeur = 1;
		int hauteur = 3;
		int entrée = 2;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" _ ", 
						"  |",  
						"  |",
						"  |",
						" _ ", 
						"|  ",  
						"|  ",
						"|  ",
						" _ "));
	}
	
	@Test
	public void valeur2_avec_1largeur_4hauteur() {
		int largeur = 1;
		int hauteur = 4;
		int entrée = 2;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" _ ", 
						"  |",  
						"  |",
						"  |",
						"  |",
						" _ ", 
						"|  ",  
						"|  ",
						"|  ",
						"|  ",
						" _ "));
	}

	@Test
	public void valeur3_avec_1largeur_4hauteur() {
		int largeur = 1;
		int hauteur = 4;
		int entrée = 3;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" _ ", 
						"  |",  
						"  |",
						"  |",
						"  |",
						" _ ", 
						"  |",  
						"  |",
						"  |",
						"  |",
						" _ "));
	}
	
	@Test
	public void valeur4_avec_1largeur_2hauteur() {
		int largeur = 1;
		int hauteur = 2;
		int entrée = 4;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of("   ", 
						"| |",  
						"| |",  
						" _ ", 
						"  |",
						"  |",
						"   "));
	}
	
	@Test
	public void valeur9_avec_1largeur_3hauteur() {
		int largeur = 1;
		int hauteur = 3;
		int entrée = 9;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" _ ", 
						"| |",  
						"| |",  
						"| |",  
						" _ ", 
						"  |",
						"  |",
						"  |",
						" _ "));
	}
	
	@Test
	public void valeur9_avec_2largeur_1hauteur() {
		int largeur = 2;
		int hauteur = 1;
		int entrée = 9;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" __ ", 
						"|__|",    
						" __|"));
	}
	
	@Test
	public void valeur8_avec_3largeur_1hauteur() {
		int largeur = 3;
		int hauteur = 1;
		int entrée = 8;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" ___ ", 
						"|___|",    
						"|___|"));
	}
	
	@Test
	public void valeur8_avec_5largeur_1hauteur() {
		int largeur = 5;
		int hauteur = 1;
		int entrée = 8;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" _____ ", 
						"|_____|",    
						"|_____|"));
	}
	
	@Test
	public void valeur8_avec_10largeur_1hauteur() {
		int largeur = 10;
		int hauteur = 1;
		int entrée = 8;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" __________ ", 
						"|__________|",    
						"|__________|"));
	}
	
	@Test
	public void valeur5_avec_6largeur_1hauteur() {
		int largeur = 6;
		int hauteur = 1;
		int entrée = 5;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" ______ ", 
						"|______ ",    
						" ______|"));
	}
	
	@Test
	public void valeur2_avec_2largeur_2hauteur() {
		int largeur = 2;
		int hauteur = 2;
		int entrée = 2;
		List<String> resultat = NumberToLCD.convertirEnLCD(entrée, hauteur, largeur);
		Assertions.assertThat(resultat).isEqualTo(
				List.of(" __ ", 
						"   |", 
						"   |", 
						" __ ",    
						"|   ",    
						"|   ",    
						" __ "));
	}
	
}
