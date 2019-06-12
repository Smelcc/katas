package gol;

public class Coordonnée implements Comparable<Coordonnée> {
	private int x;
	private int y;

	public Coordonnée(String coor) {
		x = Integer.valueOf(coor.split(",")[0]);
		y = Integer.valueOf(coor.split(",")[1]);
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
	public int compareTo(Coordonnée o) {
		return this.toString().compareTo(o.toString());
	}
}
