package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Recipe;


@Controller
public class RecipeController {
	// Data listaReceitas = new Data();
	/*
	 * Listar Receitas - Retorna lista de receitas ordenadas.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes")
	public String listRecipes(Model model) {
		/*
		 * List<String> values = new ArrayList<String>(); values.add("Ola");
		 * values.add("Mundo"); model.addAttribute("items", values);
		 */
		List<Recipe> recipes = new ArrayList<Recipe>(CookbookManager
				.getInstance().getRecipeSet());

		Collections.sort(recipes);

		model.addAttribute("items", recipes);
		// Comuns
		CookbookManager.getDefaults(model, "recipes");
		// Fim Comuns

		return "listRecipes";
	}

	/*
	 * Vista de criação de receita
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/createRecipe")
	public String createRecipes(Model model) {

		// Comuns
		CookbookManager.getDefaults(model, "createRecipe");

		return "createRecipe";
	}

	/*
	 * Mostrar Receita
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes/{id}")
	public String showRecipe(Model model, @PathVariable String id) {

		// Comuns
		CookbookManager.getDefaults(model, "");
		// Fim Comuns
		Recipe receita = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);

		if (receita != null) {
			model.addAttribute("items", receita);
			return "detailedRecipe";
		} else {
			return "recipeNotFound";
		}
	}

	/*
	 * Criar objeto Receita ,guardar e reencaminhar para mostragem.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createRecipe")
	public String createRecipe(Model model, String titulo, String problema,
			String solucao, String autor) {

		CookbookManager.getDefaults(model, "CreateRecipe");

		Recipe criar = new Recipe(titulo, problema, solucao, autor);
		// model.addAttribute("chave",Data.putReceita(criar));

		return "redirect:/recipes/" + criar.getExternalId();

		// return "sucessRecipe";
	}

	// MANAGE RECIPES

	/*
	 * retornar vista de gestão de receitas
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/manageRecipes")
	public String manageRecipes(Model model) {
		/*
		 * List<String> values = new ArrayList<String>(); values.add("Ola");
		 * values.add("Mundo"); model.addAttribute("items", values);
		 */
		Set<Recipe> recipes = CookbookManager.getInstance().getRecipeSet();

		model.addAttribute("items", recipes);
		// Comuns
		CookbookManager.getDefaults(model, "manageRecipes");
		// Fim Comuns

		return "manageRecipes";
	}

	/*
	 * retornar objeto a editar e reencaminhar para vista de edição.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/manageRecipes/{id}")
	public String editRecipe(Model model, @PathVariable String id) {

		// Comuns
		CookbookManager.getDefaults(model, "");
		// Fim Comuns
		Recipe receita = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);

		if (receita != null) {
			model.addAttribute("items", receita);
			return "editRecipe";
		} else {
			return "recipeNotFound";
		}
	}

	/*
	 * retornar objeto a editar e reencaminhar para vista de edição.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/manageRecipes/del/{id}")
	public String delRecipe(Model model, @PathVariable String id) {

		// Comuns
		CookbookManager.getDefaults(model, "");
		// Fim Comuns
		Recipe receita = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);
		

		if (receita != null) {
			receita.delete();
			CookbookManager.getInstance().removeRecipe(receita);
			model.addAttribute("items", receita);
			return "sucessDelRecipe";
		} else {
			return "recipeNotFound";
		}
	}
	
	

}