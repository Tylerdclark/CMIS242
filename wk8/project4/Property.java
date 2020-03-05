package wk8.project4;


public class Property implements StateChangeable<Status> {
	private String propertyAddress;
	private int bedrooms;
	private int squareFootage;
	private int price;
	private Status propertyStatus;
	
	
	public Property(String add, int bed, int sqf, int prc) {
		this.propertyAddress = add;
		this.bedrooms = bed;
		this.squareFootage = sqf;
		this.price = prc;
		this.propertyStatus = Status.FOR_SALE;
	}

	@Override
	public void changeState(Status s) {
		this.propertyStatus = s;
	}
	
	public String toString() {
		return "Property Address: " + this.propertyAddress +"\nNumber of Bedrooms: "
				+this.bedrooms+ "\nSquare Footage "+this.squareFootage+ "\nPrice: "
				+this.price+ "\nCurrent Status: "+ this.propertyStatus;
		
	}

}
