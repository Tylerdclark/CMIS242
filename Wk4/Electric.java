public class Electric extends Automobile{
    private int weight;

    public Electric(String make, String model, int purchasePrice, int weight) {
        super(make, model, purchasePrice);
        this.weight = weight;

    }
    /*  The sales tax for an electric automobile consists of the base sales tax of 5% that applies 
    *   to all automobiles minus a discount. If the weight is less than 3000 pounds the discount 
    *   is $200. Otherwise it is $150.
    */
    public float salesTax(){
        float tax = (this.purchasePrice * (5 / 100.00f));
        if (this.weight < 3000) {
            tax = tax - 200;
        } else {
            tax = tax - 150;
        }
        return tax;
    }
    // Overrriden toString method
    public String toString() {
        String salesTax = String.format("%.02f", this.salesTax());
        return "Make and Model: "+ this.make + " " + this.model +
        "\nSales Price: "+ this.purchasePrice +
        "\nSales Tax: "+ salesTax + "\nWeight " + this.weight + "\n";  
    }    
}