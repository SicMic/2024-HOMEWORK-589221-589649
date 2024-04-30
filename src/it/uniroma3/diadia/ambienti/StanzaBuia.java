package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private String lanterna = "lanterna";
	private final String messaggioBuio = "in questa stanza c'è buio pesto";

	public StanzaBuia(String nome) {
		super(nome);
	}
	
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(lanterna))
			return messaggioBuio;
		
		return super.getDescrizione();
    }

}
