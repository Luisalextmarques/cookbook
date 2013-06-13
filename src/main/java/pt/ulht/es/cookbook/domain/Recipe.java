package pt.ulht.es.cookbook.domain;

/**
 * Classe de Recipe
 * @author lm
 * @author bcs
 *
 */
public class Recipe extends Recipe_Base {

	/**
	 * Construtor de recipe, utilizado apenas quando é nova receita, caso contrario estamos a adicionar versões.
	 * @param titulo
	 * @param problema
	 * @param solucao
	 * @param autor
	 * @param classificacoes
	 */
	public Recipe(String titulo, String problema, String solucao, String autor,
			String classificacoes) {
		RecipeVersion a = new RecipeVersion(titulo, problema, solucao, autor,
				classificacoes);
		a.setRecipeLast(this);
		a.setRecipe(this);
		// a.addTag(new Tag(classificacoes));
		a.tags(classificacoes);

	}


	/**
	 * pesquisa de recipes, pesquisado apenas ultima versão
	 * @param strPesquisa
	 * @return
	 */
	public RecipeVersion match(String strPesquisa) {
		if (this.getLastVersion().pesquisaTexto(strPesquisa.toLowerCase()))
			return this.getLastVersion();
		return null;
	}

	/**
	 * Apagar Recipes, apagar em cascata.
	 */
	public void delete() {

		setLastVersion(null);
		for (RecipeVersion rc : getRecipeVersionSet()) {
			rc.delete();
			//removeRecipeVersion(rc);
		}
		super.deleteDomainObject();
	}

}
