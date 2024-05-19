package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezziPeso implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		
		if (o1.getPeso() < o2.getPeso())
			return -1;
		else if (o1.getPeso() > o2.getPeso())
			return 1;
		
		if (o1.getPeso() == o1.getPeso())
			return o1.getNome().compareTo(o2.getNome());
		
		return 0;
	}
	
}
