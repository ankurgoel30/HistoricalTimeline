package com.assign.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model class for Timeline with list of events 
 *
 */
@XmlRootElement
public class Timeline {
	
	private List<Event> events;

	@XmlElement(name="event") 
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	

}
