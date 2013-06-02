package pt.ulht.es.cookbook.domain;

import org.apache.taglibs.standard.tag.el.core.SetTag;

public class Tag extends Tag_Base {
    
    public  Tag(String tag) {    
    	setTag(tag);
      
        
    }
    
    public void delete() {
    	setTag(null);
    	super.deleteDomainObject();
    }
    
}
