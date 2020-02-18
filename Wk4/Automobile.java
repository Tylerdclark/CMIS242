/* 
* File Name: Automobile.java
* Author: Tyler D Clark
* Date: 9 Feb 2020
* Purpose: Base class for the car objects. Electric and Hybrid inherit from this
*/
class Automobile {
    //protected for style points
    protected String makeAndModel;
    protected int purchasePrice;

    //plain jane constructor
    public Automobile(String makeAndModel, int purchasePrice) {
        this.makeAndModel = makeAndModel;
        this.purchasePrice = purchasePrice;
    }
    // 5 percent sales tax
    public float salesTax(){
        float tax = (this.purchasePrice * (5 / 100.00f));
        return tax;
    }
    // using string format method to get sales tax to two decimals
    public String toString() {
        String salesTax = String.format("%.02f", this.salesTax());
        return "Make and Model: "+ this.makeAndModel +
        "\nSales Price: "+ this.purchasePrice +
        "\nSales Tax: "+ salesTax + "\n\n";  
    }
}
