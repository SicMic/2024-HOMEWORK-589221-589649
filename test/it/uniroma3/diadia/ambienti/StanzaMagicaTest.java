package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	private StanzaMagica stanzaMagicaSoglia0;
	private StanzaMagica stanzaMagicaSogliaStandard;
	private String nomeAttrezzo;
	private String nomeAttrezzoInvertito;
	private Attrezzo attrezzo;
	private int pesoOriginale;
	private int pesoDoppio;

	@Before
	public void setUp() {
		this.nomeAttrezzo = new String("peso");
		this.nomeAttrezzoInvertito = new StringBuilder(this.nomeAttrezzo).reverse().toString();
		this.stanzaMagicaSoglia0 = new StanzaMagica("stanzaMagicaSoglia1",0);
		this.stanzaMagicaSogliaStandard = new StanzaMagica("stanzaMagicaSogliaStandard");
		this.attrezzo = new Attrezzo(this.nomeAttrezzo,1);
		this.pesoOriginale = this.attrezzo.getPeso();
		this.pesoDoppio = pesoOriginale*2;
	}
	
	@Test
	public void testAddAttrezzo_AttrezzoPosatoSogliaNonSuperataPesoENomeInalterati() {
		assertTrue(this.stanzaMagicaSogliaStandard.addAttrezzo(attrezzo));
		assertEquals(this.pesoOriginale,this.stanzaMagicaSogliaStandard.getAttrezzi().get(0).getPeso());
		assertEquals(this.nomeAttrezzo,this.stanzaMagicaSogliaStandard.getAttrezzi().get(0).getNome());
	}

	@Test
	public void testAddAttrezzoEModificaAttrezzo_AttrezzoPosatoConSogliaSuperataPesoDoppio() {
		assertTrue(this.stanzaMagicaSoglia0.addAttrezzo(attrezzo));
		assertEquals(this.pesoDoppio,this.stanzaMagicaSoglia0.getAttrezzi().get(0).getPeso());
	}
	
	@Test
	public void testAddAttrezzo_AttrezzoPosatoSogliaSuperataNomeInvertito() {
		assertTrue(this.stanzaMagicaSoglia0.addAttrezzo(attrezzo));
		assertEquals(this.nomeAttrezzoInvertito,this.stanzaMagicaSoglia0.getAttrezzi().get(0).getNome());
	}
	
	@Test
	public void  testAddAttrezzo_AttrezzoNull() {
		assertFalse(this.stanzaMagicaSogliaStandard.addAttrezzo(null));
	}

}
