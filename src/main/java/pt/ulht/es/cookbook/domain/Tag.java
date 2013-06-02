package pt.ulht.es.cookbook.domain;


public class Tag extends Tag_Base {
    
    public  Tag(String tag) {    
    	setTag(tag);
    	setCookbookManager(CookbookManager.getInstance());
      
        
    }
    
    public void delete() {
    	setTag(null);
    	super.deleteDomainObject();
    }
    
}
