package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class DiaDiaTest {
	private DiaDia diaDiaTest;
	private IOSimulator simulatore;
	private ArrayList<String> comandi;
	private Labirinto labirintoDiaDia;
//	private Labirinto trilocale;
	private Labirinto bilocale;
//	private Labirinto monolocale;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.comandi = new ArrayList<String>();
		
		CaricatoreLabirinto caricatoreBilocale = new CaricatoreLabirinto("LabirintoBilocale.txt");
		caricatoreBilocale.carica();
		this.bilocale = caricatoreBilocale.getLabirinto();
		
		this.labirintoDiaDia = Labirinto.newBuilder().getLabirinto().LabirintoDiaDia();
	}

	@Test
	public void testVaiNordVittoria() throws Exception {
		this.comandi.add("vai nord");
		this.simulatore = new IOSimulator(comandi);
		this.diaDiaTest=new DiaDia(simulatore,bilocale);
		this.diaDiaTest.gioca();
		assertEquals("Hai vinto!",this.simulatore.getOutput().get(simulatore.getOutput().size()-1));
	}
	
	@Test
	public void testFinireCfuFiniscePartita() throws Exception {	
		for(int i=0; i<20; i++) {
			comandi.add("vai ovest");
		}
		this.simulatore = new IOSimulator(this.comandi);
		this.diaDiaTest=new DiaDia(simulatore,labirintoDiaDia);
		this.diaDiaTest.gioca();
		assertEquals("Hai finito i cfu\nGame Over",this.simulatore.getOutput().get(this.simulatore.getOutput().size()-1));
	}
	
	@Test
	public void testAttrezzoPresoEPosatoInBorsa() throws Exception {
		this.comandi.add("prendi osso");
		this.comandi.add("fine");
		this.simulatore = new IOSimulator(this.comandi);
		this.diaDiaTest=new DiaDia(simulatore, labirintoDiaDia);
		this.diaDiaTest.gioca();
		assertEquals(true,this.diaDiaTest.getPartita().getGiocatore().getBorsa().hasAttrezzo("osso"));
	}

}
