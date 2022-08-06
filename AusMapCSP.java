// This class deals with the australia map csp from AIMA 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class AusMapCSP {


    public static Assignments AusMapCSP() {

        ArrayList<Variable> vars = new ArrayList<Variable>();
        ArrayList<Object> doms = new ArrayList<Object>();

        Set<Constraint> cons = new HashSet<Constraint>();

        Assignments asgnmts = new Assignments();

        CSP csp = new CSP(vars, cons);

        doms.add("red");
        doms.add("green");
        doms.add("blue");

        Variable WA = new Variable("West AUstralia", doms);
        Variable V = new Variable("Victoria", doms);
        Variable NSW = new Variable("New South Wales", doms);
        Variable T = new Variable("Tasmania", doms);
        Variable Q = new Variable("Queensland", doms);
        Variable SA = new Variable("SOuthern Australia", doms);
        Variable NT = new Variable("Northern Teritory", doms);

        csp.vars.add(WA);
        csp.vars.add(V);
        csp.vars.add(NSW);
        csp.vars.add(T);
        csp.vars.add(Q);
        csp.vars.add(SA);
        csp.vars.add(NT);

        csp.cons.add(new MapConstraints(SA,WA));
		csp.cons.add(new MapConstraints(SA,NT));
		csp.cons.add(new MapConstraints(SA,Q));
		csp.cons.add(new MapConstraints(SA,NSW));
		csp.cons.add(new MapConstraints(SA,V));
		csp.cons.add(new MapConstraints(WA,NT));
		csp.cons.add(new MapConstraints(NT,Q));
		csp.cons.add(new MapConstraints(Q,NSW));
		csp.cons.add(new MapConstraints(NSW,V));

        System.out.println("Variables:\t");

        for (Variable i: csp.vars) {
            System.out.println(i.domainValue + "\t");

        }
        System.out.println("\n");
        System.out.println("Domain:\t");
        for (Object i: doms) {
            System.out.println(i + "\t");
        }
        System.out.println("\n");
        System.out.println("Constraints");
        for (Constraint i: csp.cons) {
            System.out.println("["  + i.x.domainValue + ", " + i.y.domainValue + "]" + "  ");

        }
        System.out.println("\n\n");
        System.out.println("The solution to this CSP is: ");

        BackTracking backTrack = new BackTracking();
        Assignments ass = new Assignments();
        asgnmts = backTrack.doBackTracking(ass, csp);
        return asgnmts;

    


    }
    
}
