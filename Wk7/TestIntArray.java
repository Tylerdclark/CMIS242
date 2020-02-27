package Wk7;

//TestIntArray.java
class TestIntArray {
 public static void main(String[] args)  {
    IntArray array = new IntArray();
    for (int i = 0; i < 6; i++) 
       array.add(2*i);
    System.out.println("Array populated: ");  
    array.display();
    array.remove(3); 
    System.out.println("\n\nElement removed at index 3 : ");  
    array.display();
    array.insert(2, 57); 
    array.set(5, 81);
    System.out.println("\n\n57 inserted at index 2 " + 
                       "and 81 set at index 5: "); 
    array.display();
 }
}
