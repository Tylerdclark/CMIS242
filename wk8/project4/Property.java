package wk8.project4;


public class Property implements StateChangeable<Status> {
	String propertyAddress;
	int bedrooms;
	int squareFootage;
	int price;
	Status propertyStatus;
	
	
	public Property(String a, int b, int s, int p) {
		this.propertyAddress = a;
		this.bedrooms = b;
		this.squareFootage = s;
		this.price = p;
		this.propertyStatus = Status.FOR_SALE;
	}
	

	@Override
	public void changeState(Status s) {
		this.propertyStatus = s;


	}

}
