package pt.ulht.es.cookbook.domain;

public class Recipe {
 public Recipe(String titulo, String problema, String solucao, String autor) {
		super();
		this.titulo = titulo;
		this.problema = problema;
		this.solucao = solucao;
		this.autor = autor;
	}

private String titulo, problema, solucao, autor;

 
public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getProblema() {
	return problema;
}

public void setProblema(String problema) {
	this.problema = problema;
}

public String getSolucao() {
	return solucao;
}

public void setSolucao(String solucao) {
	this.solucao = solucao;
}

public String getAutor() {
	return autor;
}

public void setAutor(String autor) {
	this.autor = autor;
}
}
