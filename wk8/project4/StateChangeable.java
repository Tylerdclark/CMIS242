package wk8.project4;

public interface StateChangeable <S extends Status> {
	
	public abstract void changeState(Status s);

}
