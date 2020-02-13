# Week 5 Discussion post

## What do think is meant by programming to an interface"?"

Programming to an interface, as I understand it, is a programming technique. When programming to an interface, what your code does is more important than how it is done. You can have methods stubs that are meant for losely-specific behavior. It allows an increased level of flexibilty in use and adaptibility over time.

## What are some differences between Abstract Classes and Interfaces"?"

A common comparison is that an interface is a sort of contract (and we have said this in class). An interface has empty methods which point the direction in which the programming should be doing, but not necessaily assigning the specifics of the behavior. Abstract classes take it a bit forward and can proivide some of that specific behavior and functionality.

Each one has its benefits and limitations:

* Interfaces cannot have data members (well, actually just constants) while abstract classes can

* Interfaces can have method stubs (and deafult methods with java 8), while abstract classes can have defined methods and methods stubs

* Interfaces can be implemented many times, while abstract classes can only be extended by a class once.
  
* Interface methods are implicitly public abstract, while abstract methods can be any visibility other than private (if they were private, how could they be inherited?)

Code example :

    interface media {
        //play must be implemented by classes that implement media
        public void play();
        }
    interface sound{
        //same goes for sound
        public void propogateNoise();
    }

    //multiple inteferfaces can be implemented
    public class music implements media, sound{

        @Override
        public void play(){
            System.out.println("I'm playing music");
        }
        @Override
        public void propogateNoise() {
            System.out.println("I'm vibrating air!");
        }

        public static void main(String[] args) {

            music m = new music();
            m.play();
            m.propogateNoise();
        }
    }
