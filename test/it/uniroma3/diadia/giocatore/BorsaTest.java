package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Test;

public class BorsaTest {

	// Test addAttrezzo -- INIZIO
	
	@Test
	public void testAddAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
		assertTrue(borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAddAttrezzo_BorsaPesoMax() {
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		
		Attrezzo attrezzoExtra = new Attrezzo("attrezzoExtra", 5);
		
		assertFalse(borsa.addAttrezzo(attrezzoExtra));		
	}
	
	@Test
	public void testAddAttrezzo_NumeroMassimoAttrezzi() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 0);
		}
		
		Attrezzo attrezzoExtra = new Attrezzo("attrezzoExtra", 2);
		assertFalse(borsa.addAttrezzo(attrezzoExtra));
	}
	
	// Test addAttrezzo -- FINE
	
	// Test getAttrezzo -- INIZIO
	
	@Test
	public void testGetAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();
		
		assertNull(borsa.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzo_OggettoPresenteInBorsa() {
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 0);
		}
		
		assertNotNull(borsa.getAttrezzo("attrezzo4"));
	}

	@Test
	public void testGetAttrezzo_OggettoAssente() {
Borsa borsa = new Borsa();
		
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 0);
		}
		
		assertNull(borsa.getAttrezzo("attrezzo10"));
	}
	
	// Test getAttrezzo -- FINE
	
	// Test getPeso -- INIZIO
	
	@Test
	public void testGetPeso_BorsaVuota() {
		Borsa borsa = new Borsa();
		assertEquals(0, borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_BorsaUnElemento() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo", 4);
		
		borsa.addAttrezzo(attrezzo);
		
		assertEquals(4, borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_BorsaPienaElementi() {
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 0);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		
		assertEquals(9, borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_BorsaPesoMassimo() {
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 6);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 4);
		
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		
		assertEquals(10, borsa.getPeso());
	}
	
	// Test getPeso -- FINE
	
	// Test removeAttrezzo -- INIZIO
	
	@Test
	public void testRemoveAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();
		
		assertNull(borsa.removeAttrezzo("attrezzo"));
	}
	
	@Test
    public void testRemoveAttrezzo_ElementoPresente() {
        Borsa borsa = new Borsa();
        Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 1);
        Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 1);
        Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 1);

        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        borsa.addAttrezzo(attrezzo3);

        assertEquals(attrezzo2, borsa.getAttrezzo("attrezzo2"));
    }
	
	@Test
	public void testRemoveAttrezzo_ElementoAssente() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 1);
        Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 1);
        
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        
        assertNull(borsa.removeAttrezzo("attrezzo3"));
    
	}
	
	// Test removeAttrezzo -- FINE

}
