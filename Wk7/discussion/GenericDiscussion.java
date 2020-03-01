package wk7.discussion;

public class GenericDiscussion {

	public static void main(String[] args) {
		
		//notice these need to be class, not primitive types
		String[] stringArr = {"one", "two", "three"};
		Integer[] intArr = {1,2,3};
		Float[] floatArr = {1.0f, 2.0f, 3.0f};
		
		printArray(stringArr);
		printArray(intArr);
		printArray(floatArr);

	}
	
	// only one method with generics!
	public static <E> void printArray(E[] a) {
		for (E i : a) {
			System.out.println(i);
		}
	}
	
}
