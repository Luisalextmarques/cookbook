package pt.ulht.es.cookbook.domain;

import org.joda.time.DateTime;

public class Recipe extends Recipe_Base implements Comparable<Recipe> {
    
    public  Recipe(String titulo, String problema, String solucao, String autor) {
        setTitulo(titulo);
        setProblema(problema);
        setSolucao(solucao);
        setAutor(autor);
        setDataCriacao(new DateTime());
        
        setCookbookManager(CookbookManager.getInstance());
        
    }

	public int compareTo(Recipe o) {
		return getTitulo().toLowerCase().compareTo(o.getTitulo().toLowerCase());		
	}
    
}
