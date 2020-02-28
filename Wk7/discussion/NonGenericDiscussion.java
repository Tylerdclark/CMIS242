package Wk7.discussion;



public class NonGenericDiscussion {

	public static void main(String[] args) {
		
		String[] stringArr = {"one", "two", "three"};
		int[] intArr = {1,2,3};
		float[] floatArr = {1.0f, 2.0f, 3.0f};
		
		printArray(stringArr);
		printArray(intArr);
		printArray(floatArr);

	}
	
	// need a method type for every data type
	public static void printArray(String[] a) {
		for (String i : a) {
			System.out.println(i);
		}
	}
	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.println(i);
		}
	}
	public static void printArray(float[] a) {
		for (float i : a) {
			System.out.println(i);
		}
	}	
}
