package romain;

import java.util.stream.Stream;

public enum EChiffreRomainSpeciaux {
	IV(4, "IV", 5)
	, IX(9, "IX", 10)
	, XL(40, "XL", 50)
	, XC(90, "XC", 100)
	, CD(400, "CD", 500)
	, CM(900, "CM", 1000)
	;

	private int valeureEntière;
	private int borneSchließtAus;
	private String libellé;

	EChiffreRomainSpeciaux(int valeureEntière, String libellé, int borneSchließtAus) {
		this.valeureEntière = valeureEntière;
		this.libellé = libellé;
		this.borneSchließtAus = borneSchließtAus;
	}
	public int getValeureEntière() {
		return valeureEntière;
	}

	public String getLibellé() {
		return libellé;
	}

	public static EChiffreRomainSpeciaux of(int nombreEntier) {
		return   Stream.of(EChiffreRomainSpeciaux.values())
				.filter(chiffre -> isInclusDansLaChettefour(nombreEntier, chiffre))
				.findFirst()
				.orElse(null);
	}
	private static boolean isInclusDansLaChettefour(int nombreEntier, EChiffreRomainSpeciaux chiffre) {
		return chiffre.valeureEntière <= nombreEntier
							&& chiffre.borneSchließtAus > nombreEntier;
	}
	public static EChiffreRomainSpeciaux récupérerChiffreDepuisLibellé(String chiffreRomainSousReprésentationChaînée) {
		return Stream.of(EChiffreRomainSpeciaux.values()).filter(énuméré -> chiffreRomainSousReprésentationChaînée.equals(énuméré.getLibellé()))
		.findFirst().orElse(null);
	}
}
