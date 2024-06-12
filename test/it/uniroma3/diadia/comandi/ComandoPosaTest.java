package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Before;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	private ComandoPosa comando;
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzoInBorsa;
	private IOSimulator io;
	private Labirinto monolocale;
	private Labirinto labirintoDiaDia;


	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException{
		this.io = new IOSimulator();
		this.comando = new ComandoPosa(io);
		
		CaricatoreLabirinto caricatoreDiaDia = new CaricatoreLabirinto("LabirintoDiaDia.txt");
		caricatoreDiaDia.carica();
		this.labirintoDiaDia = caricatoreDiaDia.getLabirinto();
		
		this.partita = new Partita(this.labirintoDiaDia);
		this.stanza = new Stanza("stanza");
		this.partita.setStanzaCorrente(stanza);
		this.attrezzoInBorsa = new Attrezzo("attrezzo", 1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoInBorsa);
		
		CaricatoreLabirinto caricatoreMonolocale = new CaricatoreLabirinto("LabirintoMonolocale.txt");
		caricatoreMonolocale.carica();
		this.monolocale = caricatoreMonolocale.getLabirinto();
	}

	@Test
	public void testEsegui_NonAgisceSeIlNomeDellAttrezzoIsLaStringaNulla() {
		this.comando.setParametro(null);
		this.comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}

	@Test
	public void testEsegui_SuAttrezzoNonInBorsaNonAgisce() {
		this.comando.setParametro("nonInBorsa");
		this.comando.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("nonInBorsa"));
	}

	@Test
	public void testEsegui_SuAttrezzoInBorsaAggiungeLAttrezzoAllaStanza() {
		this.comando.setParametro("attrezzo");
		this.comando.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("attrezzo"));	
	}

	@Test
	public void testEsegui_SuAttrezzoInBorsaLoRimuove() {
		this.comando.setParametro("attrezzo");
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}
	
	@Test
	public void testEsegui_SuMonolocale() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita=new Partita(monolocale);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoInBorsa);
		this.comando.setParametro("attrezzo");
		this.comando.esegui(this.partita);
		assertEquals(true,this.partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

}
