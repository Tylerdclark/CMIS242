class Main {
  
  // There can be only one...
  static int counter = 0;
  
  //non-static methods cannot interact w/ static vars
  void increaseCounter() {
    Main.counter += 1;
  }
  // Static methods interact with static vars
  static void staticIncreaseCounter() {
    Main.counter += 1;
  }
  
  public static void main(String[] args) {
  System.out.println(counter);
  
  //Uncommenting below will cause error
  //increaseCounter();
  
  //static methods can be called without an object
  staticIncreaseCounter();
  System.out.println(counter);
  }
}