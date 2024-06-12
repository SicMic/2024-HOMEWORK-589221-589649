package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;

public class AbstractComandoTest {
	private AbstractComando abstractComando;
	private IO io;
	
	@Before
	public void setuUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.io = new IOSimulator();
	}

	@Test
	public void testAbstractComando_inizializzazioneComandoAiuto() {
		this.abstractComando = new ComandoAiuto(this.io);
		assertEquals("ComandoAiuto",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test
	public void testAbstractComando_inizializzatoComandoFine() throws ClassNotFoundException, IOException {
		this.abstractComando = new ComandoFine(this.io);
		assertEquals("ComandoFine",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test 
	public void testAbstractComando_inizializzatoComandoGuarda() {
		this.abstractComando = new ComandoGuarda(this.io);
		assertEquals("ComandoGuarda",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test 
	public void testAbstractComanod_inizializzatoComandoNonValido() {
		this.abstractComando = new ComandoNonValido(this.io);
		assertEquals("ComandoNonValido",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test
	public void testAbstractComando_inizializzatoComandoInteragisci() {
		this.abstractComando = new ComandoInteragisci(this.io);
		assertEquals("ComandoInteragisci",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test
	public void testAbstractComando_inizializzatoComandoSaluta() {
		this.abstractComando = new ComandoSaluta(this.io);
		assertEquals("ComandoSaluta",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test 
	public void testAbstractComando_inizializzatoComandoVai() {
		this.abstractComando = new ComandoVai(this.io);
		assertEquals("ComandoVai",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test
	public void testAbstractComando_inizializzatoComandoPrendi() {
		this.abstractComando = new ComandoPrendi(this.io);
		assertEquals("ComandoPrendi",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test
	public void testAbstractComando_inizializzatoComandoPosa() {
		this.abstractComando = new ComandoPosa(this.io);
		assertEquals("ComandoPosa",this.abstractComando.getClass().getSimpleName());
	}
	
	@Test
	public void testAbstractComando_inizializzatoComandoRegala() {
		this.abstractComando = new ComandoRegala(this.io);
		assertEquals("ComandoRegala",this.abstractComando.getClass().getSimpleName());
	}
}
