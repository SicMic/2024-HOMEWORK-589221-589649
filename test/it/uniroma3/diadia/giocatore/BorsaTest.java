package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo peso10;
	private Attrezzo peso9;

	@Before
	public void setUp() {
		this.borsa = new Borsa(10);
		this.a1 = new Attrezzo("a1",1);
		this.a2 = new Attrezzo("a2",2);
		new Attrezzo("a3",3);
		this.peso10 = new Attrezzo("peso", 10);
		this.peso9 = new Attrezzo("peso", 9);
	}

	/* Test addAttrezzo */
	@Test
	public void testAddAttrezzo_BorsaVuota() {
		this.borsa.addAttrezzo(a1);
		assertTrue(this.borsa.hasAttrezzo("a1"));
	}

	@Test
	public void testAddAttrezzo_BorsaNonVuota() {
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		assertTrue(this.borsa.hasAttrezzo("a1"));
		assertTrue(this.borsa.hasAttrezzo("a2"));
	}

	@Test
	public void testAddAttrezzo_BorsaPiena() {
		this.borsa.addAttrezzo(peso10);
		assertFalse(this.borsa.addAttrezzo(a1));
	}

	@Test
	public void testAddAttrezzo_BorsaQuasiPienaEAggiuntaSupererebbeLimite() {
		this.borsa.addAttrezzo(peso9);
		assertFalse(this.borsa.addAttrezzo(a2));
	}

	/* Test getAttrezzo */
	@Test
	public void testGetAttrezzo_OggettoInBorsa(){
		this.borsa.addAttrezzo(a1);
		assertEquals(a1,this.borsa.getAttrezzo("a1"));
	}

	@Test
	public void testGetAttrezzo_BorsaVuota() {
		assertNull(this.borsa.getAttrezzo("a1"));
	}

	@Test
	public void testGetAttrezzo_BorsaNonVuotaOggettoNonInBorsa() {
		this.borsa.addAttrezzo(a1);
		assertNull(this.borsa.getAttrezzo("a2"));
	}

	/* Test hasAttrezzo */
	@Test
	public void testHasAttrezzo_OggettoInBorsa() {
		this.borsa.addAttrezzo(a1);
		assertTrue(this.borsa.hasAttrezzo("a1"));
	}

	@Test
	public void testHasAttrezzo_BorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo("a1"));
	}

	@Test
	public void testHasAttrezzo_BorsaNonVuotaOggettoNonInBorsa() {
		this.borsa.addAttrezzo(a1);
		assertFalse(this.borsa.hasAttrezzo("a2"));
	}

	/* Test removeAttrezzo */
	@Test
	public void testRemoveAttrezzo_InBorsa() {
		this.borsa.addAttrezzo(a1);
		assertEquals(a1,this.borsa.removeAttrezzo("a1"));
	}

	@Test
	public void testRemoveAttrezzo_NonInBorsa() {
		this.borsa.addAttrezzo(a1);
		assertNull(this.borsa.removeAttrezzo("a2"));
	}

	@Test
	public void testRemoveAttrezzo_SecondoAttrezzo() {
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		assertEquals(a2,this.borsa.removeAttrezzo("a2"));
	}

	@Test
	public void testRemoveAttrezzo_BorsaVuota() {
		assertNull(this.borsa.removeAttrezzo("a1"));
	}

	/* Test isEmpty */
	@Test
	public void testIsEmpty_BorsaVuota() {
		assertTrue(this.borsa.isEmpty());
	}

	@Test
	public void testIsEmpty_BorsaNonVuota() {
		this.borsa.addAttrezzo(a1);
		assertFalse(this.borsa.isEmpty());
	}

	@Test
	public void testIsEmpty_BorsaPiena() {
		this.borsa.addAttrezzo(peso10);
		assertFalse(this.borsa.isEmpty());
	}

	/* Test getContenutoOrdinatoPerPeso */
	@Test
	public void testGetContenutoOrdinatoPerPeso_BorsaVuota() {
		assertTrue(this.borsa.getContenutoOrdinatoPerPeso().isEmpty());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_BorsaConDueAttrezziConLoStessoPeso() {
		Attrezzo a1_2 = new Attrezzo("a1_2",1);
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a1_2);
		assertEquals(a1,this.borsa.getContenutoOrdinatoPerPeso().get(0));
		assertEquals(a1_2,this.borsa.getContenutoOrdinatoPerPeso().get(1));
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_BorsaConDueAttrezziConPesiDIversi() {
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		assertEquals(a1,this.borsa.getContenutoOrdinatoPerPeso().get(0));
		assertEquals(a2,this.borsa.getContenutoOrdinatoPerPeso().get(1));	
	}

	/* Test getContenutoOrdinatoPerNome */
	@Test
	public void testGetContenutoOrdinatoPerNome_BorsaVuota() {
		assertTrue(this.borsa.getContenutoOrdinatoPerNome().isEmpty());
	}

	@Test
	public void testGetContenutoOrdinatoPerNome_BorsaConDueOggetti() {
		Attrezzo attrezzo_a = new Attrezzo("a",1);
		Attrezzo attrezzo_b = new Attrezzo("b",1);
		this.borsa.addAttrezzo(attrezzo_a);
		this.borsa.addAttrezzo(attrezzo_b);

		Set<Attrezzo> contenuto = this.borsa.getContenutoOrdinatoPerNome();

		Iterator<Attrezzo> iter = contenuto.iterator();
		assertEquals(attrezzo_a,iter.next());
		assertEquals(attrezzo_b,iter.next());



	}

	@Test
	public void getContenutoOrdinatoPerNome_BorsaConTreAttrezzi() {
		Attrezzo attrezzo_a = new Attrezzo("a",1);
		Attrezzo attrezzo_b = new Attrezzo("b",1);
		Attrezzo attrezzo_c = new Attrezzo("c",1);
		this.borsa.addAttrezzo(attrezzo_a);
		this.borsa.addAttrezzo(attrezzo_b);
		this.borsa.addAttrezzo(attrezzo_c);
		Set<Attrezzo> set = this.borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> i = set.iterator();
		assertEquals(attrezzo_a,i.next());
		assertEquals(attrezzo_b,i.next());
		assertEquals(attrezzo_c,i.next());
	}

	/* Test GetContenutoRaggruppatoPerPeso */
	@Test
	public void testGetContenutoRaggruppatoPerPeso_BorsaVuota() {
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().isEmpty());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso_BorsaConDueOggettiConDueOggettiConLoStessoPeso() {
		Attrezzo a1copia = new Attrezzo("a1copia",1);
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a1copia);
		Set<Attrezzo> set = this.borsa.getContenutoRaggruppatoPerPeso().get(1);
		Iterator<Attrezzo> i =set.iterator();
		assertEquals(a1,i.next());
		assertEquals(a1copia,i.next());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso_BorsaConDueOggettiConDueOggettiConPesoDiverso() {
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		Set<Integer> set = this.borsa.getContenutoRaggruppatoPerPeso().keySet();
		Iterator<Integer> i = set.iterator();
		assertTrue(1==i.next());
		assertTrue(2==i.next());
	}

	/*Test getSortedSetOrdinatoPerPeso*/
	@Test
	public void testGetSortedSetOrdinatoPerPeso_BorsaVuota() {
		assertTrue(this.borsa.getSortedSetOrdinatoPerPeso().isEmpty());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_BorsaConDueOggettiConLoStrssoPeso() {
		Attrezzo a1copia = new Attrezzo("a1copia",1);
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a1copia);
		Set<Attrezzo> set = this.borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> i = set.iterator();
		assertEquals(a1,i.next());
		assertEquals(a1copia,i.next());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_BorsaConDueOggettiConPesoDiverso() {
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		Set<Attrezzo> set = this.borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> i = set.iterator();
		assertEquals(a1,i.next());
		assertEquals(a2,i.next());
	}
}
