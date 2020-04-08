package it.polito.tdp.spellchecker;

public class RichWord {
	
  private String parolaInput;
  private boolean isCorretta;
  
  
public RichWord(String parolaInput, boolean isCorretta) {
	super();
	this.parolaInput = parolaInput;
	this.isCorretta = isCorretta;
}

public String getParolaInput() {
	return parolaInput;
}

public boolean isParolaCorretta() {
	return isCorretta;
}
  

}
