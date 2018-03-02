package com.leiyang.practice;

public class ReverseASentence {
	public static void main(String[] args) {
		String sentence = "I CAN DO IT WELL";
		System.out.println(reverseTheSentence(sentence));
	}

	private static String reverseTheSentence(String sentence) {
		String seperator = " ";
		String[] subStrs = sentence.split(seperator);
		StringBuffer sb = new StringBuffer();
		for (int i=subStrs.length-1; i>=0; i--) {
			sb.append(subStrs[i]);
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}
