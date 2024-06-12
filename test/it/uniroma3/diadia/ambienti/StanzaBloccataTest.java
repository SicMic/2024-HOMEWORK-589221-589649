package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaDirezioneBloccata;
	private Stanza stanzaDirezioneNonBloccata;
	private Attrezzo attrezzoSbloccante;
	private Direzioni direzioneBloccata;
	private Direzioni direzioneNonBloccata;

	@Before
	public void setUp() {
		this.direzioneBloccata = Direzioni.sud;
		this.direzioneNonBloccata = Direzioni.nord;
		this.stanzaBloccata = new StanzaBloccata("stanzaBloccata", this.direzioneBloccata, "attrezzoSbloccante");
		this.stanzaDirezioneBloccata = new Stanza("stanzaDirezioneBloccata");
		this.stanzaDirezioneNonBloccata = new Stanza("stanzaDirezioneNonBloccata");
		this.attrezzoSbloccante = new Attrezzo("attrezzoSbloccante",0);
		this.stanzaBloccata.impostaStanzaAdiacente(this.direzioneBloccata, this.stanzaDirezioneBloccata);
		this.stanzaBloccata.impostaStanzaAdiacente(this.direzioneNonBloccata, stanzaDirezioneNonBloccata);
	}

	@Test
	public void testGetStanzaAdiacente_DirezioneBloccataAttrezzoSbloccanteNonPresente() {
		assertEquals(this.stanzaBloccata,this.stanzaBloccata.getStanzaAdiacente(this.direzioneBloccata));
	}
	
	@Test
	public void testGetStanzaAdiacente_DirezioneBloccataAttrezzoSbloccantePresente() {
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(this.stanzaDirezioneBloccata,this.stanzaBloccata.getStanzaAdiacente(this.direzioneBloccata));
	}
	
	@Test
	public void testGetStanzaAdiacente_DirezioneNonBloccata() {
		assertEquals(this.stanzaDirezioneNonBloccata,this.stanzaBloccata.getStanzaAdiacente(this.direzioneNonBloccata));
	}

}
