package pt.ulht.es.cookbook.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;

public class Recipe extends Recipe_Base implements Comparable<Recipe> {
    
    public  Recipe(String titulo, String problema, String solucao, String autor, String classificacoes) {
        setTitulo(titulo);
        setProblema(problema);
        setSolucao(solucao);
        setAutor(autor);
        setDataCriacao(new DateTime());
        
        //addTags(new Tags(classificacoes, this));
        setCookbookManager(CookbookManager.getInstance());
        
        
    }

    public void tags (String classificacao){
    	addTags(new Tags(classificacao));
    }
    
	public int compareTo(Recipe o) {
		return getTitulo().toLowerCase().compareTo(o.getTitulo().toLowerCase());		
	}
	
	public void delete() {
		setCookbookManager(null);
		List<Tags> lista =  new ArrayList<Tags>(this.getTags());
		Iterator<Tags> it = lista.iterator();
		while (it.hasNext()){
			it.next().delete();
		}
		

		super.deleteDomainObject();
	}
    
}
