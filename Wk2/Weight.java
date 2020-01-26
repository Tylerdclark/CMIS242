class Weight{
  private int pounds;
  private double ounces;
  private static final double CONSTANT = 16.000;

  //constructor to hold lbs and oz
  public Weight(int lb, double oz){
    this.pounds = lb;
    this.ounces = oz;
  }
  /* Returns true if the weight object is less
  ** than the one passed as an arg
  */
  public boolean lessThan(Weight w){
    if (this.toOunces() < w.toOunces()) {
      return true;
    } else {
      return false;
    }
  }
  /*
   ** adds the weight arg to the weight obj on which it is called, then calls
   * normalize
   */
  public void addTo(Weight w){
    this.pounds += w.pounds;
    this.ounces += w.ounces; 
    this.normalize();
  }
  /*
  ** takes an int and divides the toOunces values by it before assigning it 
  ** to the object and then normalizes it
  */
  public void divide(int divisor){
    double dividedOz = this.toOunces()/divisor;
    this.ounces = dividedOz;
    this.normalize();
  }
  public String toString(){
    String ozString = String.format("%.3f",this.ounces);
    return this.pounds+" lbs "+ozString+" oz";
  }
  /* 
  ** takes the number of lbs in the weight object and multiplies 
  ** by 16 then adds weight objects oz plus the new oz
  */
  private double toOunces() {
    double lbOunces = this.pounds * CONSTANT;
    double totalOunces = this.ounces + lbOunces;
    return totalOunces;
  }
  /*
  ** if there are more than 16 ounces, will increment lbs
  ** I might can this to call toOunces, and then increment lbs
  ** for the result of a division of 16
  */
  private void normalize() {
    double convertedToOz = this.toOunces();
    this.pounds = (int) (convertedToOz / CONSTANT);
    this.ounces = convertedToOz - (CONSTANT * this.pounds);
  }
}
