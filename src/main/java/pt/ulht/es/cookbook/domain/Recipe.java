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
        
        //addTag(new Tag(classificacoes, this));
        setCookbookManager(CookbookManager.getInstance());
        
        
    }

    public void tags (String classificacao){    	
    	String arr[] = classificacao.split(",");
    	for (int i =0;i<arr.length;i++){
    		addTag(new Tag(arr[i].trim()));
    		
    	}   
    	
    }
    
	public int compareTo(Recipe o) {
		return getTitulo().toLowerCase().compareTo(o.getTitulo().toLowerCase());		
	}
	
	public void delete() {
		setCookbookManager(null);
		List<Tag> lista =  new ArrayList<Tag>(this.getTag());
		Iterator<Tag> it = lista.iterator();
		while (it.hasNext()){
			it.next().delete();
		}
		

		super.deleteDomainObject();
	}
	
	public boolean pesquisaTexto(String strPesquisa) {
		if (getTitulo().toLowerCase().contains(strPesquisa))
			return true;
		
		if (getProblema().toLowerCase().contains(strPesquisa))
			return true;
		
		if (getSolucao().toLowerCase().contains(strPesquisa))
			return true;
		
		return false;
	}
    
}
