package sit.int221.oasipus5backend.services;

import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasipus5backend.dtos.EventDTO;
import sit.int221.oasipus5backend.dtos.PutEventDTO;
import sit.int221.oasipus5backend.entitires.Event;
import sit.int221.oasipus5backend.entitires.EventCategory;
import sit.int221.oasipus5backend.repositories.EventCategoryRepository;
import sit.int221.oasipus5backend.repositories.EventRepository;

import java.util.List;

@Service @ToString
public class EventService {
    @Autowired private EventRepository repository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private EventCategoryRepository categoryRepository;
    // GET
    public List<Event> getEvents(){ return repository.findAll();}

    public EventDTO getEventById(Integer eventId) {
        Event events = repository.findById(eventId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, eventId + " does not exist"));
        return modelMapper.map(events, EventDTO.class);
    }
    // POST
    public Event createEvent(EventDTO newEvent){
        Event evt = modelMapper.map(newEvent,Event.class);
        EventCategory eventCategory = categoryRepository.findById(evt.getEventCategory().getEventCategoryId())
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Eventcategory" +
                                evt.getEventCategory().getEventCategoryId() + " Id Does not exist"));
        evt.setEventCategory(eventCategory);
        evt.setEventDuration(eventCategory.getEventDuration());
        evt.setEventId(null);
        return repository.saveAndFlush(evt);
    }

    // Delete
    public void deleteEvent(Integer eventId){
        repository.findById(eventId).orElseThrow(
                ()-> new RuntimeException(eventId + " does not exist"));
        repository.deleteById(eventId);
    }
    // Update
    public Event updateEvent(PutEventDTO updatedEvent, Integer eventId){
        Event updatingEvent = modelMapper.map(updatedEvent, Event.class);
//        updatingEvent =  repository.findById(eventId).map(
//                e-> mapEvent(e, updatedEvent)).orElseGet(()-> { updatedEvent.setEventId(eventId);
//                return updatedEvent;
//                });
//                return repository.saveAndFlush(updateEvent);
        System.out.println(updatedEvent);
        System.out.println(eventId);
        return updatingEvent;
    }

    // Map
    public Event mapEvent(Event existEvent, PutEventDTO updateEvent){
        existEvent.setEventId(updateEvent.getEventId());
        existEvent.setEventStartTime(updateEvent.getEventStartTime());
        existEvent.setEventNotes(updateEvent.getEventNotes());
        return existEvent;
    }
}
