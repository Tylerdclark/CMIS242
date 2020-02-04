class Automobile {
    String make;
    String model;
    int purchasePrice;

    //plain jane constructor
    public Automobile(String make, int purchasePrice) {
        this.make = make;
        this.purchasePrice = purchasePrice;
    }
    //crreating a salesTax method using type casting
    public float salesTax(){
        float tax = (this.purchasePrice * (5 / 100.0f));
        return tax;
    }
    /* A toString method that returns a string containing the
make and model of the automobile, the sales price, and the
sales tax, appropriately labeled.
    *
    */
    public String toString() {

        return "Make and Model :"+ this.make;  
    }
}
