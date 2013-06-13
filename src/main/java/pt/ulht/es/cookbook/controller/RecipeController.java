package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Recipe;
import pt.ulht.es.cookbook.domain.RecipeVersion;
import pt.ulht.es.cookbook.domain.Tag;

@Controller
public class RecipeController {

	/**
	 * PESQUISA: recipes
	 * @param search
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/*search", method = RequestMethod.POST)
	public String search(@ModelAttribute("search") String search,
			BindingResult result, Model model) {

		if (search.trim().equals("")) {
			model.addAttribute("search", "O que pretende pesquisar?");
		} else {
			List<RecipeVersion> recipes = new ArrayList<RecipeVersion>(
					CookbookManager.getInstance().getRecipeVersionSet());
			List<RecipeVersion> resultSet = new ArrayList<RecipeVersion>();

			for (int i = 0; i < recipes.size(); i++) {
				if (recipes.get(i).hasRecipeLast()){//Ir ao ultimo
					RecipeVersion temp = recipes.get(i).getRecipeLast().match(search);
					if (temp != null)//retornou uma versão, adicionar ao set...
						resultSet.add(temp);					
				}
			}

			Collections.sort(resultSet);

			model.addAttribute("search", search + " " + resultSet.size());
			model.addAttribute("items", resultSet);
		}

		CookbookManager.getDefaults(model, "searchClass");

		return "search";

	}

	/**
	 * LISTAR: Listar Receitas - Retorna lista de receitas ordenadas.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes")
	public String listRecipes(Model model) {

		List<RecipeVersion> recipes = new ArrayList<RecipeVersion>(
				CookbookManager.getInstance().getRecipeVersionSet());
		List<RecipeVersion> recipeLastV = new ArrayList<RecipeVersion>();

		for (int i = 0; i < recipes.size(); i++) {
			if (recipes.get(i).hasRecipeLast())
				recipeLastV.add(recipes.get(i));
		}

		Collections.sort(recipeLastV);

		model.addAttribute("items", recipeLastV);
		// Comuns
		CookbookManager.getDefaults(model, "recipes");
		// Fim Comuns

		return "listRecipes";
	}

	/**
	 * LISTAR: Mostrar Receita detalhada
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes/{id}")
	public String showRecipe(Model model, @PathVariable String id) {

		// Comuns
		CookbookManager.getDefaults(model, "");
		// Fim Comuns

		Recipe receita = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);
		RecipeVersion ultimaVersao = receita.getLastVersion();

		if (ultimaVersao != null) {
			model.addAttribute("items", ultimaVersao);

			List<Tag> lista = new ArrayList<Tag>(CookbookManager.getInstance()
					.getTagSet());
			model.addAttribute("class", lista);

			List<RecipeVersion> recipes = new ArrayList<RecipeVersion>(
					CookbookManager.getInstance().getRecipeVersionSet());

			List<RecipeVersion> recipeLastV = new ArrayList<RecipeVersion>();

			for (int i = 0; i < recipes.size(); i++) {
				if (recipes.get(i).getRecipe().getOid() == receita.getOid()
						&& (!recipes.get(i).hasRecipeLast())) {
					recipeLastV.add(recipes.get(i));
				}
			}

			model.addAttribute("versoes", recipeLastV);

			return "detailedRecipe";
		} else {
			return "recipeNotFound";
		}
	}
	
	/**
	 * CRIAR: Vista de criação de receita
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/createRecipe")
	public String createRecipes(Model model) {

		// Comuns
		CookbookManager.getDefaults(model, "createRecipe");

		return "createRecipe";
	}



	/**
	 * CRIAR: Criar objeto Receita ,guardar e reencaminhar para mostragem.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createRecipe")
	public String createRecipe(Model model, String titulo, String problema,
			String solucao, String autor, String classificacoes) {

		CookbookManager.getDefaults(model, "CreateRecipe");

		Recipe criar = new Recipe(titulo, problema, solucao, autor,
				classificacoes);

		// model.addAttribute("chave",Data.putReceita(criar));
		// Tags tag = new Tags(classificacoes, criar);
		return "redirect:/recipes/" + criar.getExternalId();

		// return "sucessDelRecipe";
	}


	/**
	 * EDITAR: retornar vista de gestão de receitas
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/manageRecipes")
	public String manageRecipes(Model model) {

		List<RecipeVersion> recipes = new ArrayList<RecipeVersion>(
				CookbookManager.getInstance().getRecipeVersionSet());
		List<RecipeVersion> recipeLastV = new ArrayList<RecipeVersion>();

		for (int i = 0; i < recipes.size(); i++) {
			if (recipes.get(i).hasRecipeLast())
				recipeLastV.add(recipes.get(i));
		}

		Collections.sort(recipeLastV);

		model.addAttribute("items", recipeLastV);
		// Comuns
		CookbookManager.getDefaults(model, "manageRecipes");
		// Fim Comuns

		return "manageRecipes";
	}

	/**
	 * 
	 * EDITAR: retornar objeto a editar e reencaminhar para vista de edição.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/manageRecipes/{id}")
	public String editRecipe(Model model, @PathVariable String id) {
		// Comuns
		CookbookManager.getDefaults(model, "");
		// Fim Comuns

		RecipeVersion receitaAlterar = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);
		// RecipeVersion ultimaVersao = receita.getLastVersion();

		if (receitaAlterar != null) {
			model.addAttribute("items", receitaAlterar);
			return "editRecipe";
		} else {
			return "recipeNotFound";
		}
	}

	/**
	 * 
	 * EDITAR: Criar objeto RecipeVersion ,guardar e reencaminhar para mostragem.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/manageRecipes/editRecipe/{id}")
	public String editRecipe(Model model, @PathVariable String id,
			String titulo, String problema, String solucao, String autor,
			String classificacoes) {

		CookbookManager.getDefaults(model, "CreateRecipe");

		Recipe receita = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);
		RecipeVersion criarV = new RecipeVersion(titulo, problema, solucao,
				autor, classificacoes);
		criarV.tags(classificacoes);
		criarV.setRecipeLast(receita);
		receita.addRecipeVersion(criarV);

		return "redirect:/recipes/" + receita.getExternalId();

	}

	/**
	 * 
	 * APAGAR: retornar objeto a apagar e reencaminhar para vista de registo apagado.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/manageRecipes/del/{id}")
	public String delRecipe(Model model, @PathVariable String id) {

		// Comuns
		CookbookManager.getDefaults(model, "");
		
		RecipeVersion receita = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);		

		if (receita != null) {
			receita.getRecipe().delete();				
			model.addAttribute("items", receita);
			return "sucessDelRecipe";
		} else {
			return "recipeNotFound";
		}
	}

}