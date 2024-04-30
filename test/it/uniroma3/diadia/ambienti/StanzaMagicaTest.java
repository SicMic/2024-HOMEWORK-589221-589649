package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	// Test addAttrezzo -- INIZIO

	@Test
	public void testAddaAttrezzo_SogliaZero() {
		StanzaMagica stanza = new StanzaMagica("stanza", 0);
		Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
		
		stanza.addAttrezzo(attrezzo);
		
		assertEquals("ozzertta", stanza.getAttrezzo("ozzertta").getNome());
		assertEquals(4, stanza.getAttrezzo("ozzertta").getPeso());
	}
	
	@Test
	public void testAddaAttrezzo_SogliaUno() {
		StanzaMagica stanza = new StanzaMagica("stanza", 1);
		Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 2);
		
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo);
		
		assertEquals("ozzertta", stanza.getAttrezzo("ozzertta").getNome());
		assertEquals(4, stanza.getAttrezzo("ozzertta").getPeso());
	}
	
	@Test
	public void testAddaAttrezzo_SogliaTre() {
		StanzaMagica stanza = new StanzaMagica("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 1);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 1);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 1);
		
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo2);
		stanza.addAttrezzo(attrezzo3);
		stanza.addAttrezzo(attrezzo);
		
		assertEquals("ozzertta", stanza.getAttrezzo("ozzertta").getNome());
		assertEquals(4, stanza.getAttrezzo("ozzertta").getPeso());
	}
	
	// Test addAttrezzo -- FINE
	
}
