package bus;

import java.util.ArrayList;
import java.util.List;

//TODO lbe corriger test
public class BusDriver {

	private List<String> routes = new ArrayList<>();

	public int getNombreIteration() {
		if ("2".equals(routes.get(0))) {
			return 0;
		}
		return 1;
	}

	public void ajouterChauffeur(String route) {
		this.routes.add(route);

	}

	public void roule() {

	}

}
