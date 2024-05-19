package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

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
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 1);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
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
		
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 1);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		
		assertNotNull(borsa.getAttrezzo("attrezzo4"));
	}

	@Test
	public void testGetAttrezzo_OggettoAssente() {
		
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 1);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
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
		
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 1);
		int i=0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		
		assertEquals(10, borsa.getPeso());
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
	
	@Test
	public void testGetPeso_BorsaPiena() {
        Borsa borsa = new Borsa();
        int i = 0;
        Attrezzo attrezzo = new Attrezzo("attrezzo"+i, 1);
        while(borsa.addAttrezzo(attrezzo)) {
            i++;
            attrezzo = new Attrezzo("attrezzo"+i, 1);
            borsa.addAttrezzo(attrezzo);
        }
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
	
	// Test getContenutoOrdinatoPerPeso -- INIZIO
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_BorsaVuota() {
		
		Borsa borsa = new Borsa();
		
		assertNull(borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_PesiDiveri() {
		
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 5);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 2);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 3);
		
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);
		
		List<Attrezzo> listaOrdinata = borsa.getContenutoOrdinatoPerPeso();
		
		assertEquals(attrezzo2, listaOrdinata.get(0));
		assertEquals(attrezzo3, listaOrdinata.get(1));
		assertEquals(attrezzo1, listaOrdinata.get(2));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_PesiUguali() {
		
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 2);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 2);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 2);
		Attrezzo attrezzo4 = new Attrezzo("attrezzo4", 2);
		Attrezzo attrezzo5 = new Attrezzo("attrezzo5", 2);
		
		borsa.addAttrezzo(attrezzo3);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo5);
		borsa.addAttrezzo(attrezzo4);
		borsa.addAttrezzo(attrezzo2);
		
		assertEquals(attrezzo1, borsa.getContenutoOrdinatoPerPeso().get(0));
		assertEquals(attrezzo2, borsa.getContenutoOrdinatoPerPeso().get(1));
		assertEquals(attrezzo3, borsa.getContenutoOrdinatoPerPeso().get(2));
		assertEquals(attrezzo4, borsa.getContenutoOrdinatoPerPeso().get(3));
		assertEquals(attrezzo5, borsa.getContenutoOrdinatoPerPeso().get(4));
		
	}

	// Test getContenutoOrdinatoPerPeso -- FINE
	
	//Test getContenutoOrdinatoPerNome -- INIZIO
	
	@Test
	public void testGetContenutoOrdinatoPerNome_BorsaVuota() {
		
		Borsa borsa = new Borsa();
		
		assertNull(borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_NomiDiversi() {
		
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo1 = new Attrezzo("aaattrezzo", 1);
		Attrezzo attrezzo2 = new Attrezzo("abattrezzo", 3);
		Attrezzo attrezzo3 = new Attrezzo("bbattrezzo", 2);
		
		borsa.addAttrezzo(attrezzo3);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo1);
		
		SortedSet<Attrezzo> insiemeOrdinato = borsa.getContenutoOrdinatoPerNome();
		
		Iterator<Attrezzo> i = insiemeOrdinato.iterator();
		Attrezzo attrezzoLetto = i.next();
		assertEquals(attrezzo1, attrezzoLetto);
		attrezzoLetto = i.next();
		assertEquals(attrezzo2, attrezzoLetto);
		attrezzoLetto = i.next();
		assertEquals(attrezzo3, attrezzoLetto);
		
	}
	
	
	//Test getContenutoOrdinatoPerNome -- FINE

	//Test getContenutoRaggruppatoPerPeso -- INIZIO
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_BorsaVuota() {
		
		Borsa borsa = new Borsa();
		
		assertNull(borsa.getContenutoRaggruppatoPerPeso());
		
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_molteplicitàSingola() {
		
		Borsa borsa = new Borsa();
		
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 2);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 1);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 2);
		Attrezzo attrezzo4 = new Attrezzo("attrezzo4", 1);
		Attrezzo attrezzo5 = new Attrezzo("attrezzo5", 1);
		
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);
		borsa.addAttrezzo(attrezzo4);
		borsa.addAttrezzo(attrezzo5);
		
		Map<Integer, Set<Attrezzo>> attrezziRaggruppati = borsa.getContenutoRaggruppatoPerPeso();
		
		assertTrue(attrezziRaggruppati.containsKey(1));
		assertTrue(attrezziRaggruppati.containsKey(2));
		
		Set<Attrezzo> insieme1 = attrezziRaggruppati.get(1);
		
		assertTrue(insieme1.contains(attrezzo2));
		assertTrue(insieme1.contains(attrezzo4));
		assertTrue(insieme1.contains(attrezzo5));
		
		Set<Attrezzo> insieme2 = attrezziRaggruppati.get(2);
		
		assertTrue(insieme2.contains(attrezzo1));
		assertTrue(insieme2.contains(attrezzo3));
		
	}
	
	//Test getContenutoRaggruppatoPerPeso -- FINE
}
