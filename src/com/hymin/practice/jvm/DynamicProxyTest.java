package com.hymin.practice.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	
	interface IHello {
		void sayHello();
	}
	
	static class Hello implements IHello {

		@Override
		public void sayHello() {
			System.out.println("Hymin Roberts.");
		}
		
	}
	
	static class DynamicProxy implements InvocationHandler {
		
		Object originalObject;
		
		Object bind(Object originalObject) {
			this.originalObject = originalObject;
			return Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), originalObject.getClass().getInterfaces(), this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("Welcome, ");
			return method.invoke(originalObject, args);
		}
		
	}
	
	public static void main(String ...strings) {
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();
	}
}
