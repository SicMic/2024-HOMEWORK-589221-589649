package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private Stanza stanza1;
	private Stanza stanza2;
	private Stanza stanza3;
	private Stanza stanza4;
	private Stanza stanza5;
	private Stanza stanza6;
	private Stanza stanzaPiena;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;
	private Attrezzo a4;
	private Attrezzo a5;
	private Attrezzo a6;
	private Attrezzo a7;
	private Attrezzo a8;
	private Attrezzo a9;
	private Attrezzo a10;
	private Attrezzo a11;
	
	@Before
	public void setUp() {
		this.stanza1 =new Stanza("stanza1");
		this.stanza2 =new Stanza("stanza2");
		this.stanza3 =new Stanza("stanza3");
		this.stanza4 =new Stanza("stanza4");
		this.stanza5 =new Stanza("stanza5");
		this.stanza6 =new Stanza("stanza6");
		this.stanzaPiena = new Stanza("stanzaPiena");
		this.a1 = new Attrezzo("a1",1);
		this.a2 = new Attrezzo("a2",2);
		this.a3 = new Attrezzo("a3",3);
		this.a4 = new Attrezzo("a4",4);
		this.a5 = new Attrezzo("a5",5);
		this.a6 = new Attrezzo("a6",6);
		this.a7 = new Attrezzo("a7",7);
		this.a8 = new Attrezzo("a8",8);
		this.a9 = new Attrezzo("a9",9);
		this.a10 = new Attrezzo("a10",10);
		this.a11 = new Attrezzo("a11",11);
		this.stanza1.addAttrezzo(a1);
		this.stanza2.addAttrezzo(a2);
		this.stanzaPiena.addAttrezzo(a1);
		this.stanzaPiena.addAttrezzo(a2);
		this.stanzaPiena.addAttrezzo(a3);
		this.stanzaPiena.addAttrezzo(a4);
		this.stanzaPiena.addAttrezzo(a5);
		this.stanzaPiena.addAttrezzo(a6);
		this.stanzaPiena.addAttrezzo(a7);
		this.stanzaPiena.addAttrezzo(a8);
		this.stanzaPiena.addAttrezzo(a9);
		this.stanzaPiena.addAttrezzo(a10);
		this.stanza1.impostaStanzaAdiacente(Direzioni.nord, stanza2);
		this.stanza1.impostaStanzaAdiacente(Direzioni.est, stanza3);
		this.stanza1.impostaStanzaAdiacente(Direzioni.sud, stanza4);
		this.stanza1.impostaStanzaAdiacente(Direzioni.ovest, stanza5);
	}
	
	/* Test addAttrezzo */
	@Test 
	public void testAddAttrezzo_AggiuntaAttrezzo(){
		assertEquals(a1,this.stanza1.getAttrezzi().get(0));
	}
	
	@Test
	public void testAddAttrezzo_NumeroMassimoRaggiunto() {
		assertFalse(this.stanzaPiena.addAttrezzo(a11));
		
		
	}
	
	@Test
	public void testAddAttrezzo_AggiungeAttrezziInCodaCorrettamente() {
		this.stanza1.addAttrezzo(a2);
		assertEquals(a2,this.stanza1.getAttrezzi().get(1));
	}
	
	@Test
	public void testAddAttrezzo_ParametroNull() {
		assertFalse(this.stanza1.addAttrezzo(null));
	}
	
	/* Test hasAttrezzo*/
	@Test
	public void testHasAttrezzo_AttrezzoPresente() {
		assertTrue(this.stanza1.hasAttrezzo("a1"));
	}
	
	@Test
	public void testHasAttrezzo_AttrezzoNonPresente() {
		assertFalse(this.stanza1.hasAttrezzo("a2"));
	}
	
	@Test
	public void testHasAttrezzo_NessunAttrezzoInStanza() {
		assertFalse(this.stanza3.hasAttrezzo("a1"));
	}
	
	@Test
	public void testHasAttrezzo_ParametroNull() {
		assertFalse(this.stanza1.hasAttrezzo(null));
	}
	
	/* Test getAttrezzo */
	@Test
	public void testGetAttrezzo_AttrezzoPresente() {
		assertEquals(a1,this.stanza1.getAttrezzo("a1"));
	}
	
	@Test
	public void testGetAttrezzo_AttrezzoNonPresente() {
		assertNull(this.stanza1.getAttrezzo("a2"));
	}
	
	@Test
	public void testGetAttrezzo_NessunAttrezzo() {
		assertNull(this.stanza3.getAttrezzo("a1"));
	}
	
	@Test
	public void testGetAttrezzo_ParametroNull() {
		assertNull(this.stanza1.getAttrezzo(null));
	}
	
	/* Test removeAttrezzo */
	
	@Test
	public void testRemoveAttrezzo_AttrezzoPresente() {
		assertTrue(this.stanza1.removeAttrezzo(a1));
		assertTrue(this.stanza1.getAttrezzi().isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzo_AttrezzoNonPresente() {
		assertFalse(this.stanza1.removeAttrezzo(a2));
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaPrivaDiAttrezzi() {
		assertFalse(this.stanza3.removeAttrezzo(a1));
	}
	
	@Test
	public void testRemoveAttrezzo_ParametroNull() {
		assertFalse(this.stanza1.removeAttrezzo(null));
	}
	
	/* Test getStanzaAdiacente */
	
	@Test
	public void testGetStanzaAdiacente_StanzaPresente() {
		assertNotNull(this.stanza1.getStanzaAdiacente(Direzioni.nord));
	}
	
	@Test
	public void testGetStanzaAdiacente_StanzaInQuellaDirezioneNonEsistente() {
		assertNull(this.stanza2.getStanzaAdiacente(Direzioni.nord));
	}
	
	@Test
	public void testGetStanzaAdiacente_StanzaRitornataCorretta() {
		assertEquals(stanza2,this.stanza1.getStanzaAdiacente(Direzioni.nord));
	}
	
	/* Test impostaStanzaAdiacente*/
	@Test
	public void testImpostaStanzaAdiacente_AggiuntaQuattroStanzeInDirezioniDiverse() {
		assertEquals(stanza2,this.stanza1.getStanzaAdiacente(Direzioni.nord));
		assertEquals(stanza3,this.stanza1.getStanzaAdiacente(Direzioni.est));
		assertEquals(stanza4,this.stanza1.getStanzaAdiacente(Direzioni.sud));
		assertEquals(stanza5,this.stanza1.getStanzaAdiacente(Direzioni.ovest));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_SovrascrizioneStanza() {
		this.stanza1.impostaStanzaAdiacente(Direzioni.nord, stanza6);
		assertEquals(stanza6,this.stanza1.getStanzaAdiacente(Direzioni.nord));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_ParametroStanzaNull(){
		this.stanza1.impostaStanzaAdiacente(Direzioni.nord, null);
		assertNull(this.stanza1.getStanzaAdiacente(Direzioni.nord));
	}
	
	/* test getDirezioni */
	@Test
	public void testGetDirezioni_StanzaConQuattroDirezioniOccupate() {
		assertTrue(this.stanza1.getDirezioni().contains(Direzioni.nord));
		assertTrue(this.stanza1.getDirezioni().contains(Direzioni.est));
		assertTrue(this.stanza1.getDirezioni().contains(Direzioni.sud));
		assertTrue(this.stanza1.getDirezioni().contains(Direzioni.ovest));
	}
	
	@Test
	public void testGetDirezioni_StanzaConUnaSolaDirezione() {
		this.stanza2.impostaStanzaAdiacente(Direzioni.ovest, stanza6);
		assertEquals(Direzioni.ovest,this.stanza2.getDirezioni().get(0));
	}
	
	@Test
	public void testGetDirezioni_StanzaSenzaAdiacenze() {
		assertEquals(0,this.stanza6.getDirezioni().size());
	}


}
