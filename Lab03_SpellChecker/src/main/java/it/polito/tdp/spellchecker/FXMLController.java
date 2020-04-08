package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    //inizializzazione della choice box:
	private ObservableList <String> list=FXCollections.observableArrayList();   
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> bxScegliLingua;

    @FXML
    private TextArea txtInserisciTesto;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtInserisciParoleErrate;

    @FXML
    private Label txtInserisciNumeroparoleErrate;

    @FXML
    private Button btnClearText;

    @FXML
    private Label txtSpellCheckTime;

    @FXML
    void doClearText(ActionEvent event) {
    txtInserisciTesto.setText("");
    txtInserisciParoleErrate.setText("");
    txtInserisciNumeroparoleErrate.setText("");
    txtSpellCheckTime.setText("");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    Dictionary dizionarioOutput=new Dictionary();
    dizionarioOutput.loadDictionary(bxScegliLingua.getValue());
    List <String> input=new LinkedList <String>();
    String iniziale=txtInserisciTesto.getText();
    iniziale=iniziale.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_()\\[\\]\"]","");
   
    //metodo per frammentare una stringa in un insieme di stringhe 
    StringTokenizer st = new StringTokenizer(iniziale," ");
    while (st.hasMoreTokens()) {
      String token = st.nextToken(); 
      input.add(token);
    }
    
    List <RichWord> paroleErrate=dizionarioOutput.SpellCheckText(input);
    String cercata="";
    int contatore=0;
    for(RichWord r:paroleErrate)
    {
    	    
    		cercata=cercata+r.getParolaInput()+"\n";
    		contatore++;
    }
    txtInserisciParoleErrate.setText(cercata);
    txtInserisciNumeroparoleErrate.setText("The text contains "+contatore+ " errors");
    txtSpellCheckTime.setText("Spell check completed in "+System.nanoTime()/1000000000 + " nanoseconds");
    }

    @FXML
    void initialize() {
        assert bxScegliLingua != null : "fx:id=\"bxScegliLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisciTesto != null : "fx:id=\"txtInserisciTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisciParoleErrate != null : "fx:id=\"txtInserisciParoleErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisciNumeroparoleErrate != null : "fx:id=\"txtInserisciNumeroparoleErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSpellCheckTime != null : "fx:id=\"txtSpellCheckTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        //inizializzazione della choiceBox
        list.addAll("English","Italian");
        bxScegliLingua.setItems(list);
        bxScegliLingua.setValue("Italian");

    }
}
