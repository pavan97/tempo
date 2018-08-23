package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {
	
	@MyDate(Day=25 , Year=1996)
	public static void display() {
		System.out.println("Display");
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException 
	
	{ 
		TestAnnotation test=new TestAnnotation();
		Class class1 =test.getClass();
		
		Method[] methods=class1.getMethods();
		
		for (Method method:methods) {
			Annotation[] annotations = method.getAnnotations();
			for(Annotation anno:annotations) {
				if(anno.annotationType().equals(MyDate.class))
				{
					MyDate m=(MyDate)anno;
					int day=m.Day();
					System.out.println(day);
				}
			}
		}
		// TODO Auto-generated method stub

	}

}


