class Automobile {
    //protected for style points
    protected String make;
    protected String model;
    protected int purchasePrice;

    //plain jane constructor
    public Automobile(String make, String model, int purchasePrice) {
        this.make = make;
        this.model = model;
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
        return "Make and Model: "+ this.make + " " + this.model +
        "\nSales Price: "+ this.purchasePrice +
        "\nSales Tax: "+ salesTax + "\n";  
    }
    public static void main(String[] args) {
        Automobile a = new Automobile("Honda", "Civic", 100);
        System.out.println(a);
        Electric e = new Electric("Tesla", "model X", 50000, 2900);
        System.out.println(e);
        Hybrid h = new Hybrid("Toyota", "Prius", 10000, 42);
        System.out.println(h);
    }
}
