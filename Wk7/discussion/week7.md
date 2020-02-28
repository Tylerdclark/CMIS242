# Week 7

## Give an example of a program that uses the nongeneric version of a class from the Java Collection Framework and the equivalent program that uses the generic version

non-generic:

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

generic:

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

## How do the two implementations differ? Why is having the syntax of generics better?

The non-generic version does not have "type safety" meaning, any value can be put as a key or value. While this may not be an issue in the short scope of my example program, It would definitely cause issues in a larger, more complex program. Generics can even help outside of the Collections api as well. for example, if I had arrays of varying types, if I wanted to have methods to operate on the arrays, instead of writing a method for every array type, I would write a generic array method.

non-generic:

    public class NonGenericDiscussion {

        public static void main(String[] args) {
            
            String[] stringArr = {"one", "two", "three"};
            int[] intArr = {1,2,3};
            float[] floatArr = {1.0f, 2.0f, 3.0f};
            
            printArray(stringArr);
            printArray(intArr);
            printArray(floatArr);

        }
        
        // need a method type for every data type
        public static void printArray(String[] a) {
            for (String i : a) {
                System.out.println(i);
            }
        }
        public static void printArray(int[] a) {
            for (int i : a) {
                System.out.println(i);
            }
        }
        public static void printArray(float[] a) {
            for (float i : a) {
                System.out.println(i);
            }
        }
    }

generic:

    public class GenericDiscussion {

        public static void main(String[] args) {
            
            //notice these need to be class, not primitive types
            String[] stringArr = {"one", "two", "three"};
            Integer[] intArr = {1,2,3};
            Float[] floatArr = {1.0f, 2.0f, 3.0f};
            
            printArray(stringArr);
            printArray(intArr);
            printArray(floatArr);

        }
        
        // only one method with generics!
        public static <E> void printArray(E[] a) {
            for (E i : a) {
                System.out.println(i);
            }
        }
        
    }
