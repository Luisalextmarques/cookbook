package pt.ulht.es.cookbook.domain;


public class Tag extends Tag_Base {
    
	/**
	 * Construtor TAG
	 * @param tag
	 */
    public  Tag(String tag) {    
    	setTag(tag);
    	setCookbookManager(CookbookManager.getInstance());
      
        
    }
    
    /**
     * Apagar Tags, eliminar ligação as versoes
     */
    public void delete() {
    	setCookbookManager(null);    
		for (RecipeVersion rc :getRecipeVersionSet()){
			removeRecipeVersion(rc);	
		}
		deleteDomainObject();
    	
    }
    
}
