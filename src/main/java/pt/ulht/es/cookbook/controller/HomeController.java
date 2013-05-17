package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.Date;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ulht.es.cookbook.domain.CookbookManager;

@Controller
public class HomeController {
  
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String showHome(Model model) {
		CookbookManager.getDefaults(model,"home");
		
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));

  	  
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/aboutUs")
	public String showAboutUs(Model model) {

		CookbookManager.getDefaults(model,"aboutUs");

        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));
        
		return "aboutUs";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute("search")	String search, BindingResult result,Model model) {

		CookbookManager.getDefaults(model,"searchClass");

		model.addAttribute("search", search);
		return "search";
}

}