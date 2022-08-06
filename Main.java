import java.util.*;

import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Assignments solution = new Assignments();
        AusMapCSP amp = new AusMapCSP();

        System.out.println("Solving the Australia Map CSP ...");
        solution = amp.AusMapCSP();

        if (solution == null) {
            System.out.println("There is no splution to this csp");
        }
        else {
            printMap(solution.Map);
        }
    }

    
}
