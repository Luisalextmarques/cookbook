package pt.ulht.es.cookbook.domain;

public class RecipeVersionOrdenacao extends RecipeVersion_Base implements Comparable<RecipeVersionOrdenacao> {

	public int compareTo(RecipeVersionOrdenacao o) {
		// TODO Auto-generated method stub
		if (this.getOid()>o.getOid())
			return -1;
		else if (this.getOid()<o.getOid())
			return 1;
			
		return 0;
	}

}
