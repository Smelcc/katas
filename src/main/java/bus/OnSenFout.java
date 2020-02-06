package bus;

import java.util.ArrayList;
import java.util.List;

// TODO refacto Stream CGU a envie de le faire, ça va nous prendre 3/4 d'heures
public class OnSenFout {

	private static final int NOMBRE_ARRET_MAXIMUMMMMMMMMMMMM = 480;
	private static final int CHAUFFEUR_UN = 0;
	private static final int CHAUFFEUR_DEUX = 1;
	private static final int CHAUFFEUR_TROIS = 2;

	private List<String> routes = new ArrayList<>();

	public int getNombreIteration() {
		String route1 = routes.get(CHAUFFEUR_UN);
		String route2 = routes.get(CHAUFFEUR_DEUX);
		String route3 = null;
		if (routes.size() > 2)
			route3 = routes.get(CHAUFFEUR_TROIS);
		for (int arret = 0; arret < NOMBRE_ARRET_MAXIMUMMMMMMMMMMMM; arret++)
			if (trouverNomDeLArret(route1, arret) == trouverNomDeLArret(route2, arret)
					&& (route3 == null || trouverNomDeLArret(route1, arret) == trouverNomDeLArret(route3, arret)))
				return arret + 1;
		return 0;
	}

	private char trouverNomDeLArret(String route, int arret) {
		return route.charAt(calculerNumeroDeLArret(route, arret));
	}

	private int calculerNumeroDeLArret(String route, int arret) {
		return arret % route.length();
	}

	public void ajouterChauffeur(String route) {
		this.routes.add(route);
	}
}
