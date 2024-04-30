package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	@Test
	public void testComandoPrendi_StanzaVuota() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		Stanza stanza = new Stanza("stanza");
		partita.setStanzaCorrente(stanza);
		
		ComandoPrendi prendi = new ComandoPrendi(console);
		prendi.setParametro("attrezzo");
		prendi.esegui(partita);
		
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo(prendi.getParametro()));
	}
	
	@Test
	public void testComandoPrendi_OggettoPresenteInStanza() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
		stanza.addAttrezzo(attrezzo);
		partita.setStanzaCorrente(stanza);
		
		ComandoPrendi prendi = new ComandoPrendi(console);
		prendi.setParametro("attrezzo");
		prendi.esegui(partita);
		
		assertEquals(attrezzo, partita.getGiocatore().getBorsa().getAttrezzo(prendi.getParametro()));
		assertNull(partita.getStanzaCorrente().getAttrezzo(prendi.getParametro()));
	}
	
	@Test
	public void testComandoPrendi_OggettoAssenteInStanza() {
		Partita partita = new Partita();
		IO console = new IOConsole();
		
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
		stanza.addAttrezzo(attrezzo);
		partita.setStanzaCorrente(stanza);
		
		ComandoPrendi prendi = new ComandoPrendi(console);
		prendi.setParametro("attrezzo2");
		prendi.esegui(partita);
		
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo(prendi.getParametro()));
	}
}
