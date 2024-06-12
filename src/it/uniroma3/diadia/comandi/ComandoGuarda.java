package it.uniroma3.diadia.comandi;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoGuarda extends AbstractComando{
	
	public ComandoGuarda(IO io) {
		super("guarda", io);
	}
	
	public ComandoGuarda() {
		this(null);
	}
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("cfu correnti: "+partita.getGiocatore().getCfu());
		this.getIo().mostraMessaggio("gli attrezzi nella borsa sono:");
		Map<Integer,Set<Attrezzo>> mappaBorsa = partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso();
		Set<Integer> pesi = mappaBorsa.keySet();
		Iterator<Integer> iteratore = pesi.iterator();
		while(iteratore.hasNext()) {
			int key = iteratore.next();
			StringBuilder s = new StringBuilder();
			s.append("( "+key+", { ");
			Set<Attrezzo> attrezziPesoKey = mappaBorsa.get(key);
			Iterator<Attrezzo> iteratoreAttrezzi = attrezziPesoKey.iterator();
			while (iteratoreAttrezzi.hasNext()) {s.append(iteratoreAttrezzi.next().getNome()+", ");}
			s.delete(s.length()-2, s.length()-1);
			s.append("} )");
			this.getIo().mostraMessaggio(s.toString());
		}
	}

}
