package com.assign.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assign.model.Event;
import com.assign.service.TimelineService;


/**
 * Timeline controller for handling operations related to timeline 
 *
 */
@Controller
public class TimelineController {
	
	@Autowired
	TimelineService timelineService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	/**
	 * Renders page to add new event
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/showAddEvent", method = RequestMethod.GET)
	public String showAddEventPage(Model model) {
		model.addAttribute("event",new Event());
		return "event";
	}
	
	/**
	 * Adds a event and reders page to list all events
	 * @param model
	 * @param event
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add-event", method = RequestMethod.POST)
	public String addEvent(ModelMap model, Event event, BindingResult result)  throws Exception {
		timelineService.addEvent(event);
		return "redirect:/list-events";
	}
	
	/**
	 * Renders page with list of all events
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list-events", method = RequestMethod.GET)
	public String showAllEvents(ModelMap model)  throws Exception {
		model.put("events", timelineService.getTimeline().getEvents());
		return "list-events";
	}
	
	/**
	 * Renders timeline page with all events in 
	 * chronological order
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/viewTimeline", method = RequestMethod.GET)
	public String showTimelineView(ModelMap model)  throws Exception {
		List<Event> events = timelineService.getTimeline().getEvents();
		if(events==null) {
			events = new ArrayList<Event>();
		}
		events = events.stream().filter(e -> e.getDate()!=null).collect(Collectors.toList());
		
		Collections.sort(events);
		
		model.put("events", events);
		return "timelineview";
	}

}
