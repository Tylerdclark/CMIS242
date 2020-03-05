package wk8.discussion;

import java.util.ArrayList;
import java.util.LinkedList;


public class ListExamples {

	public static void main(String[] args) {
		
		long arraylistStartTime = System.nanoTime();
		//manipulating data is better with ArrayLists, a good use case would be databases
		ArrayList<Integer> database = new ArrayList<>();
		for (int i = 0; i < 99999; i++) {
			database.add(i);
			
		}
		long arraylistEndTime = System.nanoTime();
		long elapsedArraylistTime = (arraylistEndTime - arraylistStartTime) / 1000000;
		//ArrayList can be accessed by index in O(1)
		System.out.println(database.get(0));
		System.out.println(database.get(5000));
		
		long linkedlistStartTime = System.nanoTime();
		//linked lists are better with removing and adding, 
		//since each element is a node, with a reference to its neighbor
		LinkedList<Integer> insertsBetter = new LinkedList<>();
		for (int j = 0; j < 99999; j++) {
			insertsBetter.add(j);
		}
		long linkedlistEndTime = System.nanoTime();
		long elapsedLinkedlistTime = (linkedlistEndTime - linkedlistStartTime) /1000000;
		
		System.out.println("ArrayList add time in ms: "+elapsedArraylistTime);
		System.out.println("LinkedList add time in ms: "+elapsedLinkedlistTime);
		
		//LinkedList can also be accessed by index but in O(n/4), meaning number of inputs divided by 4 as an average
		System.out.println(insertsBetter.get(0));
		System.out.println(insertsBetter.get(5000));
	}
}
