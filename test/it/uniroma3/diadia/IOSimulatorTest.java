package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

public class IOSimulatorTest {

	@Test
	public void testIOSimulator_Vittoria() {
		String comandi = "vai sud\nprendi lanterna\nvai nord\nvai nord\n";
		
		DiaDia diadia = new DiaDia();
		
		IOSimulator ioSimulator = new IOSimulator(comandi);
		
		diadia.gioca(ioSimulator);
		ioSimulator.leggiRiga();
		
		assertEquals("Aula N10", ioSimulator.getMessaggio(1));
		assertEquals("Attrezzo preso!", ioSimulator.getMessaggio(2));
		assertEquals("Atrio", ioSimulator.getMessaggio(3));
		assertEquals("Biblioteca", ioSimulator.getMessaggio(4));
		assertEquals("Hai vinto!" ,ioSimulator.getMessaggio(5));
	}

	
	@Test
	public void testIOSimulator_Fine() {
		String comandi = "vai sud\nprendi lanterna\nvai nord\nfine\n";
		
		DiaDia diadia = new DiaDia();
		
		IOSimulator ioSimulator = new IOSimulator(comandi);
		
		diadia.gioca(ioSimulator);
		ioSimulator.leggiRiga();
		
		assertEquals("Aula N10", ioSimulator.getMessaggio(1));
		assertEquals("Attrezzo preso!", ioSimulator.getMessaggio(2));
		assertEquals("Atrio", ioSimulator.getMessaggio(3));
		assertEquals("Grazie di aver giocato!" ,ioSimulator.getMessaggio(4));
	}
	
	@Test
	public void testIOSimulator_Partita() {
		String comandi = "vai est\nguarda\nvai sud\nfine\n";
		
		DiaDia diadia = new DiaDia();
		
		IOSimulator ioSimulator = new IOSimulator(comandi);
		
		diadia.gioca(ioSimulator);
		ioSimulator.leggiRiga();
		
		assertEquals("Aula N11", ioSimulator.getMessaggio(1));
		assertEquals("Aula N11\n"
				+ "Uscite:  est ovest nord\n"
				+ "Attrezzi nella stanza: ", ioSimulator.getMessaggio(2));
		
		assertEquals("Numero CFU : 19" ,ioSimulator.getMessaggio(3));
		assertEquals("Borsa vuota" ,ioSimulator.getMessaggio(4));
		assertEquals("Direzione inesistente", ioSimulator.getMessaggio(5));
		assertEquals("Grazie di aver giocato!", ioSimulator.getMessaggio(6));
	}


}
