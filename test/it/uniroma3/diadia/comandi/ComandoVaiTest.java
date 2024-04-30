package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoVaiTest {

	// Test esegui -- INIZIO
	
	@Test
	public void testEsegui_DirezioneNull() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		ComandoVai vai = new ComandoVai(console);
		vai.setParametro(null);
		
		vai.esegui(partita);
		
		assertEquals(partita.getLabirinto().getStanzaIniziale(), partita.getStanzaCorrente());
	}
	
	@Test
	public void testEsegui_DirezioneNord() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		ComandoVai vai = new ComandoVai(console);
		vai.setParametro("nord");
		vai.esegui(partita);
		
		assertEquals(partita.getStanzaVincente(), partita.getStanzaCorrente());
	}
	
	@Test	
	public void testEsegui_DirezioneSud() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		ComandoVai vai = new ComandoVai(console);
		vai.setParametro("sud");
		vai.esegui(partita);
		
		assertEquals("Aula N10", partita.getStanzaCorrente().getNome());
	}
	

}
