package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Before;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private ComandoPrendi comando;
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private IOSimulator io;
	private Labirinto trilocale;
	private Labirinto labirintoDiaDia;


	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException{
		this.io = new IOSimulator();
		this.comando = new ComandoPrendi(io);
		
		CaricatoreLabirinto caricatoreDiaDia = new CaricatoreLabirinto("LabirintoDiaDia.txt");
		caricatoreDiaDia.carica();
		this.labirintoDiaDia = caricatoreDiaDia.getLabirinto();
		
		this.partita = new Partita(this.labirintoDiaDia);
		this.stanza = new Stanza("stanza");
		this.partita.setStanzaCorrente(stanza);
		this.attrezzo = new Attrezzo("attrezzo", 1);
		stanza.addAttrezzo(attrezzo);
		
		CaricatoreLabirinto caricatoreTrilocale = new CaricatoreLabirinto("LabirintoTrilocale.txt");
		caricatoreTrilocale.carica();
		this.trilocale = caricatoreTrilocale.getLabirinto();
	}

	@Test
	public void testEsegui_NonAgisceSeIlNomeDellAttrezzoIsLaStringaNulla() {
		this.comando.setParametro(null);
		this.comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty());
	}

	@Test
	public void testEsegui_SuAttrezzoNonInStanzaNonAgisce() {
		this.comando.setParametro("nonInStanza");
		this.comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty());
	}

	@Test
	public void testEsegui_SuAttrezzoInStanzaAggiungeLAttrezzoAllaBorsa() {
		this.comando.setParametro("attrezzo");
		this.comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));	
	}

	@Test
	public void testEsegui_SuAttrezzoInStanzaRimuoveLAttrezzoDallaStanza() {
		this.comando.setParametro("attrezzo");
		this.comando.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	public void testEsegui_SuTrilocale() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita=new Partita(this.trilocale);
		this.partita.setStanzaCorrente(this.partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.nord));
		this.comando.setParametro("pentola");
		this.comando.esegui(this.partita);
		assertEquals(true,this.partita.getGiocatore().getBorsa().hasAttrezzo("pentola"));	
	}


}
