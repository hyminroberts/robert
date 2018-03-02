package com.leiyang.practice;

public class CompareToChild extends CompareToParent{
	
//	public int age = 1;
	
	    public CompareToChild(){
	       super(3);
	    }
	    public int compareTo(Object o){
	 
	           // TODO Auto-generated method stub
	           System.out.println("method of child");
//	         Child o1 = (Child)o;
	           return 1;
	 
	    }
	    
	    public static void main(String[] args){
	    	CompareToChild ctc = new CompareToChild();
//	    	System.out.println("age= "+ctc.age);
	    }
	}