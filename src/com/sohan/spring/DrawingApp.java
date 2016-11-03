package com.sohan.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		// Triangle triangle = new Triangle();
		// BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
		// "spring.xml"));
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "spring.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape shape = (Shape) context.getBean("triangle1");
		shape.draw();
		// System.out.println(context.getMessage("greeting", null,
		// "Default greeting message", null));
	}

}
