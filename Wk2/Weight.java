/* 
* File Name: Weight.java
* Author: Tyler D Clark
* Date: 25 Jan 2020
* Purpose: Contains the weight class constructor and methods for the creation and 
* manipulation of Weight objects.
*/
class Weight{
  private int pounds;
  private double ounces;
  private static final double CONSTANT = 16.000;

  // constructor to hold lbs and oz
  public Weight(int p, double o){
    this.pounds = p;
    this.ounces = o;
  }
   
  // Returns true if the weight object is less than the one passed as an arg
  public boolean lessThan(Weight w){
    if (this.toOunces() < w.toOunces()) {
      return true;
    } else {
      return false;
    }
  }
  // adds the weight arg to the weight obj on which it is called then normalizes
  public void addTo(Weight w){
    this.ounces += w.toOunces(); 
    this.normalize();
  }
  /*
  takes an int and divides the toOunces values by it before assigning it 
  to the object and then normalizes it. Don't wanna divide by 0.
  */
  public void divide(int divisor){
    if (divisor != 0) {
      this.ounces = (this.toOunces() / divisor);
      this.pounds = 0;
      this.normalize();
    }
  }
  /*
  overrides the object toString method, this will make it easier to just simply 
  print the weight objects without trying to call a method
  */
  public String toString(){
    String ozString = String.format("%.3f",this.ounces);
    return this.pounds+" lbs "+ozString+" oz";
  }
  /* 
  takes the number of lbs in the weight object and multiplies 
  by 16 then adds weight objects oz plus the new oz
  */
  private double toOunces() {
    double totalOunces = this.pounds *CONSTANT + this.ounces;
    return totalOunces;
  }
  /*
  the hero of this program. checks if ounces are more than allowed
  before narrow casting them to lbs and putting the remainder as oz
  */
  private void normalize() {
    if (ounces >= 16) {
      this.pounds += (int) (this.ounces / CONSTANT);
      this.ounces = this.ounces % CONSTANT;
    }
  }
}
