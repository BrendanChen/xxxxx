package com.tutorialspoint;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class MainApp {
	public static void main(String args[]) {
		// XmlBeanFactory factory = new XmlBeanFactory (new
		// ClassPathResource("Beans.xml"));

		// Scope Test
		// HelloWorld objA = (HelloWorld) factory.getBean("helloWorld");
		// objA.setMessage("I'm object A");
		// objA.getMessage();
		//
		// HelloWorld objB = (HelloWorld) factory.getBean("helloWorld");
		// objB.getMessage();

		// Bean Life Cycle
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		context.registerShutdownHook();
	}
}