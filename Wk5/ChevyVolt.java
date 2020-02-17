/**
 * This is a peer's code that I added a default method to in order 
 * to show its uses
 */
interface Car{

    //notice that the public modifier is unnecessary
    //notice that these two methods are bodiless meaning the have no implementation
    void horn();
    
    public void start();

    default void carRadio(){
        System.out.println("doot doot doo *music playing*");
    }
    
    }//end Car interface
    
    public class ChevyVolt implements Car{
    
    //notice the methods are given implementation here// they have bodies
    public void horn(){
    System.out.println("Bop bop bop boppppppppp");
    }
    
    public void start(){
    System.out.println("Vrooom vrooom");
    }

    
    
    public static void main(String[] args){
    ChevyVolt myCV = new ChevyVolt();
    myCV.start();
    myCV.horn();
    myCV.horn();
    myCV.carRadio();
    }//end main
    
    }// end ChevyVolt