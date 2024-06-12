package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	public ComandoRegala(IO io) {
		super("regala",io);
	}
	
	public ComandoRegala() {
		this(null);
	}

	@Override
	public void esegui(Partita partita) {

		if(partita.getStanzaCorrente().getPersonaggio()==null) {
			this.getIo().mostraMessaggio("non c'è nessuno a cui regalare qualcosa");
			return;
		}
		
		if(this.getParametro()==null) {
			this.getIo().mostraMessaggio("specificare l'attrezzo da regalare");
			return;
		}
		
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(this.getParametro())) {
			this.getIo().mostraMessaggio("attrezzo non presente in borsa");
			return;
		}

		Attrezzo regalo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());

		if(regalo!=null) {
			partita.getStanzaCorrente().getPersonaggio().riceviRegalo(regalo, partita);
			partita.getGiocatore().getBorsa().removeAttrezzo(regalo.getNome());
		}
	}
}
