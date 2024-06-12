package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	public ComandoPrendi(IO io) {
		super("prendi",io);
	}
	
	public ComandoPrendi() {
		this(null);
	}
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getNumeroAttrezzi()==0) { 
			this.getIo().mostraMessaggio("nessun attrezzo presente nella stanza");
			return;
		}
		else if(this.getParametro() == null) 
			this.getIo().mostraMessaggio("spceificare l'attrezzo da prendere");
		else {
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
			if(a!=null) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				partita.getStanzaCorrente().removeAttrezzo(a);
				this.getIo().mostraMessaggio(this.getParametro()+" preso da "+partita.getStanzaCorrente().getNome()+" e messo in borsa");
			}
			else this.getIo().mostraMessaggio(this.getParametro()+" non presente nella stanza");
		}

	}

}
