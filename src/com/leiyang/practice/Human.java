package com.leiyang.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Human extends Creature implements Serializable {

	public Human(){
		super("sdf");
	}
	
	public Human(String sth){
		super();
	}
	
//	public Creature(String sth){
//		
//	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:/abc.txt");
			fos.write(3);
			new StringBuffer("ee").equals(new StringBuffer("fsdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class InnerClass0 {
		public InnerClass0(){
			
		}
		private int i=0;
		private String str="";
		void sayHello(String str){
			System.out.println("Hello, "+str+"! Your xyz is:"+this.str);
		}
	}
	
}
