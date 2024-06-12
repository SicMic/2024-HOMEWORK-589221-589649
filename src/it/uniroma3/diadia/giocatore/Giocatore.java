package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.properties.CaricatoreProperties;

public class Giocatore {
	static final private int CFU_INIZIALI = CaricatoreProperties.getCFU();
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	public void riduciCfu() {
		this.cfu--;
	}
	
	public void riduciCfu(int riduzione) {
		if(riduzione<=0) return;
		this.cfu-=riduzione;
	}
}
