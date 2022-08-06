import java.util.*;
import java.util.Map.Entry;

import javax.swing.SpringLayout.Constraints;


public class BackTracking {
	
	HashMap<Variable,String> a=new HashMap<Variable,String>();
	
	public Assignments getBackTrack(CSP csp) {
		return doBackTracking(new Assignments(),csp);
		
	}
	
	
	public Assignments doBackTracking(Assignments assignments,CSP csp) {

		int numCons = 0;
        
		Assignments solution = new Assignments();
		if(Completed(assignments.Map,csp)==true) {
			
			return assignments;
		}else {
			csp.unassignedVar=Assigned(assignments.Map,csp);
			Variable var= csp.unassignedVar.get(0);
			for(Object i:var.domains) {
				numCons=0;
				long start = new Date().getTime();
				for(Constraint x: csp.cons) {
					if(x.checkConsistency(i,x,var,assignments.Map,csp)) {
						numCons++;
					}else {
						numCons=0;
					}
					
				}
				long end = new Date().getTime();
				if(numCons==csp.cons.size()) {
					assignments.Map.put(var, i);
					solution = doBackTracking(assignments,csp);
					if(!(solution == null)) {
						return solution ; 
					}else {
						assignments.Map.remove(var,i);		
				}
					
				}
			}
		}
			return null;		
	}

    
	
	
	public static boolean Completed(HashMap<Variable,Object> assignments,CSP csp) {
		ArrayList<Variable> v=Assigned(assignments,csp);
			if(v.size()==0) {
				return true;
			}else {
				return false;
			}
			
		}
	
	public static ArrayList<Variable> Assigned(HashMap<Variable,Object> assignments, CSP csp) {
		
        ArrayList<Variable> s=new ArrayList<Variable>();
		
        boolean check=true;
			for (Variable y: csp.vars) {
				
                check=true;

				for(Variable x: assignments.keySet()) {
					
                    if(y.equals(x)) {
					check=false;	
					}
				}
				if(check==true) {
					s.add(y);
				}
			}
			return s;
		
	}
    public static void printMap(HashMap<Variable,Object> assignments) {
		for (Entry<Variable, Object> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("Variable: "+key.domainValue+" "+"Value: "+value);
		}
	}
	
	
	
    }
	
