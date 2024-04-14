package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest{
	
	// Test getAttrezzo -- INIZIO

	@Test
	public void testGetAttrezzo_stanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente")); 
	}
	
	@Test
	public void testGetAttrezzo_stanzaNonVuota_Presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzo_stanzaNonVuota_Assente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("nomeDiAtrezzoNonPresente"));
	}
	
	// Test getAttrezzo -- FINE
	
	// Test impostaStanzaAdiacente -- INIZIO
	
	@Test
	public void testImpostaStanzaAdiacente_NoStanzeAdiacenti() {
		Stanza stanza = new Stanza("N11");
		Stanza stanza1 = new Stanza("N12");
		stanza.impostaStanzaAdiacente("est", stanza1);	
		assertEquals(stanza1, stanza.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_Aggiornamento() {
		Stanza stanza = new Stanza("N11");
		Stanza stanza1 = new Stanza("N12");
		Stanza stanza2 = new Stanza("N13");
		
		stanza.impostaStanzaAdiacente("nord", stanza1);
		stanza.impostaStanzaAdiacente("nord", stanza2);
		
		assertEquals(stanza2, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_Massimo() {
		Stanza stanza = new Stanza("N11");
		Stanza stanza1 = new Stanza("N12");
		Stanza stanza2 = new Stanza("N13");
		Stanza stanza3 = new Stanza("N14");
		Stanza stanza4 = new Stanza("N15");
		Stanza stanza5 = new Stanza("N16");
		
		stanza.impostaStanzaAdiacente("nord", stanza1);
		stanza.impostaStanzaAdiacente("sud", stanza2);
		stanza.impostaStanzaAdiacente("est", stanza3);
		stanza.impostaStanzaAdiacente("ovest", stanza4);
		
		stanza.impostaStanzaAdiacente("pippo", stanza5);
		
		assertEquals(stanza1, stanza.getStanzaAdiacente("nord"));
		assertEquals(stanza2, stanza.getStanzaAdiacente("sud"));
		assertEquals(stanza3, stanza.getStanzaAdiacente("est"));
		assertEquals(stanza4, stanza.getStanzaAdiacente("ovest"));
	}
	
	// Test ImpostaStanzaAdiacente -- FINE
	
	// Test GetStanzaAdiacente -- INIZIO
	
	@Test
	public void testGetStanzaAdiacente_NoStanzeAdiacenti() {
		Stanza stanza = new Stanza("N11");
		
		assertNull(stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_StanzaAdiacente() {
		Stanza stanza = new Stanza("N11");
		Stanza stanza1 = new Stanza("N12");
		
		stanza.impostaStanzaAdiacente("nord", stanza1);
		
		assertEquals(stanza1, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_Direzione() {
		Stanza stanza = new Stanza("N11");
		Stanza stanza1 = new Stanza("N12");

		stanza.impostaStanzaAdiacente("nord", stanza1);
		assertNull(stanza.getStanzaAdiacente("sud"));
	}
	
	// Test GetStanzaAdiacente -- FINE
	
	// Test AddAttrezzo -- INIZIO
	
	@Test
	public void testAddAttrezzo_StanzaVuota() {
		Stanza stanza = new Stanza("N11");
		Attrezzo attrezzo = new Attrezzo("crimpatrice", 1);
		
		assertTrue(stanza.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAddAttrezzo_StanzaPiena() {
		Stanza stanza = new Stanza("N11");
		int i=0;
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		while(stanza.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);	
		}
		
		Attrezzo attrezzoExtra = new Attrezzo("nonInseribile", 1);
		
		assertFalse(stanza.addAttrezzo(attrezzoExtra));
	}
	
	@Test
	public void testAddAttrezzo_StanzaNoPienaNoVuota() {
		Stanza stanza = new Stanza("N11");
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 1);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 2);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 3);
		
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo2);
		
		assertTrue(stanza.addAttrezzo(attrezzo3));
	}
	
	// Test AddAttrezzo -- FINE
	
	// Test HasAttrezzo -- INIZIO
	
	@Test
	public void testHasAttrezzo_StanzaVuota() {
		Stanza stanza = new Stanza("N11");
		assertFalse(stanza.hasAttrezzo("cacciavite"));
	}
	
	@Test
	public void testHasAttrezzo_AttrezzoAssente() {
		Stanza stanza = new Stanza("N11");
		
		int i=0;
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		while(stanza.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);	
		}
		
		assertFalse(stanza.hasAttrezzo("cacciavite"));
	}
	
	@Test
	public void testHasAttrezzo_AttrezzoPresente() {
		Stanza stanza = new Stanza("N11");
		
		int i=0;
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		while(stanza.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);	
		}
		
		assertTrue(stanza.hasAttrezzo("attrezzo9"));
	}
	
	// Test HasAttrezzo -- FINE 
	
	// Test removeAttrezzo -- INIZIO
	
	@Test 
	public void testRemoveAttrezzo_StanzaVuota() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
		
		assertFalse(stanza.removeAttrezzo(attrezzo));
	}
	
	@Test
	public void testRemoveAttrezzo_ElementoPresente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 1);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 1);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 1);
		
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo2);
		stanza.addAttrezzo(attrezzo3);
		
		assertTrue(stanza.removeAttrezzo(attrezzo3));
	}
	
	@Test
	public void testRemoveAttrezzo_ElementoAssente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 1);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 1);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 1);
		
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo2);
		
		assertFalse(stanza.removeAttrezzo(attrezzo3));
	}
	
	// Test removeAttrezzo -- FINE

}
