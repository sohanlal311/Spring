package com.sohan.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Triangle) {
			Triangle triangle = (Triangle) bean;
			System.out.println("Triangle...." + triangle.getPointA() + ", " + triangle.getPointB() + ", "
					+ triangle.getPointC());
		}
		System.out.println("in AfterInitialization bean name " + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Triangle) {
			Triangle triangle = (Triangle) bean;
			System.out.println("Triangle...." + triangle.getPointA() + ", " + triangle.getPointB() + ", "
					+ triangle.getPointC());
		}
		System.out.println("in BeforeInitialization bean name " + beanName);
		return bean;
	}

}
