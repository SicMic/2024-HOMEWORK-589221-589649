package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	@Test
	public void testGetStanzaAdiacente_PasspartoutAssente() {
		StanzaBloccata stanzaBloccata = new StanzaBloccata("stanza", "est");
		Stanza stanza = new Stanza("stanza1");
		stanzaBloccata.impostaStanzaAdiacente("est", stanza);
		
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testGetStanzaAdiacente_PasspartoutPresente() {
		StanzaBloccata stanzaBloccata = new StanzaBloccata("stanza", "est");
		Stanza stanza = new Stanza("stanza1");
		stanzaBloccata.impostaStanzaAdiacente("est", stanza);
		Attrezzo passpartout = new Attrezzo("passepartout", 1);
		stanzaBloccata.addAttrezzo(passpartout);
		
		assertEquals(stanza, stanzaBloccata.getStanzaAdiacente("est"));
	}

}
