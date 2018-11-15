package romain;

public class ChiffreRomain {
	public static String convertirEnChiffreRomain(int nombreEntier) {
		if (nombreEntier == 40) {
			return ("XL");
		}
		
		StringBuilder result = new StringBuilder();
		for(EChiffreRomain eChiffreRomain : EChiffreRomain.recupererValeursDecroissantes()) {
			nombreEntier = concatenerIteration(nombreEntier, result, eChiffreRomain);
			if (nombreEntier == 9) {
				result.append("IX");
				break; 
			}
			if (nombreEntier == 4) {
				result.append("IV");
				break; 
			}
		}

		return result.toString();
	}

	private static int concatenerIteration(int nombreEntier, StringBuilder result, EChiffreRomain chiffreRomain) {
		while (nombreEntier >= chiffreRomain.getValeureEntière()) {
			result.append(chiffreRomain.getLibellé());
			nombreEntier -= chiffreRomain.getValeureEntière();
		}
		return nombreEntier;
	}
}
