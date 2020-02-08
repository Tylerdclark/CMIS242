class Automobile {
    String make;
    String model;
    int purchasePrice;

    //plain jane constructor
    public Automobile(String make, int purchasePrice) {
        this.make = make;
        this.purchasePrice = purchasePrice;
    }
    // 5 percent sales tax
    public float salesTax(){
        float tax = (this.purchasePrice * (5 / 100.00f));
        return tax;
    }
    // using string format method to get salestax to two decimals
    public String toString() {
        String salesTax = String.format("%.02f", this.salesTax());
        return "Make and Model: "+ this.make +
        "\nSales Price: "+ this.purchasePrice +
        "\nSales Tax: "+ salesTax;  
    }
    public static void main(String[] args) {
        Automobile a = new Automobile("Honda", 100);
        System.out.println(a);
    }
}
