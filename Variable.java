// This class creates an object called variable
// The variables has an array list which is the domain of the possible assignments

import java.util.ArrayList;

public class Variable {
    
    Object domainValue;

    ArrayList<Object> domains = new ArrayList<Object>();


    // COnstructor for domain takes the specific domain value which could be of any type and an array list of domains
    Variable(Object domainValue, ArrayList<Object> domains) {
        this.domainValue = domainValue;
        this.domains = domains;
    }

}

