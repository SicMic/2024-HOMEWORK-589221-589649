package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {


	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}



	@Override
	public String agisci(Partita partita) {

		Stanza destinazione = partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.nord);
		Direzioni bloccata = null;
		
		if(partita.getStanzaCorrente().getDescrizione().contains("la porta a")) {
			if(partita.getStanzaCorrente().getDescrizione().contains("la porta a nord è bloccata")) bloccata = Direzioni.nord;
			if(partita.getStanzaCorrente().getDescrizione().contains("la porta a est è bloccata")) bloccata = Direzioni.est;
			if(partita.getStanzaCorrente().getDescrizione().contains("la porta a sud è bloccata")) bloccata = Direzioni.sud;
			if(partita.getStanzaCorrente().getDescrizione().contains("la porta a ovest è bloccata")) bloccata = Direzioni.ovest;
		}

		while(destinazione==null) {
			for(Direzioni direzione : partita.getStanzaCorrente().getDirezioni())
				if(partita.getStanzaCorrente()!=partita.getStanzaCorrente().getStanzaAdiacente(direzione)) 
					destinazione = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		}

		if(this.haSalutato()) {
			int numeroAttrezziMax = destinazione.getNumeroAttrezzi();
			for(Stanza altraStanza : partita.getStanzaCorrente().getStanzeAdiacenti().values()) {
				if(altraStanza.getNumeroAttrezzi() >= numeroAttrezziMax && altraStanza!=partita.getStanzaCorrente().getStanzeAdiacenti().get(bloccata)) {
					numeroAttrezziMax=altraStanza.getNumeroAttrezzi();
					destinazione = altraStanza;
				}
			}
		}else {
			int numeroAttrezziMin = destinazione.getNumeroAttrezzi();
			for(Stanza altraStanza : partita.getStanzaCorrente().getStanzeAdiacenti().values()) {
				if(altraStanza.getNumeroAttrezzi() <= numeroAttrezziMin && altraStanza!=partita.getStanzaCorrente().getStanzeAdiacenti().get(bloccata)) {
					numeroAttrezziMin=altraStanza.getNumeroAttrezzi();
					destinazione = altraStanza;
				}
			}
		}

		partita.setStanzaCorrente(destinazione);
		String msg = "la strega ti ha spostato...";
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		String msg = "ih-ih-ih-ih-ih!!!";
		return msg;
	}

}
