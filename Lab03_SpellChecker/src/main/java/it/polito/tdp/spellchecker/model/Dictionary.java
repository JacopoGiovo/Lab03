package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import it.polito.tdp.spellchecker.RichWord;

public class Dictionary {
	List <String> dizionario=new LinkedList <String>();
	
	public void loadDictionary (String language){
	    
		//dizionario.clear();
		if(language.compareTo("English")==0)
    {
		try {
			FileReader fr=new FileReader("src/main/resources/English.txt");
			BufferedReader br= new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null)
			{
				//aggiungere parola alla struttura dati
				dizionario.add(word.toLowerCase());	
			}
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura da file!\n");
		}
		
	}
	else {
		try {
			FileReader fr=new FileReader("src/main/resources/Italian.txt");
			BufferedReader br= new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null)
			{
				//aggiungere parola alla struttura dati
				dizionario.add(word.toLowerCase());	
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura da file!\n");
		}
	     }	
	}
    
	public List <RichWord> SpellCheckText (List <String> inputTextList)
	{	
		List <RichWord> parole=new LinkedList <RichWord>();    
		for(String s:inputTextList) {
			int trovato=0;
			for(String p:dizionario) {
				if(p.compareTo(s)==0)
				trovato=1;
			}
			if(trovato==0)
			{
				RichWord ptemp=new RichWord(s.toLowerCase(),false);
				parole.add(ptemp);
			}
		}
		return parole;	
	}
}
