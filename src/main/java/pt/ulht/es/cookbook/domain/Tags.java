package pt.ulht.es.cookbook.domain;

public class Tags extends Tags_Base {
    
    public  Tags(String tags, Recipe recipe) {
        
        setRecipe(recipe);
        setTag(tags);
        
        
    }
    
}
