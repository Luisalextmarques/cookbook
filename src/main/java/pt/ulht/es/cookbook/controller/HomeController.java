package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.Date;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ulht.es.cookbook.domain.Comuns;


@Controller
public class HomeController {
  
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String showHome(Model model) {

        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));

        //Comuns
		String css = Comuns.getCss();
		String autor = Comuns.getAutor();
		String titulo = Comuns.getTitulo();
        model.addAttribute("css", css);
        model.addAttribute("autor",autor);
        model.addAttribute("titulo", titulo);
	  
		return "home";
	}

}