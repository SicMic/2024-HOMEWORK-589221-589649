package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto.LabirintoBuilder builder;

	@Before
	public void setUp() throws Exception {
		this.builder = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("Atrio").addAttrezzo("osso", 1)
				.addStanzaVincente("Biblioteca")
				.addStanzaBloccata("Bloccata", Direzioni.est, "chiave")
				.addStanzaBuia("Buia", "lanterna")
				.addStanzaMagica("Magica").addAttrezzo("Attrezzo",1).addAttrezzo("Attrezzo",1).addAttrezzo("Attrezzo",1).addAttrezzo("Attrezzo",1)

				.addAdiacenza("Atrio", "Biblioteca", Direzioni.nord)
				.addAdiacenza("Atrio", "Bloccata", Direzioni.est)
				.addAdiacenza("Atrio", "Magica", Direzioni.ovest)
				.addAdiacenza("Atrio", "Buia", Direzioni.sud);
	}

	@Test
	public void testAddStanzaIniziale() {
		assertEquals(builder.getLabirinto().getStanzaIniziale().getNome(),"Atrio");
	}

	@Test
	public void testAddStanzaVincente() {
		assertEquals(builder.getLabirinto().getStanzaVincente().getNome(),"Biblioteca");
	}

	@Test
	public void testAddAdiacenza_AdiacenzaImpostataCorrettamente() {
		assertEquals(builder.getLabirinto().getStanzaIniziale().getStanzaAdiacente(Direzioni.nord).getNome(), "Biblioteca");
	}

	@Test
	public void testAddAdiacenza_AdiacnzaReciprocaImpostataCorrettamente() {
		assertEquals(builder.getLabirinto().getStanzaVincente().getStanzaAdiacente(Direzioni.sud).getNome(), "Atrio");
	}

	@Test
	public void testAddAttrezzo_AttrezzoAggiuntoCorrettamente() {
		assertEquals(builder.getLabirinto().getStanzaIniziale().hasAttrezzo("osso"), true);
		assertEquals(builder.getLabirinto().getStanzaIniziale().getAttrezzo("osso").getPeso(), 1);
	}

	@Test
	public void testAddStanzaBloccata_StanzaBloccataAggiuntaCorrettamente() {
		assertEquals(builder.getLabirinto().getStanzaIniziale().getStanzaAdiacente(Direzioni.est).getDescrizione(),"la porta a " + "est" + " è bloccata\n"
				+ "ti serve l' oggetto " + "chiave" + " nella stanza per aprirla...");
	}

	@Test
	public void testAddStanzaMagica_StanzaMagicaAggiuntaCorrettamente() {
		assertEquals(builder.getLabirinto().getStanzaIniziale().getStanzaAdiacente(Direzioni.ovest).hasAttrezzo("ozzerttA"),true);
	}

	@Test
	public void testAddStanzaBuia_StanzaBuiaAggiuntaCorrettamente() {
		assertEquals(builder.getLabirinto().getStanzaIniziale().getStanzaAdiacente(Direzioni.sud).getDescrizione(),"qui c'è un buio pesto");
	}
}
