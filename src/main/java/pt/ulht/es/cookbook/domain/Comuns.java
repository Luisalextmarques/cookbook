package pt.ulht.es.cookbook.domain;

public class Comuns {
	private static String autor ="Projeto ES - Bruno Sousa / Luís Marques";
	private static String titulo ="CockBook";
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

	
	
}
