package romain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EChiffreRomain {
	I(1, 'I')
	, V(5, 'V')
	, X(10, 'X')
	, L(50, 'L')
	, C(100, 'C')
	, D(500, 'D')
	, M(1000, 'M')
	;

	private final static Comparator<EChiffreRomain> comparateurDecroissant = new Comparator<EChiffreRomain>() {
		@Override
		public int compare(EChiffreRomain o1, EChiffreRomain o2) {
			return o2.valeureEntière - o1.valeureEntière;
		}
	};
	private int valeureEntière;
	private char libellé;

	EChiffreRomain(int valeureEntière, char libellé) {
		this.valeureEntière = valeureEntière;
		this.libellé = libellé;
	}

	public int getValeureEntière() {
		return valeureEntière;
	}

	public char getLibellé() {
		return libellé;
	}

	public static List<EChiffreRomain> recupererValeursDecroissantes() {
		return Stream.of(EChiffreRomain.values()).sorted(comparateurDecroissant).collect(Collectors.toList());
	}

	public static EChiffreRomain récupérerChiffreDepuisLibellé(String chiffreRomain) {
		return Stream.of(EChiffreRomain.values()).filter(énuméré -> chiffreRomain.equals(énuméré.getLibellé() + ""))
		.findFirst().orElse(null);
	}
}
