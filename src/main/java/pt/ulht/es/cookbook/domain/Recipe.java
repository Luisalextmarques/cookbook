package pt.ulht.es.cookbook.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.taglibs.standard.tag.common.xml.SetTag;



public class Recipe extends Recipe_Base  {
    
	public Recipe(String titulo, String problema, String solucao, String autor, String classificacoes) {
		RecipeVersion a = new RecipeVersion(titulo, problema, solucao, autor, classificacoes);
		a.setRecipeLast(this);
		a.setRecipe(this);
		//a.addTag(new Tag(classificacoes));
		a.tags(classificacoes);
		
	}
	
	public Recipe(String titulo, String problema, String solucao, String autor, String classificacoes, Recipe oldRec) {
		RecipeVersion a = new RecipeVersion(titulo, problema, solucao, autor, classificacoes);
		//a.setRecipeLast(this);		
		a.setRecipe(oldRec);
		//a.addTag(new Tag(classificacoes));
		a.tags(classificacoes);
		
	}
	
	public RecipeVersion match(String strPesquisa){
		if (this.getLastVersion().pesquisaTexto(strPesquisa))
			return this.getLastVersion();	
		return null;
	}

    public void delete(){
    	
    	setLastVersion(null);
		for (RecipeVersion rc :getRecipeVersionSet()){
			rc.delete();
			removeRecipeVersion(rc);
		}		
		super.deleteDomainObject();
    }
	
	
    
}
