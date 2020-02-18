# Week 6 Discussion – Writing recursive methods

## Provide a recursive definition of some sequence of numbers or function (e.g. log, exponent, polynomial)

Recursion is one of my favorite topics. To me, it feels like magic in code. Recursion is essentially calling a method or function on itself until a base case is met. One consideration with recursion is that it must be implemented in a way to avoid infinite recursion.

### Write a recursive method that given n, computes the nth term of that sequence

The following code method sumNum() returns the total of n and every number below it (n + (n - 1) + (n - 2), etc.)

    public class RecursionExample {
        public static void main(String[] args) {
            System.out.println(sumNum(10));
        }

        public static int sumNum(int n) {
            if ( n < 0) {
                System.out.print("This number will cause infinite recursion!: ");
                return n;
            // this if statement breaks out of the recursion    
            }if (n == 1) {
                return n;
            // the method itself is being called on the number sub one    
            }else {
                return (n + sumNum(n - 1));
            }
        }
    }

As you can see in the first line of the method body, some careful planning must be made to avoid infinite recursion. If negative numbers were allowed, it would continue to call itself on lower and lower values of n -1.  That would result in stack overflow, where there would be no more room on the stack for method calls. If curious, comment out the first if statement in the code above and see what happens.

### Also provide an equivalent iterative implementation. How do the two implementations compare?

Who would win? Recursion or a for loop?

    public class IterativeExample {
        public static void main(String[] args) {
            System.out.println(sumNum(10));
        }

        public static int sumNum(int n) {
            int total = 0;
            for (int i = n; i > 0; i--){
                total += i;
            }
            return total;
        }
    }

[Any recursive method can be made iterative](https://stackoverflow.com/a/933979), but the key is finding out which is more useful for your intended goal. In my example above, I think it is clear that the for loop is a better mechanism to get the job done. A recursive version would be slower as there would be n method calls, and in general is not as readable. But in some cases, recursion might be more suitable. For instance, if we wanted to do a breadth first search (search every same level node of all branches simultaneously of a tree data structure), it would definitely be prudent to recursively call a method. Furthermore, at least to me, recursion is much "cooler".
