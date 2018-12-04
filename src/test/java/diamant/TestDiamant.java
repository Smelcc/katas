package diamant;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class TestDiamant {

	public void lancerTest(char input, List<String> resultatEscompté) {
		List<String> resultat = Diamant.générerDiamant(input);
		IntStream.range(0, resultat.size()).forEach(i -> System.out.println(resultat.get(i)));
		IntStream.range(0, resultatEscompté.size()).forEach(i -> {
			System.out.println(resultat.get(i));
			Assert.assertEquals(resultatEscompté.get(i), resultat.get(i));
		});
		System.out.println("____________________________________");
	}

	@Test
	public void useCaseA() {
		List<String> output = List.of("A");
		lancerTest('A', output);
	}

	@Test
	public void useCaseB() {
		List<String> output = List.of(" A ", "B B", " A ");
		lancerTest('B', output);
	}

	@Test
	public void useCaseC() {
		List<String> output = List.of("  A  ", " B B ", "C   C", " B B ", "  A  ");
		lancerTest('C', output);
	}

	@Test
	public void useCaseD() {
		List<String> output = List.of("   A   ", "  B B  ", " C   C ", "D     D", " C   C ", "  B B  ", "   A   ");
		lancerTest('D', output);
	}

	@Test
	public void useCaseE() {
		List<String> output = List.of("    A    ", "   B B   ", "  C   C  ", " D     D ", "E       E", " D     D ",
				"  C   C  ", "   B B   ", "    A    ");
		lancerTest('E', output);
	}
	
	@Test
	public void useCaseF() {
		List<String> output = List.of("     A     ", "    B B    ", "   C   C   ", "  D     D  ", " E       E ","F         F", " E       E ","  D     D  ",
				"   C   C   ", "    B B    ", "     A     ");
		lancerTest('F', output);
	}
}
