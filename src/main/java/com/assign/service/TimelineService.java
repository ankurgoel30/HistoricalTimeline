package com.assign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.dao.TimelineRepository;
import com.assign.model.Event;
import com.assign.model.Timeline;

/**
 * Provides all services related to timeline 
 *
 */
@Service
public class TimelineService {
	
	@Autowired
	TimelineRepository timelineRepo;
	
	/**
	 * 
	 * To Add Event
	 * 
	 * @param event
	 * @return
	 * @throws Exception
	 */
	public Event addEvent(Event event) throws Exception{
		return timelineRepo.save(event);
	}
	
	/**
	 * Get timeline with list of events
	 * 
	 * @return
	 * @throws Exception
	 */
	public Timeline getTimeline() throws Exception {
		return timelineRepo.readTimeline();
	}
}
