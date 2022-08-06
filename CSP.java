import java.util.*;


public class CSP {
    public CSP(ArrayList<Variable> vars, Set<Constraint> cons) {
		super();
		this.vars = vars;
		this.cons = cons;
		for(Variable i: vars) {
			unassignedVar.add(i); 
		}
		
	}

	ArrayList<Variable> vars= new ArrayList<Variable>();

	Set<Constraint> cons=new HashSet<Constraint>();

	HashMap<Variable,String> asgnmts= new HashMap<Variable,String>();

	ArrayList<Variable> unassignedVar=new ArrayList<Variable>();
    
	ArrayList<Arcs> arcs=new ArrayList<Arcs>();
}
