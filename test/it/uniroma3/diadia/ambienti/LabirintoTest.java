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
	public void testGetStanzaIniziale_StanzaSbagliata() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza("stanza");
		
		assertNotEquals(stanza, labirinto.getStanzaIniziale());
	}
	
	// Test getStanzaIniziale -- FINE
	
	// Test getStanzaFinale -- INIZIO
	
	@Test
	public void testGetStanzaFinal_NotNull() {
		Labirinto labirinto = new Labirinto();
		
		assertNotNull(labirinto.getStanzaFinale());
	}
	
	@Test
	public void testGetStanzaFinale_StanzaSbagliata() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza("stanza");
		
		assertNotEquals(stanza, labirinto.getStanzaFinale());
	}
	
	//Test getStanzaFinale -- FINE
	

}
