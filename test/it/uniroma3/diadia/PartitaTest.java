package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Labirinto;

public class PartitaTest {
	private Partita partita;
	private Labirinto trilocale;
	private Labirinto bilocale;
	private Labirinto monolocale;
	private Labirinto labirintoDiaDia;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto caricatoreTrilocale = new CaricatoreLabirinto("LabirintoTrilocale.txt");
		caricatoreTrilocale.carica();
		this.trilocale = caricatoreTrilocale.getLabirinto();
		
		CaricatoreLabirinto caricatoreBilocale = new CaricatoreLabirinto("LabirintoBilocale.txt");
		caricatoreBilocale.carica();
		this.bilocale = caricatoreBilocale.getLabirinto();
		
		CaricatoreLabirinto caricatoreMonolocale = new CaricatoreLabirinto("LabirintoMonolocale.txt");
		caricatoreMonolocale.carica();
		this.monolocale = caricatoreMonolocale.getLabirinto();
		
		this.labirintoDiaDia = Labirinto.newBuilder().getLabirinto().LabirintoDiaDia();
	}
	
	/* Test vinta */
	@Test
	public void testVinta_Vittoria() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.monolocale);
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testVinta_NonAncoraVinta() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.bilocale);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVinta_NonAncoraVintaDopoSpostamentoInStanzaNonVincente() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.trilocale);
		this.partita.setStanzaCorrente(this.partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.nord));
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVinta_VittoriaDopoSpostamentoInStanzaVincente() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.bilocale);
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	/* Test isFinita */
	@Test
	public void testIsFinita_ZeroCfu() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.labirintoDiaDia);
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinita_FinitaTrue() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.labirintoDiaDia);
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinita_Vinta() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.monolocale);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinita_NonAncoraFinita() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita(this.trilocale);
		assertFalse(this.partita.isFinita());
	}

}
