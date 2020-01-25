class Weight{
  private int pounds;
  private double ounces;

  //constructor to hold lbs and oz
  public Weight(int lb, double oz){
    this.pounds = lb;
    this.ounces = oz;
  }
  /* Returns true if the weight object is less
  ** than the one passed as an arg
  */
  public boolean lessThan(Weight w){
    //this won't work bcuz 1.15 < 2.01 would be false
    //so just call toOunces 
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
  ** takes the number of lbs in the weight object and multiplies 
  ** by 16 then adds weight objects oz plus the new oz
  */
  private double toOunces() {
    double lbOunces = this.pounds * 16;
    double totalOunces = this.ounces + lbOunces;
    return totalOunces;
  }
  /*
  ** if there are more than 16 ounces, will increment lbs
  ** I might can this to call toOunces, and then increment lbs
  ** for the result of a division of 16
  */
  private void normalize() {
    if (this.ounces > 16){
      double difference = this.ounces - 16;
      this.pounds++;
      this.ounces = difference;
    }
  }
}
