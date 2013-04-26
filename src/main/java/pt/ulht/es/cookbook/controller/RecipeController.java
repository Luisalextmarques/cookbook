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
      		String css = Comuns.getCss();
      		String autor = Comuns.getAutor();
      		String titulo = Comuns.getTitulo();
              model.addAttribute("css", css);
              model.addAttribute("autor",autor);
              model.addAttribute("titulo", titulo);
      	  
              
        return "listRecipes";
    }

    @RequestMapping(method=RequestMethod.GET, value="/createRecipe")
    public String createRecipes(Model model) {
        
      //Comuns
      		String css = Comuns.getCss();
      		String autor = Comuns.getAutor();
      		String titulo = Comuns.getTitulo();
              model.addAttribute("css", css);
              model.addAttribute("autor",autor);
              model.addAttribute("titulo", titulo);
              
        return "createRecipe";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {
    	//Comuns
		String css = Comuns.getCss();
		String autor = Comuns.getAutor();
		String titulo = Comuns.getTitulo();
        model.addAttribute("css", css);
        model.addAttribute("autor",autor);
        model.addAttribute("titulo", titulo);
	  
    	        
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
 String createRecipe(Model model, String titulo, String problema ,String solucao, String autor) {
     
    	String cssSite = Comuns.getCss();
		String autorSite = Comuns.getAutor();
		String tituloSite = Comuns.getTitulo();
        model.addAttribute("css", cssSite);
        model.addAttribute("autor",autorSite);
        model.addAttribute("titulo", tituloSite);
        
        model.addAttribute("xoxa", titulo);
    	
        Recipe criar = new Recipe(titulo, problema, solucao, autor);
        
        
        
    	return "sucessRecipe";
    }
    
        
}