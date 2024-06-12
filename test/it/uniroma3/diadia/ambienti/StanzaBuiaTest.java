package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzoCheFaLuce;
	private String nomeAttrezzoCheFaLuce;

	@Before
	public void setUp() {
		this.nomeAttrezzoCheFaLuce = new String("attrezzoCheFaLuce");
		this.stanzaBuia = new StanzaBuia("stanzaBuia",this.nomeAttrezzoCheFaLuce);
		this.attrezzoCheFaLuce = new Attrezzo(this.nomeAttrezzoCheFaLuce,0);
	}

	@Test
	public void testGetDescrizione_AttrezzoCheFaLuceNonPresente() {
		assertEquals("qui c'è un buio pesto",this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_AttrezzoCheFaLucePresente() {
		this.stanzaBuia.addAttrezzo(attrezzoCheFaLuce);
		assertEquals(this.stanzaBuia.toString(),this.stanzaBuia.getDescrizione());
	}

}
