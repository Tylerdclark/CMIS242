# Week 2 Discussion - The super keyword

## What does the super keyword represents and where can it be used?

The super keyword is a reference variable which is a tool of inheritance. Super becomes super useful when trying to inherit things from the parent class. It can be used on things like variables, methods, and even constructors.

## Give an example of a superclass and subclass. Be sure to make all the instances variables of the super class private. Include at least one constructor in each class and ensure that the constructor of the subclass calls the constructor of the superclass. Also include a toString method in both classes that returns the values of the instance variables with appropriate labels. Ensure that the toString method of subclass calls the toString method of the superclass so that the string returned contains the values of all the inherited instance variables

 Below is an overly commented code example. I love RPGs so I made it kind of like how I would code one if I was making items. A base item class which is inherited by weapons. There could also be armor classes which inherit from item and likewise each class could have more specialized classes that inherit (Swords and maces inherit from weapon, helmet and shield inherit from armor)

    //driver to test out objects created
    public class Main {
        public static void main(String[] args) {
            //new parent class object
            Item i = new Item(1,1);
            //new child object
            Weapon w = new Weapon(5, 10, 5);
            System.out.println(i.toString());
            System.out.println(w.toString());
        }
    }
    //parent class, weapon will inherit weight and cost
    class Item {
        private int weight;
        private int cost;

        //just one constructor
        public Item(int w, int c){
            this.weight = w;
            this.cost = c;
        }
        /** to string method can be called by parent and child
        if child doesn't override this, it will only display weight and cost */
        public String toString(){
        return "This "+getClass().getSimpleName()+" has:\nweight of "+weight+"\ncost of "+cost+"\n";
        }

    } //end item class
    //child class adds damage variable
    class Weapon extends Item {
        private int damage;

        //using super keyword to reference parent variables weight and cost
        public Weapon(int w, int c, int d){
            super(w, c);
            this.damage = d;
        }
        //overriding parent toString method
        public String toString(){
            return super.toString() + "damage of "+ damage;
        }
    }
