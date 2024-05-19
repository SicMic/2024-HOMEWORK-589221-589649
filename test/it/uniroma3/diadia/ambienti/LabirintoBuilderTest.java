package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoBuilderTest {

	@Test
	public void testLabirintoBuilder_UnaStanza() {
		
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("salotto")
				.getLabirinto();
		
		assertEquals("salotto", labirinto.getStanzaIniziale().getNome());
		assertEquals("salotto", labirinto.getStanzaFinale().getNome());
	}
	
	@Test
	public void testLabirintoBuilder_DueStanze() {
		
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.getLabirinto();
		
		assertEquals("salotto", labirinto.getStanzaIniziale().getNome());
		assertEquals("camera", labirinto.getStanzaFinale().getNome());
	}

	@Test
	public void testLabirintoBuilder_DueStanzeAttrezzo() {
		
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("matita", 3)
				.getLabirinto();
		
		assertEquals("salotto", labirinto.getStanzaIniziale().getNome());
		assertEquals("camera", labirinto.getStanzaFinale().getNome());
		assertTrue(labirinto.getStanzaFinale().hasAttrezzo("matita"));
	}
}
