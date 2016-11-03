package com.sohan.spring;

import org.springframework.context.ApplicationEvent;

public class DrawingEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawingEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "Circle drawing event+++++";
	}

}
