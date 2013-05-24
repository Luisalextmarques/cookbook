package pt.ulht.es.cookbook.domain;

import org.springframework.ui.Model;

import pt.ist.fenixframework.FenixFramework;

public class CookbookManager extends CookbookManager_Base {
	private static String autor ="Projeto ES - Bruno Sousa / Luís Marques";
	private static String titulo ="CookBook";
	private static String css =  "<link href='/static/style.css' rel='stylesheet' type='text/css' media='screen' />";
	
	
	public static String getAutor() {
		return autor;
	}
	public static String getTitulo() {
		return titulo;
	}
	public static String getCss() {
		return css;
	}
	
	public static String getMenu(String strOpcao, String search){
		String strMenuHtml ="";
		//class='current_page_item'
		strMenuHtml = "<li class='home'><a href='/'>Home</a></li>" + "\n";
		strMenuHtml= strMenuHtml + "<li class='createRecipe'><a href='/createRecipe'>Create Recipe</a></li>"	+ "\n";	
		strMenuHtml= strMenuHtml + "<li class='recipes'><a href='/recipes'>List Recipes</a></li>"		+ "\n";
		strMenuHtml= strMenuHtml + "<li class='manageRecipes'><a href='/manageRecipes'>Manage Recipes</a></li>"+ "\n"	;
		strMenuHtml= strMenuHtml + "<li class='aboutUs'><a href='/aboutUs'>About Us</a></li>"		+ "\n"	;
		//Se tiver opção preenchida selecionar como ativa.
		strMenuHtml= strMenuHtml + "<li class='searchClass'><div id='search' >"		+ "\n";
		if (!strOpcao.equals(""))
			strMenuHtml = strMenuHtml.replace("class='"+strOpcao+"'", "class='current_page_item'");
		strMenuHtml= strMenuHtml + "	<form method='post' action='search'>"		+ "\n";
		strMenuHtml= strMenuHtml + "		<input name='search' id ='search-text' value ='" + search + "'></input>"	+ "\n";
		strMenuHtml= strMenuHtml + "		<input type='submit'  value='Search' id ='search-submit'/>"		+ "\n"	;
		strMenuHtml= strMenuHtml + "	</form>"		+ "\n"	;
		strMenuHtml= strMenuHtml + "	</div>"		+ "\n"	;
		strMenuHtml= strMenuHtml + "</li>"		+ "\n"	;
		
		
		return strMenuHtml;
		
	}
	
	
	/**
	 * Função para Preparar Carregamentos predefinidos como o estilo, menu, titulo do site e autores.
	 * @param model
	 * @param menuSelecionado
	 */
	public static void getDefaults(Model model, String menuSelecionado){
        //Comuns
		String css = CookbookManager.getCss();
		String autor = CookbookManager.getAutor();
		String titulo = CookbookManager.getTitulo();
		String menu = CookbookManager.getMenu(menuSelecionado,"");
        model.addAttribute("css", css);
        model.addAttribute("autor",autor);
        model.addAttribute("titulo", titulo);
        model.addAttribute("menu", menu);
        
        //Fim Comuns
	}
	
	public static CookbookManager getInstance() {
		return FenixFramework.getRoot();
	}
}
