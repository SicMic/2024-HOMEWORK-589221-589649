package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando{
	
	private String attrezzo;
	private IO console; 
	
	public ComandoPrendi(IO console) {
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanza = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		boolean aggiunto = false;
		boolean rimosso = false;
		
		if (borsa.addAttrezzo(stanza.getAttrezzo(attrezzo))) {
			aggiunto = true;
			if (stanza.removeAttrezzo(stanza.getAttrezzo(attrezzo)))
				rimosso = true;
		}
		
		if (aggiunto && rimosso)
			console.mostraMessaggio("Attrezzo preso!");
		
		else if(aggiunto == true && rimosso == false) {
			borsa.removeAttrezzo(attrezzo);
			console.mostraMessaggio("Operazione non riuscita");
			
		} else
			console.mostraMessaggio("Operazione non riuscita");		
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

}
