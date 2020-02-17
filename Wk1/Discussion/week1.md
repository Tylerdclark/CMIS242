# Week 1 Discussion - Class variables and methods

## Explain how class (static) variables and methods differ from their instance counterparts

Static variables are shared among all the instances of the class, whereas an instance variable must have it’s object created. Thanks to this rule, you can access the static variable directly instead of: object.StaticVariable. Static methods, like static variables, belong to the class and as such do not need an object. Static methods access static variables and **not** non-static variables.

## Give an example of a class that contains at least one class variable and at least one class method

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

## Explain why using a class variable and method rather than an instance variable and method would be the correct choice in the example you select

Many times, you might want variables or methods without instantiating an object first. Counters, for instance might be shared within a class and using static keyword would be prudent (It might be more useful if you had objects being creating and you wanted a total count of how many made). We can then use a static method change the static data. We are all familiar with at least one static method, main! It can be called without and before any other objects are made. Another notable example are methods from the Math class, like Math.PI.
