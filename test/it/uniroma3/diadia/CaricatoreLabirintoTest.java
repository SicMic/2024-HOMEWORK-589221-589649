package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Labirinto;

public class CaricatoreLabirintoTest {
	private Labirinto monolocale;
	private Labirinto bilocale;
	private Labirinto trilocale;

	@Before
	public void setUp() throws Exception {
		CaricatoreLabirinto caricatoreTrilocale = new CaricatoreLabirinto("LabirintoTrilocale.txt");
		caricatoreTrilocale.carica();
		this.trilocale = caricatoreTrilocale.getLabirinto();
		
		CaricatoreLabirinto caricatoreBilocale = new CaricatoreLabirinto("LabirintoBilocale.txt");
		caricatoreBilocale.carica();
		this.bilocale = caricatoreBilocale.getLabirinto();
		
		CaricatoreLabirinto caricatoreMonolocale = new CaricatoreLabirinto("LabirintoMonolocale.txt");
		caricatoreMonolocale.carica();
		this.monolocale = caricatoreMonolocale.getLabirinto();
	}

	@Test
	public void testCaricatore_MonolocaleStanzaCorrenteEVincenteCoincidono() throws FileNotFoundException, FormatoFileNonValidoException {
		assertEquals("salotto",this.monolocale.getStanzaIniziale().getNome());
		assertEquals("salotto",this.monolocale.getStanzaVincente().getNome());
	}

	@Test
	public void testCaricatore_BilocaleLettoInCamera() throws FileNotFoundException, FormatoFileNonValidoException {
		assertEquals("letto",this.bilocale.getStanzaVincente().getAttrezzi().get(0).getNome());
	}

	@Test
	public void testCaricatore_BilocaleCaneInSalotto() throws FileNotFoundException, FormatoFileNonValidoException {
		assertEquals("Rex",this.bilocale.getStanzaIniziale().getPersonaggio().getNome());
	}

	@Test
	public void testCaricatore_TrilocaleMagoInSalottoEStregaInCucina() throws FileNotFoundException, FormatoFileNonValidoException {
		assertEquals("Merlino",this.trilocale.getStanzaIniziale().getPersonaggio().getNome());
		assertEquals("Strega",this.trilocale.getStanzaIniziale().getStanzaAdiacente(Direzioni.nord).getPersonaggio().getNome());
	}

	@Test
	public void testCaricatore_BilocaleSalottoBloccata() throws FileNotFoundException, FormatoFileNonValidoException {
		assertEquals("StanzaBloccata",this.bilocale.getStanzaIniziale().getClass().getSimpleName());
	}

	@Test
	public void testCaricatore_TrilocaleSalottoBuiaECucinaMagica() throws FileNotFoundException, FormatoFileNonValidoException {
		assertEquals("StanzaBuia",this.trilocale.getStanzaIniziale().getClass().getSimpleName());
		assertEquals("StanzaMagica",this.trilocale.getStanzaIniziale().getStanzaAdiacente(Direzioni.nord).getClass().getSimpleName());
	}
}
