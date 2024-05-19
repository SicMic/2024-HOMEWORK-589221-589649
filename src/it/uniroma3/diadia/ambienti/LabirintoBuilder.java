package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	
	private Map<String, Stanza> nomeStanza2Stanza;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nomeStanza2Stanza = new HashMap<>();
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		
		Stanza stanza = new Stanza(nomeStanza);
		this.nomeStanza2Stanza.put(nomeStanza, stanza);
		this.ultimaStanzaAggiunta = stanza;
		this.labirinto.setStanzaIniziale(stanza);

		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		
		Stanza stanza = new Stanza(nomeStanza);

		this.nomeStanza2Stanza.put(nomeStanza, stanza);
		this.ultimaStanzaAggiunta = stanza;
		this.labirinto.setStanzaFinale(stanza);
		
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
	
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);
		
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String prima, String seconda, String direzione) {
		
		Stanza stanzaPrima = this.nomeStanza2Stanza.get(prima);
		Stanza stanzaSeconda = this.nomeStanza2Stanza.get(seconda);
		
		stanzaPrima.impostaStanzaAdiacente(direzione, stanzaSeconda); // <---------- va fatto anche il simmetrico?
		
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		
		Stanza stanza = new Stanza(nomeStanza);
		this.nomeStanza2Stanza.put(nomeStanza, stanza);
		
		return this;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
}
