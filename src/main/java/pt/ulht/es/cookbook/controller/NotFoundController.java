package pt.ulht.es.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ulht.es.cookbook.domain.CookbookManager;

@Controller
public class NotFoundController {

    @RequestMapping(method=RequestMethod.GET, value="/*")
    public String handlePageNotFound(Model model) {

    	CookbookManager.getDefaults(model,"");
		
        return "pageNotFound";
    }
    
}
