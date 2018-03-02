package com.leiyang.practice;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * To get the intersection of two arrays
 * @author Robert Luo
 * @since 2018.03.01
 * */
public class InterSection {
	
	/**
	 * main method
	 * @param String[] args
	 * */
	public static void main(String[] args) {
		int[] arrA = {1,2,3,4,5};
		int[] arrB = {3,4,5,6,7};
		ArrayList arrC = getInterSection(arrA, arrB);
		for (Iterator iter = arrC.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
		
		int[] arrD = {3,1,2,2,1,3,3,2,1,4};
		arrD = insertSort(arrD);
		for (int i: arrD) {
			System.out.print(i);
			System.out.print(",");
		}
		
	}

	private static ArrayList getInterSection(int[] arrA, int[] arrB) {
		ArrayList arrTemp = new ArrayList();
		for(int i: arrA) {
			if (isNumberInArray(i, arrB)) {
				arrTemp.add(i);
			}
		}
		return arrTemp;
	}
	
	private static boolean isNumberInArray(int num, int[] arr) {
		boolean inArr = false;
		for (int k: arr) {
			if (k == num) {
				inArr = true;
				break;
			}
		}
		return inArr;
	}
	
	public static void bubbleSort(int a[]) {
	    int n = a.length;   
	    for (int i = 0; i < n - 1; i++) {
	      for (int j = 0; j < n - 1; j++) {
	        if (a[j] > a[j + 1]) {
	          int temp = a[j];
	          a[j] = a[j + 1];
	          a[j + 1] = temp;
	        }
	      }
	    }
	}
	
	public static int[] insertSort(int a[]) {
		int[] sortedArr = new int[a.length];
		for (int i: a) {
			int pos = indexToAdd(i, sortedArr);
			addToArr(i, sortedArr, pos);
		}
		return sortedArr;
	}

	private static void addToArr(int i, int[] sortedArr, int pos) {
		for (int j= 0; j<pos; j++) {
			sortedArr[j] = sortedArr[j+1];
		}
		sortedArr[pos] = i;
		
	}

	private static int indexToAdd(int i, int[] sortedArr) {
		int pos = sortedArr.length-1;
		for (int j=pos; j>=0; j--) {
			if (sortedArr[j] < i) {
				pos = j;
				break;
			}
		}
		return pos;
	}
}
