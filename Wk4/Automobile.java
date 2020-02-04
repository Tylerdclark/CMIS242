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
    public int salesTax(){
        int tax = (int) (this.purchasePrice * (5 / 100.0f));
        return tax;
    }
}
