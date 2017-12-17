package com.assign.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event implements Comparable<Event> {
	Integer id;
	String title;
	Date date;
	String description;
	String imageLink;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageLink() {
		return imageLink;
	}
	
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int compareTo(Event o) {
		if(this.getDate().equals(o.getDate())) {
			return 0;
		}
		
		if(this.getDate().after(o.getDate())) {
			return -1;
		}
		
		if(this.getDate().before(o.getDate())) {
			return 1;
		}
		
		return 0;
	}
	
	
}
