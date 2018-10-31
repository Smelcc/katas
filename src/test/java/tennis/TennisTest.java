package tennis;

import org.junit.Test;

import org.junit.Assert;

public class TennisTest {

	@Test
	public void doitRetourner_LoveLove_EnDebutDePartie() {
		TennisGame tennisGame = new TennisGame();
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Love - Love");
	}

	@Test
	public void doitRetourner_FifteenLove_quand_le_joueur_1_marque_1fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Fifteen - Love");
	}

	@Test
	public void doitRetourner_ThirtyLove_quand_le_joueur_1_marque_2fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(1);
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Thirty - Love");
	}

	@Test
	public void doitRetourner_FortyLove_quand_le_joueur_1_marque_3fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Forty - Love");
	}

	@Test
	public void doitRetourner_GameMauresmo_quand_Amelie_marque_4fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Game Mauresmo");
	}

	@Test
	public void doitRetourner_LoveFifteen_quand_le_joueur_2_marque_1fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Love - Fifteen");
	}

	@Test
	public void doitRetourner_LoveThirty_quand_le_joueur_2_marque_2fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Love - Thirty");
	}

	@Test
	public void doitRetourner_Fifteen_Fifteen_quand_les_deux_joueurs_marquent_1fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Fifteen - Fifteen");
	}

	@Test
	public void doitRetourner_GamePierce_quand_le_joueur_2_marque_4fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Game Pierce");
	}

	@Test
	public void doitRetourner_Deuce_quand_chaque_joueur_marque_3fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Deuce");
	}

	@Test
	public void doitRetourner_AdvantageMauresmo_quand_Mauresmo_marque_4fois_et_Pierce_3_fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Advantage Mauresmo");
	}

	@Test
	public void doitRetourner_Deuce_quand_Mauresmo_marque_4fois_et_Pierce_4_fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(2);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Deuce");
	}

	@Test
	public void doitRetourner_AdvantageMauresmo_quand_Mauresmo_marque_5fois_et_Pierce_4_fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(2);
		tennisGame.score(1);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Advantage Mauresmo");
	}

	@Test
	public void doitRetourner_Deuce_quand_Mauresmo_marque_5fois_et_Pierce_5_fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(2);
		tennisGame.score(1);
		tennisGame.score(2);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Deuce");
	}

	@Test
	public void doitRetourner_AdvantagePierce_quand_Mauresmo_marque_4fois_et_Pierce_5fois() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(2);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(1);
		tennisGame.score(2);
		tennisGame.score(2);
		String result = tennisGame.getScore();
		Assert.assertEquals(result, "Advantage Pierce");
	}

}
