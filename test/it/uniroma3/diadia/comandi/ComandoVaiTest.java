package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private static final String DIREZIONE_NULLA = null;
	private static final Direzioni DIREZIONE = Direzioni.nord;
	private static final Stanza NULLA = null;

	private ComandoVai comando;
	private Partita partita;
	private Stanza corrente,adiacente;
	private IOSimulator io;
	private Labirinto bilocale;
	private Labirinto labirintoDiaDia;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException{
		this.io = new IOSimulator();
		this.comando = new ComandoVai(io);
		
		CaricatoreLabirinto caricatoreDiaDia = new CaricatoreLabirinto("LabirintoDiaDia.txt");
		caricatoreDiaDia.carica();
		this.labirintoDiaDia = caricatoreDiaDia.getLabirinto();
		
		this.partita = new Partita(this.labirintoDiaDia);
		this.corrente = new Stanza("corrente");
		this.adiacente = new Stanza("adiacente");
		this.corrente.impostaStanzaAdiacente(DIREZIONE, this.adiacente);
		this.partita.setStanzaCorrente(this.corrente);
		
		CaricatoreLabirinto caricatoreBilocale = new CaricatoreLabirinto("LabirintoBilocale.txt");
		caricatoreBilocale.carica();
		this.bilocale = caricatoreBilocale.getLabirinto();
	}


	@Test
	public void testEsegui_NonAgisceSeLaStanzaDoveVoglioSpostarmiIsLaStanzaNulla() {
		this.corrente.impostaStanzaAdiacente(DIREZIONE, NULLA);
		this.comando.setParametro(DIREZIONE.toString());
		this.comando.esegui(this.partita);
		assertEquals("corrente", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testesegui_NonAgisceSeIlParametroImpostatoIsLaDirezioneNulla() {
		this.comando.setParametro(DIREZIONE_NULLA);
		this.comando.esegui(this.partita);
		assertEquals("corrente", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testEsegui_AgisceSeIlParametroImpostatoIsLaDirezioneNonNullaEStanzaNonNullaVediSetUp() {
		this.comando.setParametro(DIREZIONE.toString());
		this.comando.esegui(this.partita);
		assertEquals("adiacente", this.partita.getStanzaCorrente().getNome());
	}

	@Test 
	public void testEsegui_ValidoModificaICfuDelGiocatoreDellaPartita() {
		this.comando.setParametro(DIREZIONE.toString());
		this.comando.esegui(this.partita);
		assertEquals(19, this.partita.getGiocatore().getCfu());

	}
	
	@Test
	public void testEsegui_SuBilocale() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita=new Partita(bilocale);
		this.comando.setParametro("nord");
		this.comando.esegui(this.partita);
		assertEquals(this.partita.getStanzaCorrente().getNome(),"camera");
	}

}
