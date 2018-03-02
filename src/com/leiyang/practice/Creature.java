package com.leiyang.practice;

import java.io.Serializable;

public abstract class Creature implements Serializable {

	private String shape;
	private double weight;
	
	public Creature(){
		
	}
	
    public Creature(String sth){
		
	}
	
	protected void sleep(){}
	
	public abstract void move();
	
	public void eat(String sth){
		
	}
}
