package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	@Test
	public void testComandoPosa_BorsaVuota() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		ComandoPosa posa = new ComandoPosa(console);
		posa.setParametro("attrezzo");
		posa.esegui(partita);
		
		assertNull(partita.getStanzaCorrente().getAttrezzo(posa.getParametro()));
	}
	
	@Test
	public void testComandoPosa_OggettoPresenteInBorsa() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		ComandoPosa posa = new ComandoPosa(console);
		Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setParametro("attrezzo");
		posa.esegui(partita);
		
		assertEquals(attrezzo, partita.getStanzaCorrente().getAttrezzo(posa.getParametro()));
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo(posa.getParametro()));
	}
	
	@Test
	public void testComandoPosa_OggettoAssenteInBorsa() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		ComandoPosa posa = new ComandoPosa(console);
		Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setParametro("attrezzo2");
		posa.esegui(partita);
		
		assertNull(partita.getStanzaCorrente().getAttrezzo(posa.getParametro()));
				
	}

}
