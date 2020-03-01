package wk3.discussion;

import java.io.IOException;

public class ExampleException {
    // Even main needs a throws
    public static void main(String[] args) throws IOException {

        ExampleException e = new ExampleException();

        // first method is called without a try catch
        e.first();
    }

    public ExampleException() {
    }

    // which calls the second
    public void first() throws IOException{
        second();
    }
    // which calls the third
    public void second() throws IOException{
        third();
    }
    // which throws a new IOExceptions
    // Thats a whole lotta "throws"
    public void third() throws IOException{
        throw new IOException(); //the exception is now propagated back
    }
}