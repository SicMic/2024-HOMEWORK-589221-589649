package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
	
	// Test getCfu -- INIZIO
	
		@Test
		public void testGetCfu_CfuPositivi() {
			Giocatore giocatore = new Giocatore();
			giocatore.setCfu(10);
			assertEquals(10, giocatore.getCfu());
		}
		
		@Test
		public void testGetCfu_CfuZero() {
			Giocatore giocatore = new Giocatore();
			giocatore.setCfu(0);
			assertEquals(0, giocatore.getCfu());
		}
		
		@Test
		public void testGetCfu_CfuNegativi() {
			Giocatore giocatore = new Giocatore();
			giocatore.setCfu(-12);
			assertEquals(-12, giocatore.getCfu());
		}
		
		// Test grtCfu -- FINE
}
