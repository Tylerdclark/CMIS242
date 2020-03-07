package wk8.project4;

//generic interface with bounded generic type parameter of Status
public interface StateChangeable <S extends Status> {
	//abstract method that takes the generic type as parameter
	public abstract void changeState (S status);


}
