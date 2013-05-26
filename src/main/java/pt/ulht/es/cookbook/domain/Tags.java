package pt.ulht.es.cookbook.domain;

public class Tags extends Tags_Base {
    
    public  Tags(String tags) {    
    	setTag(tags);
      
        
    }
    
    public void delete() {
    	setRecipe(null);
    	super.deleteDomainObject();
    }
    
}
