package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{
	
	public ComandoPosa(IO io) {
		super("posa", io);
	}
	
	public ComandoPosa() {
		this(null);
	}

	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null) {
			this.getIo().mostraMessaggio("specificare l'attrezzo da posare");
			return;
		}
		if(partita.getGiocatore().getBorsa().isEmpty()) {
			this.getIo().mostraMessaggio("nessun attrezzo nella borsa");
			return;
		}
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		if(a!=null) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
			this.getIo().mostraMessaggio(this.getParametro()+" rimosso dalla borsa e posato in "+partita.getStanzaCorrente().getNome());
		}
		else this.getIo().mostraMessaggio(this.getParametro() + " non presente in borsa");
	}

}
