package com.leiyang.practice;

class Something {
    private static void main(String[] something_to_do){        
        System.out.println("Dosomething ...");
    }
}

interface  AA{
	   int x = 0;
	}
class B{
	   int x =1;
	}
class C extends B implements AA {
	   public void pX(){
//	      System.out.println(x);
	      System.out.println(AA.x);
	   }
	   public static void main(String[] args) {
	      new C().pX();
	   }
	}
