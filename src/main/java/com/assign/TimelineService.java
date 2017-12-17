package com.assign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
