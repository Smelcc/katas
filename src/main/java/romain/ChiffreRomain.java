package romain;

public class ChiffreRomain {
	public static String convertirEnChiffreRomain(int nombreEntier) {
		StringBuilder result = new StringBuilder();
		for(EChiffreRomain eChiffreRomain : EChiffreRomain.recupererValeursDecroissantes()) {
			nombreEntier = gererCasParticuliers(nombreEntier, result);
			nombreEntier = concatenerChiffresRomainsAsNecessary(nombreEntier, result, eChiffreRomain);
		}
		return result.toString();
	}

	private static int gererCasParticuliers(int nombreEntier, StringBuilder result) {
		EChiffreRomainSpeciaux casParticulier = EChiffreRomainSpeciaux.of(nombreEntier);
		if (casParticulier != null) {
			result.append(casParticulier.getLibellé());
			nombreEntier -= casParticulier.getValeureEntière();
		}
		return nombreEntier;
	}

	private static int concatenerChiffresRomainsAsNecessary(int nombreEntier, StringBuilder result, EChiffreRomain chiffreRomain) {
		while (nombreEntier >= chiffreRomain.getValeureEntière()) {
			result.append(chiffreRomain.getLibellé());
			nombreEntier -= chiffreRomain.getValeureEntière();
		}
		return nombreEntier;
	}
}
