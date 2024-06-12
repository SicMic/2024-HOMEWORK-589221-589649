package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando{	
	public ComandoVai(IO io) {
		super("vai", io);
	}
	
	public ComandoVai() {
		this(null);
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.getParametro()==null) {
			this.getIo().mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzioni.fromName(this.getParametro()));
		if(prossimaStanza==null) {
			this.getIo().mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().riduciCfu();
	}

}
