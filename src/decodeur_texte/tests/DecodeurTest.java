package decodeur_texte.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import decodeur_texte.Decodeur;
import decodeur_texte.ListeTrames;

public class DecodeurTest {
	private final String trame_path = "data/trames/trame_";
	
	@Test
	public void testFacile() {
		ListeTrames trames0 = testTaille("0", 19, 1);
		assertEquals(trames0.getOctet(0, 3), 118);
		ListeTrames trames1 = testTaille("1", 19, 2);
		assertEquals(trames1.getOctet(1, 1), 76);
	}
	
	@Test
	public void fichierVide() {
		testTaille("vide", 0, 0);
		testTaille("vide_avec_texte", 0, 0);
	}
	
	@Test
	public void testReel() {
		testTaille("reelle_1espace", 883, 10);
		testTaille("reelle", 883, 10);
	}
	
	@Test
	public void testAvances() {
		testTaille("2", 39, 1);
		testTaille("3", 7, 1);
		assertThrows("4");
		testTaille("5", 7, 3);
		assertThrows("6");
		assertThrows("7");
		testTaille("8", 2, 2);
	}
	
	private ListeTrames testTaille(String fileNumber, int expectedOctetSize, int expectedTramesSize) {
		Decodeur d = new Decodeur(trame_path + fileNumber + ".txt");
		ListeTrames trames = d.getTrames();
		System.out.println("Trame " + fileNumber + " : " + trames);
		assertEquals(expectedOctetSize, trames.getNbOctets());
		assertEquals(expectedTramesSize, trames.getTrames().size());
		return trames;
	}
	
	private void assertThrows(String fileNumber) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Decodeur(trame_path + fileNumber + ".txt"));
	}

}
