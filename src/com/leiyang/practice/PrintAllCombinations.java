package com.leiyang.practice;

public class PrintAllCombinations {
	public static void main(String[] args) {
		char[] chars = {'A', 'B', 'C', 'D'};
		for (char a: chars) {
			for (char b: chars) {
				for (char c: chars) {
					for (char d: chars) {
						System.out.print(a);
						System.out.print(b);
						System.out.print(c);
						System.out.println(d);
					}
				}
			}
		}
	}
}
