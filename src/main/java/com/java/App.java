package com.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beans.A;
import com.beans.B;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// ctrl shift o to import
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		A a = context.getBean("a", A.class);
		System.out.println(a.getClass());
		System.out.println(a.hashCode());

		a.m1();

		String[] beans = context.getBeanDefinitionNames();

		for (String bean : beans) {
			System.out.println(bean);
		}

		System.out.println("--------Annotation approach below---------");

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.beans");
		ctx.refresh();

		String[] newBeans = ctx.getBeanDefinitionNames();

		for (String bean : newBeans) {
			System.out.println(bean);
		}

		A aa = ctx.getBean(A.class);
		aa.m1();
	}

/*	@Component
	public class A {

		//@Autowired
		B myB;

		public void m1() {
	//		myB.m2(); // NPE
		}

		public B getMyB() {
			return myB;
		}

	//	@Autowired
		public void setMyB(B b) {
	//		this.myB = b;
		}

		
	}*/



}