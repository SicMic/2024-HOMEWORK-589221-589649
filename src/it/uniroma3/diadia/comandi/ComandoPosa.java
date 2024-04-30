package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando{
	
	private IO console;
	private String attrezzo;
	
	
	public ComandoPosa(IO console) {
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanza = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		Attrezzo attrezzoDaPosare = borsa.getAttrezzo(attrezzo);
		
		boolean rimosso = false;
		boolean aggiunto = false;

		if (attrezzoDaPosare != null) {
			if(borsa.removeAttrezzo(attrezzoDaPosare.getNome()) != null) {
				rimosso = true;
				if (stanza.addAttrezzo(attrezzoDaPosare))
					aggiunto = true;
			}
		}
		
		if (rimosso && aggiunto)
			console.mostraMessaggio("Attrezzo posato!");
		
		else if (rimosso && !aggiunto) {
			borsa.addAttrezzo(attrezzoDaPosare);
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
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

}
