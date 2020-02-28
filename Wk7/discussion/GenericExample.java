package Wk7.discussion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class GenericExample {
	
    public static void main(String[] args) {
    	
    	// notice the second diamond is empty, so it is using "type inference"
    	// AKA inferring what the types are by looking at the left side of the statement
    	Map<Integer, String> aMap = new HashMap<>();
    	
    	aMap.put(1, "one");
    	aMap.put(2, "two");
    	aMap.put(3, "three");
    	//with generics, the commented code below will not allow the program to compile
    	//aMap.put("four", 4); 
       
    	//iterate the hash map
    	Iterator anIterator   = aMap.keySet().iterator();
    	
    	while (anIterator.hasNext()) {
    		  Object aKey   = anIterator.next();
    		  Object  aValue = aMap.get(aKey);
    		  System.out.println(aValue);
    	}
    	
    }
}
