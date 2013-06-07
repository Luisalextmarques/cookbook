package pt.ulht.es.cookbook.domain;



public class Recipe extends Recipe_Base  {
    
	public Recipe(String titulo, String problema, String solucao, String autor, String classificacoes) {
		RecipeVersion a = new RecipeVersion(titulo, problema, solucao, autor, classificacoes);
		a.setRecipeLast(this);
		a.setRecipe(this);
		//a.addTag(new Tag(classificacoes));
		a.tags(classificacoes);
		
	}
	
	public RecipeVersion match(String strPesquisa){
		if (this.getLastVersion().pesquisaTexto(strPesquisa))
			return this.getLastVersion();
			
			
		return null;
		
		
	}

    
	
	
    
}
