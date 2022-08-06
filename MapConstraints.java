import java.util.HashMap;

public class MapConstraints extends Constraint {

	public MapConstraints(Variable x, Variable y) {
		super.x = x;
		super.y = x;
	}

	@Override
	boolean checkConsistency(Object value, Constraint c, Variable var, HashMap<Variable, Object> asgnmts, CSP csp) {
		if((c.x.equals(var)) && (!asgnmts.containsKey(c.y))) 
			return true;
            
	    else if ((c.x.equals(var)) && (asgnmts.containsKey(c.y))) {
		    if(!asgnmts.get(c.y).equals(value)) {
			    return true;
		    }
            else {
			    return false;
		    }
	    }
        else if ((c.y.equals(var)) && (!asgnmts.containsKey(c.x))) {
		    return true;
	    }
        else if ((c.y.equals(var)) && (asgnmts.containsKey(c.x))) {
		
            if(!asgnmts.get(c.x).equals(value)) 
			    return true;
		    else 
			    return false;
		
	    }
        else if(!c.x.equals(var) && !c.y.equals(var)) {
		    return true;
	    }
        else {
		    return false;
	}
	}
	

}