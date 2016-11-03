package com.sohan.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
		System.out.println("MyFactoryPostProcessor ..." + "\n\tBeanDefinitionCount:" + factory.getBeanDefinitionCount()
				+ "\n\tBeanPostProcessorCount:" + factory.getBeanPostProcessorCount() + "\n\tSingletonCount:"
				+ factory.getSingletonCount());
	}

}
