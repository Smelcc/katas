package gol;

public class Cellule implements Comparable<Cellule> {
	private int x;
	private int y;

	public Cellule(String coor) {
		x = Integer.valueOf(coor.split(",")[0]);
		y = Integer.valueOf(coor.split(",")[1]);
	}
	
	public Cellule(int abscisse, int ordonnee) {
		x = abscisse;
		y = ordonnee;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public int compareTo(Cellule o) {
		return this.toString().compareTo(o.toString());
	}
}
