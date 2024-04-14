package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

public class PartitaTest {
	
	// Test isFinita -- INIZIO

	@Test
	public void testIsFinita_Cmd() {
		Partita partitaFinitaCmd = new Partita();
		partitaFinitaCmd.setFinita();
		partitaFinitaCmd.getGiocatore().setCfu(5);
		assertTrue(partitaFinitaCmd.isFinita());
	}
	
	@Test
	public void testIsFinita_Vinta() {
		Partita partitaFinitaVinta = new Partita();
		partitaFinitaVinta.setStanzaCorrente(partitaFinitaVinta.getLabirinto().getStanzaFinale());
		partitaFinitaVinta.getGiocatore().setCfu(5);
	}
	
	@Test
	public void testIsFinita_Cfu() {
		Partita partitaFinitaCfu = new Partita();
		partitaFinitaCfu.getGiocatore().setCfu(0);
	}
	
	@Test
	public void testIsFinita_NonFinita() {
		Partita partitaNonFinita = new Partita();
		partitaNonFinita.getGiocatore().setCfu(5);
	}
	
	// Test isFinita -- FINE

}
