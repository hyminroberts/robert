package com.leiyang.practice;

public class MoveArrayElements {
	
	public static void main(String[] args) {
		int[] arrA = {1,2,3,4,5,6,7};
		moveArrayElement(arrA, 3);
		for (int i: arrA) {
			System.out.println(i);
		}
	}
	
	/** 
     * move the element one time in each loop, move the elements for k times
     * @param array 
     * @param k 
     */  
    public static void moveArrayElement(int[] array, int k) {  
        int length = array.length;  
        // move to right with positions of newk + n * length
        int newk = k % length;  
        int temp = 0;  
        for(int i = 0; i < newk; i++) {  
            temp = array[length - 1];  
            for(int j = length - 2; j >= 0; j--) {  
                array[j+1]=array[j];  
            }  
            array[0]=temp;  
        }  
    }  
}
