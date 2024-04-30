package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {

	 // Test getNome -- INIZIO

	@Test
	public void testCostruisciComando_ComandoVai() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("vai nord");
		
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_ComandoNull() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("");
		
		assertEquals("non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_ComandoNonValido() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("gggggg");
		
		assertEquals("non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_ComandoAiuto() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("aiuto");
		
		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_ComandoFine() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("fine");
		
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_ComandoGuarda() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("guarda");
		
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_ComandoPosa() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("posa attrezzo");
		
		assertEquals("posa", comando.getNome());
		assertEquals("attrezzo", comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_ComandoPrendi() {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(null);
		Comando comando = factory.costruisciComando("prendi attrezzo");
		
		assertEquals("prendi", comando.getNome());
		assertEquals("attrezzo", comando.getParametro());
	}
	
	//Test costruisciComando -- FINE

}
