package com.assign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.dao.TimelineRepository;
import com.assign.model.Event;
import com.assign.model.Timeline;

@Service
public class TimelineService {
	
	@Autowired
	TimelineRepository timelineRepo;
	
	public Event addEvent(Event event) throws Exception{
		return timelineRepo.save(event);
	}
	
	public Timeline getTimeline() throws Exception {
		return timelineRepo.readTimeline();
	}
}
