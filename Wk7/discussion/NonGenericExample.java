package wk7.discussion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class NonGenericExample {
	
    public static void main(String[] args) {
    	
    	Map aMap = new HashMap();
    	
    	aMap.put(1, "one");
    	aMap.put(2, "two");
    	aMap.put(3, "three");
    	//wonky stuff like this can happen w/o generics:
    	aMap.put("four", 4); 
       
    	//iterate the hash map
    	Iterator anIterator   = aMap.keySet().iterator();
    	
    	while (anIterator.hasNext()) {
    		  Object aKey   = anIterator.next();
    		  Object  aValue = aMap.get(aKey);
    		  System.out.println(aValue);
    	}
    	
    }
}