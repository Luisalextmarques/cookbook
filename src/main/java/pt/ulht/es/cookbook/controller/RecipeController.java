package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ulht.es.cookbook.domain.Comuns;
import pt.ulht.es.cookbook.domain.Recipe;

@Controller
public class RecipeController {
  
    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {

        List<String> values = new ArrayList<String>();
        values.add("Ola");
        values.add("Mundo");        
        model.addAttribute("items", values);
        
        //Comuns
        Comuns.getDefaults(model,"recipes");
        //Fim Comuns
      	  
              
        return "listRecipes";
    }

    @RequestMapping(method=RequestMethod.GET, value="/createRecipe")
    public String createRecipes(Model model) {
        
      //Comuns
    	Comuns.getDefaults(model,"createRecipe");
              
        return "createRecipe";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {

        //Comuns
    	Comuns.getDefaults(model,"");
        //Fim Comuns
	  
    	        
        List<String> values = new ArrayList<String>();
        values.add("Ola"+id);
        values.add("Mundo"+id);        
        model.addAttribute("items", values);
        if(id.equals("42")) {
        	return "detailedRecipe";
		} else {
			return "recipeNotFound";
		}
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/createRecipe")
    public String createRecipe(Model model, String titulo, String problema ,String solucao, String autor) {
     
    	Comuns.getDefaults(model,"CreateRecipe");
        
        model.addAttribute("xoxa", titulo);
    	
        Recipe criar = new Recipe(titulo, problema, solucao, autor);
        
        
        
    	return "sucessRecipe";
    }
    
        
}