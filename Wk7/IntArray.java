/*
 * This file is from UMGC CMIS 242/week 7's instruction on Collections
 * It demonstrates the operations that can be done on an array
 * */
package Wk7;

class IntArray {
	   private int [] array;
	   private  int size;
	   public IntArray() {
	      array = new int[10];
	      size = 0;
	   }
	   public int get(int i) {
	      return array[i];
	   }
	   public void set(int i, int value) {
	      if (i<size) array[i] = value;
	   }
	   public void add(int value) {
	      array[size++] = value;
	   }
	   public boolean isFull(){
	      return  size == array.length;
	   }
	   public void remove(int i) {
	      for (int j = i; j < size; j++)
	          array[j] = array[j+1];
	      size--;
	   }
	   public void insert(int i, int value) {
	      for (int j = size; j >= i; j--)
	         array[j+1] = array [j];
	      array[i] = value;
	      size++;
	   }
	   public void display() {
	      for (int i = 0; i < size; i++)
	         System.out.print(array[i] + " ");
	   }
	}
