package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtectedTest {
	private StanzaMagicaProtected stanzaMagicaProtectedSoglia0;
	private StanzaMagicaProtected stanzaMagicaProtectedSogliaStandard;
	private Attrezzo peso1;
	private int pesoOriginale;
	private int pesoDoppio;

	@Before
	public void setUp() {
		this.stanzaMagicaProtectedSoglia0 = new StanzaMagicaProtected("stanzaMagicaSoglia1",0);
		this.stanzaMagicaProtectedSogliaStandard = new StanzaMagicaProtected("stanzaMagicaSogliaStandard");
		this.peso1 = new Attrezzo("peso1",1);
		this.pesoOriginale = this.peso1.getPeso();
		this.pesoDoppio = pesoOriginale*2;
	}
	
	@Test
	public void testAddAttrezzo_AttrezzoPosatoSogliaNonSuperata() {
		assertTrue(this.stanzaMagicaProtectedSogliaStandard.addAttrezzo(peso1));
		assertEquals(this.pesoOriginale,this.stanzaMagicaProtectedSogliaStandard.getAttrezzi().get(0).getPeso());
	}

	@Test
	public void testAddAttrezzoEModificaAttrezzo_AttrezzoPosatoConSogliaSuperataPesoDoppio() {
		assertTrue(this.stanzaMagicaProtectedSoglia0.addAttrezzo(peso1));
		assertEquals(this.pesoDoppio,this.stanzaMagicaProtectedSoglia0.getAttrezzi().get(0).getPeso());
	}
	
	@Test
	public void  testAddAttrezzo_AttrezzoNull() {
		assertFalse(this.stanzaMagicaProtectedSogliaStandard.addAttrezzo(null));
	}

}
