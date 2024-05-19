package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	//private String lanterna = "lanterna";
	private final String messaggioBuio = "in questa stanza c'è buio pesto";

	private String oggettoLuminoso;
	
	public StanzaBuia(String nome, String oggetto) {
		super(nome);
		this.oggettoLuminoso = oggetto;
	}
	
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(this.oggettoLuminoso))
			return messaggioBuio;
		
		return super.getDescrizione();
    }

}
