package com.leiyang.practice;

import java.util.TreeSet;
 
public class TreeSetTest {
 
    /**
     * @paramargs
     */
    public static void main(String[] args) {
       // TODO Auto-generated method stub
       TreeSet set = new TreeSet();
       set.add(new CompareToParent(3));
       try {
		  Thread.sleep(5000);
	   } catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	   }
       set.add(new CompareToChild());
       try {
   		  Thread.sleep(5000);
   	   } catch (InterruptedException e) {
   		  // TODO Auto-generated catch block
   		  e.printStackTrace();
   	   }
       set.add(new CompareToParent(4));
       System.out.println(set.size());
    }
 
}