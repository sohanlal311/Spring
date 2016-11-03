package com.sohan.spring;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*public class Triangle {

 private List<Point> points;

 public List<Point> getPoints() {
 return points;
 }

 public void setPoints(List<Point> points) {
 this.points = points;
 }

 public void draw() {
 for (Point p : points)
 System.out.println("Point = (" + p.getX() + ", " + p.getY() + ")");
 }

 }
 */

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	private Point pointA;

	private Point pointB;

	private Point pointC;

	private ApplicationContext context;

	public Point getPointA() {
		return pointA;
	}

	@Required
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	@Required
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	@Required
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("Point A = (" + pointA.getX() + ", " + pointA.getY() + ")");
		System.out.println("Point B = (" + pointB.getX() + ", " + pointB.getY() + ")");
		System.out.println("Point C = (" + pointC.getX() + ", " + pointC.getY() + ")");
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("Context is set");
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean name is " + beanName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out
				.println("InitializingBean init method called for Triangle " + pointA + ", " + pointB + ", " + pointC);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy method called for Triangle " + pointA + ", " + pointB + ", "
				+ pointC);
	}

	public void init() throws Exception {
		System.out.println("my init method called for Triangle " + pointA + ", " + pointB + ", " + pointC);
	}

	public void cleanUp() throws Exception {
		System.out.println("my cleaup method called for Triangle " + pointA + ", " + pointB + ", " + pointC);
	}

	@PostConstruct
	public void initializeTriangle() throws Exception {
		System.out.println("JSR-250 init method called for Triangle " + pointA + ", " + pointB + ", " + pointC);
	}

	@PreDestroy
	public void destroyTriangle() throws Exception {
		System.out.println("JSR-250 cleaup method called for Triangle " + pointA + ", " + pointB + ", " + pointC);
	}

}
/*
 * public class Triangle {
 * 
 * private String type;
 * 
 * private int height;
 * 
 * Triangle(String type) { this.type = type; }
 * 
 * Triangle(int height) { this.height = height; }
 * 
 * Triangle(String type, int height) { this.type = type; this.height = height; }
 * 
 * public String getType() { return type; }
 * 
 * public void setType(String type) { this.type = type; }
 * 
 * public int getHeight() { return height; }
 * 
 * public void draw() { System.out.println(type + " Triangle drawn of height " +
 * height); }
 * 
 * }
 */
