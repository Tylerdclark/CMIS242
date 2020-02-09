public class Hybrid extends Automobile {
    private int milesPerGallon;

    public Hybrid(String make, String model, int purchasePrice, int milesPerGallon) {
        super(make, model, purchasePrice);
        this.milesPerGallon = milesPerGallon;
    }
    /*  The sales tax for a hybrid automobile consists of the base sales tax of 5% minus a discount.
    *   If the number of miles per gallon is less than 40, the discount is $100. Otherwise there is an 
    *   additional discount of $2 for every mile per gallon in excess of 40.
    */
    public float salesTax(){
        float tax = (this.purchasePrice * (5 / 100.00f));
        //reading between the lines here and making it less than/equal to, otherwise 40 MPG is gray area
        if (this.milesPerGallon <= 40) {
            tax = tax - 100;
        } else {
            tax = tax - 100;
            //using the automobile object mpg as loop var, decrement tax x2 for every mpg over 40
            for (int tempMph = this.milesPerGallon; tempMph > 40; tempMph-- ) {
                tax = tax - 2;
            }
        }
        return tax;
    }   
    //overriden toString method
    public String toString() {
        String salesTax = String.format("%.02f", this.salesTax());
        return "Make and Model: "+ this.make + " " + this.model +
        "\nSales Price: "+ this.purchasePrice +
        "\nSales Tax: "+ salesTax + "\nMPG: " + this.milesPerGallon;
    }
}