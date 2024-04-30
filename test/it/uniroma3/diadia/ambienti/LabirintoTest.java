package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {

	// Test getStanzaIniziale -- INIZIO
	
	@Test
	public void testGetStanzaIniziale_NotNull() {
		Labirinto labirinto = new Labirinto();
		
		assertNotNull(labirinto.getStanzaIniziale());
	}
	
	@Test
	public void testGetStanzaIniziale_NomeSbagliato() {
		Labirinto labirinto = new Labirinto();
		
		assertNotEquals("Biblioteca", labirinto.getStanzaIniziale());
	}
	
	@Test
	public void testGetStanzaIniziale_NomeCorretto() {
		Labirinto labirinto = new Labirinto();
		
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}
	
	// Test getStanzaIniziale -- FINE
	
	// Test getStanzaFinale -- INIZIO
	
	@Test
	public void testGetStanzaFinal_NotNull() {
		Labirinto labirinto = new Labirinto();
		
		assertNotNull(labirinto.getStanzaFinale());
	}
	
	@Test
	public void testGetStanzaFinale_NomeSbagliato() {
		Labirinto labirinto = new Labirinto();
		
		assertNotEquals("Atrio", labirinto.getStanzaFinale());
	}
	
	@Test
	public void testGetStanzaFinale_NomeCorretto() {
		Labirinto labirinto = new Labirinto();
		
		assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
	}
	
	//Test getStanzaFinale -- FINE

}
