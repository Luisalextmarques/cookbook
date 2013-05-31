package pt.ulht.es.cookbook.domain;

public class Tag extends Tag_Base {
    
    public  Tag(String tag) {    
    	setTag(tag);
      
        
    }
    
    public void delete() {
    	setRecipe(null);
    	super.deleteDomainObject();
    }
    
}
