package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {
	private Giocatore giocatore;
	private Attrezzo a;
	int cfuMax;

	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
		this.a = new Attrezzo("a",1);
		this.cfuMax=this.giocatore.getCfu();
	}
	
	/* Test costruttore */
	@Test
	public void testCostruttore_CfuInizializzatiCorrettamente() {
		assertEquals(20,this.giocatore.getCfu());
	}
	
	@Test
	public void testCostruttore_BorsaEffettivamenteBorsa() {
		assertEquals("Borsa",this.giocatore.getBorsa().getClass().getSimpleName());
	}
	
	@Test
	public void testCostruttore_BorsaModificabile() {
		this.giocatore.getBorsa().addAttrezzo(a);
		assertTrue(this.giocatore.getBorsa().hasAttrezzo("a"));
	}
	
	/* Test riduciCfu */
	@Test
	public void testRiduciCfu_SenzaArgomento() {
		this.giocatore.riduciCfu();
		assertEquals(this.cfuMax-1,this.giocatore.getCfu());
	}
	
	@Test
	public void testRiduciCfu_ConArgomentoInteroPositivo() {
		this.giocatore.riduciCfu(3);
		assertEquals(this.cfuMax-3,this.giocatore.getCfu());
	}
	
	@Test
	public void testRiduciCfu_ConArgomentoInteroNegativo() {
		this.giocatore.riduciCfu(-1);
		assertEquals(20,this.giocatore.getCfu());
	}
}
