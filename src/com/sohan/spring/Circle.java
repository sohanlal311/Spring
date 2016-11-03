package com.sohan.spring;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;

	private ApplicationEventPublisher publisher;

	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	// @Autowired
	// @Qualifier("circleRelated")
	@Resource(name = "pointB")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		Locale locale = Locale.FRANCE;
		System.out.println(messageSource.getMessage("drawing.circle", null, "Default drawing circle message", locale));
		System.out.println(messageSource.getMessage("drawing.point", new Object[] { center.getX(), center.getY() },
				"Default drawing circle message", locale));
		// System.out.println("Center point (" + center.getX() + "," +
		// center.getY()
		// + ")");
		// System.out.println(messageSource.getMessage("greeting", null,
		// "Default greeting message", null));
		publisher.publishEvent(new DrawingEvent(this));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
