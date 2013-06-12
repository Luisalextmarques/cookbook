package pt.ulht.es.cookbook.domain;


public class Tag extends Tag_Base {
    
    public  Tag(String tag) {    
    	setTag(tag);
    	setCookbookManager(CookbookManager.getInstance());
      
        
    }
    
    public void delete() {
    	setCookbookManager(null);    
		for (RecipeVersion rc :getRecipeVersionSet()){
			removeRecipeVersion(rc);	
		}
		deleteDomainObject();
    	
    }
    
}
