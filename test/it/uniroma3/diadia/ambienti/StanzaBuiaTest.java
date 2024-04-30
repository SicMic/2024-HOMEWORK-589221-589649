package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	@Test
	public void testGetDescrizione_LanternaNonPresente() {
		StanzaBuia stanzaBuia = new StanzaBuia("stanza");
		
		assertEquals("in questa stanza c'è buio pesto", stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_LanternaPresente() {
		StanzaBuia stanzaBuia = new StanzaBuia("stanza");
		Attrezzo lanterna = new Attrezzo("lanterna", 1);
		stanzaBuia.addAttrezzo(lanterna);
		
		assertNotEquals("in questa stanza c'è buio pesto", stanzaBuia.getDescrizione());
	}

}
