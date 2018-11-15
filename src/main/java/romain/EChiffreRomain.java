package romain;

import java.util.Arrays;
import java.util.List;

public enum EChiffreRomain {
	I(1, 'I')
	, V(5, 'V')
	, X(10, 'X')
	, L(50, 'L')
	;

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
		return Arrays.asList(L,X,V,I);
	}
}
