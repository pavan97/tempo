package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAddition {
	@addition(number1 =25)
	public void display() {
		System.out.println("display");
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		
		TestAddition testaddition =new TestAddition();
		Class class1= testaddition.getClass();
		
		Method[] methods=class1.getMethods();
		
		for (Method method:methods) {
			Annotation[] annotations = method.getAnnotations();
			for(Annotation anno:annotations) {
				if(anno.annotationType().equals(addition.class))
				{
					addition add=(addition) anno;
					System.out.println(add.number1()+add.number2());
				}
			}
		}
		}
	
	}

