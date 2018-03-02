package com.leiyang.practice;

public class CompareToParent implements Comparable{
	    private int age = 0;
	    public CompareToParent(int age){
	       this.age = age;
	    }
	    public int compareTo(Object o){
	       // TODO Auto-generated method stub
	       System.out.println("method of parent");
	       CompareToParent o1 = (CompareToParent)o;
	       return age>o1.age?1:age<o1.age?-1:0;
	    }
	    public static void main(String[] args){
	    	String s1 = "dfsd";
	    	String s2 = new String("dfsd");
	    	System.out.println(s1==s2);
	    	System.out.println(s1.toString() == s2.toString());
	    	System.out.println(s1.toString().equals(s2.toString()));
	    	
	    	ok:
	    		for(int i=0;i<10;i++)     {
	    		        for(int j=0;j<10;j++)            {
	    		               System.out.println("i=" + i + ",j=" + j);
	    		               if(j == 5) break ok;
	    		        }
	    		}
	    	char ch = 25;
	    	Character c = new Character(ch);
	    }
	 
	}