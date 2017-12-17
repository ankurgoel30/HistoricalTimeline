package com.assign.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import com.assign.model.Event;
import com.assign.model.Timeline;

/**
 * Data access object for storing and retrieving timeline 
 * from xml file 
 *
 */
@Repository
public class TimelineRepository {
	String xmlFileName = "timeline.xml";

	/**
	 * Saves given event to timeline
	 * 
	 * @param event
	 * @return
	 * @throws Exception
	 */
	public Event save(Event event) throws Exception {
		Timeline tl =  readTimeline();
		
		List<Event> events = tl.getEvents();
		if(events == null) {
			events = new ArrayList<Event>();
			tl.setEvents(events);
		}
		events.add(event);
		
		saveTimeline(tl);
		return null;
	}

	/**
	 * Reads the timeline with all events from xml file.
	 * If xml file does not exists then creates an empty timeline file
	 * 
	 * @return
	 * @throws Exception
	 */
	public Timeline readTimeline() throws Exception {
		File file = new File(xmlFileName);

		if (!file.exists()) {
			createEmptyTimeline();
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(Timeline.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Timeline timeline = (Timeline) jaxbUnmarshaller.unmarshal(file);
		return timeline;
	}

	/**
	 * Creates a blank timeline
	 * @throws Exception
	 */
	private void createEmptyTimeline()  throws Exception {
		saveTimeline(null);
	}

	/**
	 * Saves the given timeline. If given timeline is null
	 * then creates a blank timeline with no events
	 * 
	 * @param tl
	 * @return
	 * @throws Exception
	 */
	private Timeline saveTimeline(Timeline tl) throws Exception {
		if(tl == null ) {
			tl = new Timeline();
		}
		
		JAXBContext contextObj = JAXBContext.newInstance(Timeline.class);

		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshallerObj.marshal(tl, new FileOutputStream(xmlFileName));  
		
		return tl;
	}

	public static void main(String[] args) throws Exception {
		TimelineRepository rep = new TimelineRepository();

		Timeline tl =  rep.readTimeline();
		System.out.println(tl);
		
	}
}
