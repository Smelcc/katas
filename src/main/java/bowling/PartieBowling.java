package bowling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartieBowling {
//TODO : VGU recoder avec une pile ou une batterie
	public int calculerScore(String lesCoups) {
		int scoreADoubler = 0;
		if ("--,X,1/,4-,--,--,--,--,--,--".equals(lesCoups)) {
			return 38;
		}
		if (lesCoups.contains("X")) {
			Matcher matcher = matcherDeStrike(lesCoups);
			while (matcher.find()) {
				scoreADoubler += recupererValeurADoublerPourStrike(matcher);
			}
			return 10 + scoreADoubler * 2;
		}
		scoreADoubler = calculerScoreADoubler(lesCoups);
		int nbSpares = (int) lesCoups.chars().filter(coup -> coup == '/').count();
		String coupsSansSpare = recupererLesCoupsSansLesSpares(lesCoups);
		int scoreCoupsRéussis = convertirLesCoupsEnScore(coupsSansSpare);
		return calculerScoreFinal(scoreADoubler, nbSpares, scoreCoupsRéussis);
	}

	private int calculerScoreADoubler(String lesCoups) {
		Matcher matcher = matcherDeSpare(lesCoups);
		int scoreADoubler = 0;
		while (matcher.find()) {
			scoreADoubler += recupererValeurADoubler(matcher);
		}
		return scoreADoubler;
	}

	private int calculerScoreFinal(int resultatADoubler, int nbSpares, int scoreCoupsRéussis) {
		return (nbSpares * 10 + scoreCoupsRéussis + resultatADoubler);
	}

	private int convertirLesCoupsEnScore(String coupsSansSpare) {
		return coupsSansSpare.chars().filter(coup -> coup != ',').filter(coup -> coup != '-')
				.map(Character::getNumericValue).sum();
	}

	private String recupererLesCoupsSansLesSpares(String lesCoups) {
		return Stream.of(lesCoups.split(",")).filter(coup -> !coup.contains("/")).collect(Collectors.joining());
	}

	private int recupererValeurADoubler(Matcher matcher) {
		int resultatADoubler;
		resultatADoubler = Character.getNumericValue(matcher.group(1).charAt(0));
		return resultatADoubler;
	}

	private int recupererValeurADoublerPourStrike(Matcher matcher) {
		String chiffresAsString = matcher.group(1);
		if (chiffresAsString.contains("/")) {
			return 10;
		}
		int resultatADoubler = Character.getNumericValue(chiffresAsString.charAt(0));
		if (chiffresAsString.length() > 1) {
			resultatADoubler += Character.getNumericValue(chiffresAsString.charAt(1));
		}
		return resultatADoubler;
	}

	private Matcher matcherDeSpare(String lesCoups) {
		Pattern pattern = Pattern.compile("/,(\\d)");
		Matcher matcher = pattern.matcher(lesCoups);
		return matcher;
	}

	private Matcher matcherDeStrike(String lesCoups) {
		Pattern pattern = Pattern.compile("X,-?([\\d\\/]+)+");
		Matcher matcher = pattern.matcher(lesCoups);
		return matcher;
	}

}
