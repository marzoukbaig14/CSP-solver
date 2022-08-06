// This is an abstract class for implementing a constraint 
// Can deal with bianry constraints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Constraint {
    
    Variable x;
    Variable y;

    abstract boolean checkConsistency(Object value, Constraint a, Variable variable, 
                                        HashMap<Variable, Object> assignments, CSP csp);

    
}
