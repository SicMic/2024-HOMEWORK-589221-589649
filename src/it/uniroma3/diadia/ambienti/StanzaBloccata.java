package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private final String passepartout = "passepartout";
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String direzioneBloccata) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		
        if(direzione.equals(direzioneBloccata) && !this.hasAttrezzo(passepartout))
        	return this;
        
		return super.getStanzaAdiacente(direzione);
	}

}
