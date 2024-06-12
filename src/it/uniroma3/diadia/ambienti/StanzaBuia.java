package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String attrezzoCheFaLuce;

	public StanzaBuia(String nome, String attrezzoCheFaLuce) {
		super(nome);
		this.attrezzoCheFaLuce=attrezzoCheFaLuce;
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(this.attrezzoCheFaLuce)) 
			return super.toString();
		return "qui c'è un buio pesto";
	}

}
