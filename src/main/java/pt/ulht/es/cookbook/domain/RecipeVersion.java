package pt.ulht.es.cookbook.domain;

import org.joda.time.DateTime;

public class RecipeVersion extends RecipeVersion_Base implements
		Comparable<RecipeVersion> {

	/**
	 * Construtor de versões 
	 * @param titulo
	 * @param problema
	 * @param solucao
	 * @param autor
	 * @param classificacoes
	 */
	public RecipeVersion(String titulo, String problema, String solucao,
			String autor, String classificacoes) {
		setTitulo(titulo);
		setProblema(problema);
		setSolucao(solucao);
		setAutor(autor);
		setDataCriacao(new DateTime());
		setCookbookManager(CookbookManager.getInstance());
		// addTag(new Tag(classificacoes));

	}

	/**
	 * metodo para adicionar tags á RecipeVersion
	 * @param classificacao
	 */
	public void tags(String classificacao) {
		String arr[] = classificacao.split(",");
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].trim().equals(""))// So adiciona cenas exceto em branco
				addTag(new Tag(arr[i].trim()));

		}

	}

	/**
	 * Metodo de comparação para garantir recipes ordenadas por titulo ASC 
	 */
	public int compareTo(RecipeVersion o) {
		return getTitulo().toLowerCase().compareTo(o.getTitulo().toLowerCase());
	}

	/**
	 * Metodo para apagar RecipeVersion, apagar em cascata.
	 */
	public void delete() {

		for (Tag tag : getTagSet()) {
			tag.delete();
		}
		setCookbookManager(null);
		setRecipe(null);
		setRecipeLast(null);
		super.deleteDomainObject();
	}

	/**
	 * Metodo para pesquisa de texto nos diversos campos da recipe
	 * @param strPesquisa
	 * @return
	 */
	public boolean pesquisaTexto(String strPesquisa) {
		if (getTitulo().toLowerCase().contains(strPesquisa))
			return true;

		if (getProblema().toLowerCase().contains(strPesquisa))
			return true;

		if (getSolucao().toLowerCase().contains(strPesquisa))
			return true;
		
		for (Tag tag : getTagSet()) {
			if (tag.getTag().toLowerCase().contains(strPesquisa))
				return true;
		}

		return false;
	}
}
