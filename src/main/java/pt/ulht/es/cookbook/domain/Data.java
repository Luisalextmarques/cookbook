package pt.ulht.es.cookbook.domain;

import java.util.HashMap;

public class Data {
	private static HashMap<String, Recipe> hashReceitas = new HashMap<String, Recipe>();
	private static int key = 0;
	
	public static HashMap<String, Recipe> getHashReceitas() {
		return hashReceitas;
	}
		
	public static Recipe getReceita(String search){
		return Data.hashReceitas.get(search);
	}
	
	
	public static String putReceita(Recipe receita ){
		String keystr = Data.key++ + "";
		Data.hashReceitas.put(keystr, receita);
		return keystr;
	}

}
