package wk6.project3;


public class OutsideBounds extends Exception {
	
	// The fifth class named OutsideBounds should define a checked exception
	
	private static final long serialVersionUID = 1L;
	
	public OutsideBounds(String errorMessage) {
		super(errorMessage);
	}


}
