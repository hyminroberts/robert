package com.hymin.practice.ejb3;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote({HelloWorld.class})
@Stateless
public class HelloWorldBean implements HelloWorld {

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Hello: "+name+"!";
	}

}
