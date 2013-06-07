package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	/*
	 * @RequestMapping(value = "/search", method = RequestMethod.POST) public
	 * String search(@ModelAttribute("search") String search, BindingResult
	 * result, Model model) {
	 * 
	 * List<Recipe> recipes = new
	 * ArrayList<Recipe>(CookbookManager.getInstance().getRecipeSet());
	 * 
	 * for (int i =0;i<RecipeVersion.size();i++){ if
	 * (!RecipeVersion.get(i).pesquisaTexto(search)){ recipes.remove(i--);
	 * System.out.println("Removido" + i + " " + recipes.size()); } }
	 * 
	 * 
	 * Collections.sort(recipes);
	 * 
	 * model.addAttribute("search", search + " "+recipes.size());
	 * 
	 * model.addAttribute("items", recipes); CookbookManager.getDefaults(model,
	 * "searchClass");
	 * 
	 * return "search";
	 * 
	 * }
	 */
	/*
	 * Listar Receitas - Retorna lista de receitas ordenadas.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes")
	public String listRecipes(Model model) {
		/*
		 * List<String> values = new ArrayList<String>(); values.add("Ola");
		 * values.add("Mundo"); model.addAttribute("items", values);
		 */
		//List<Recipe> recipes = new ArrayList<Recipe>(
			//	CookbookManager.getInstance().);

		List<RecipeVersion> recipes = new ArrayList<RecipeVersion>(
				CookbookManager.getInstance().getRecipeVersionSet());
		List<RecipeVersion> recipeLastV = new ArrayList<RecipeVersion>();
		
		for (int i=0;i<recipes.size();i++){
			recipeLastV.add(recipes.get(i).getRecipeLast().getLastVersion());
		}
		
		
		
		//recipeLastV.get(0).getRecipe().getExternalId(); 
		Collections.sort(recipeLastV);

		model.addAttribute("items", recipeLastV);
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
		RecipeVersion ultimaVersao = receita.getLastVersion();
		
		if (ultimaVersao != null) {
			model.addAttribute("items", ultimaVersao);
			List<Tag> lista = new ArrayList<Tag>(CookbookManager.getInstance().getTagSet());
			model.addAttribute("class", lista);
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
			String solucao, String autor, String classificacoes) {

		CookbookManager.getDefaults(model, "CreateRecipe");

		Recipe criar = new Recipe(titulo, problema, solucao,
				autor, classificacoes);
		
		
		// model.addAttribute("chave",Data.putReceita(criar));
		// Tags tag = new Tags(classificacoes, criar);
		return "redirect:/recipes/" + criar.getExternalId();

		 //return "sucessDelRecipe";
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
		/*	
		Set<Recipe> recipesS = CookbookManager.getInstance().;

		model.addAttribute("items", recipes);
		// Comuns
		CookbookManager.getDefaults(model, "manageRecipes");
		// Fim Comuns*/
		
		List<RecipeVersion> recipes = new ArrayList<RecipeVersion>(
				CookbookManager.getInstance().getRecipeVersionSet());
		List<RecipeVersion> recipeLastV = new ArrayList<RecipeVersion>();
		
		for (int i=0;i<recipes.size();i++){
			recipeLastV.add(recipes.get(i).getRecipeLast().getLastVersion());
		}
				
		//recipeLastV.get(0).getRecipe().getExternalId(); 
		Collections.sort(recipeLastV);

		model.addAttribute("items", recipeLastV);
		// Comuns
		CookbookManager.getDefaults(model, "recipes");
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
		
		RecipeVersion receitaAlterar = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);
		//RecipeVersion ultimaVersao = receita.getLastVersion();
		
		
		if (receitaAlterar != null) {
			model.addAttribute("items", receitaAlterar);
			return "editRecipe";
		} else {
			return "recipeNotFound";
		}
	}
	

	/*
	 * Criar objeto Receita ,guardar e reencaminhar para mostragem.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/manageRecipes/editRecipe")
	public String editRecipe(Model model, String titulo, String problema,
			String solucao, String autor, String classificacoes) {

		CookbookManager.getDefaults(model, "CreateRecipe");

		Recipe criar = new Recipe(titulo, problema, solucao,
				autor, classificacoes);
		
		
		// model.addAttribute("chave",Data.putReceita(criar));
		// Tags tag = new Tags(classificacoes, criar);
		return "redirect://recipes/" + criar.getExternalId();

		 //return "sucessDelRecipe";
	}


/*
 * retornar objeto a editar e reencaminhar para vista de edição.
 */
/*
 @RequestMapping(method = RequestMethod.GET, value =
  "/manageRecipes/del/{id}") public String delRecipe(Model model, @PathVariable
  String id) {
  
  // Comuns CookbookManager.getDefaults(model, ""); // Fim Comuns RecipeVersion
  receita = AbstractDomainObject.fromExternalId(id);// Data.getReceita(id);
  
  if (receita != null) { receita.delete();
  CookbookManager.getInstance().removeRecipe(receita);
  model.addAttribute("items", receita); return "sucessDelRecipe"; } else {
  return "recipeNotFound"; } }
  
 */ 
 }