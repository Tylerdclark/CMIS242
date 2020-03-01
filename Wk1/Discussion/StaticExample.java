package wk1.discussion;

/* This is my submission to 
** show the use of the static
** modifier. It is very simple
** and over commented
*/

public class StaticExample {
  
  // There can be only one...
  static int counter = 0;
  
  //non-static methods cannot interact w/ static vars
  void increaseCounter() {
    StaticExample.counter += 1;
  }
  // Static methods interact with static vars
  static void staticIncreaseCounter() {
    StaticExample.counter += 1;
  }
  
  public static void main(String[] args) {
  System.out.println(counter);
  
  //Un-commenting below will cause error
  //increaseCounter();
  
  //static methods can be called without an object
  staticIncreaseCounter();
  System.out.println(counter);
  }
}