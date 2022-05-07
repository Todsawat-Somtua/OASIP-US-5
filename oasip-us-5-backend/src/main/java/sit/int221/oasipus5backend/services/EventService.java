package sit.int221.oasipus5backend.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasipus5backend.dtos.EventDTO;
import sit.int221.oasipus5backend.entitires.Event;
import sit.int221.oasipus5backend.entitires.EventCategory;
import sit.int221.oasipus5backend.repositories.EventCategoryRepository;
import sit.int221.oasipus5backend.repositories.EventRepository;
import sit.int221.oasipus5backend.utils.ListMapper;

import java.util.List;

@Service
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
//    public Event createEvent(EventDTO newEvent){
//        Event evt = modelMapper.map(newEvent,Event.class);
//        evt.setEventCategory(categoryRepository.getById(newEvent.getEventCategoryId()));
//        return repository.saveAndFlush(evt);
//    }
    public Event createEvent(Event newEvent){
        return repository.saveAndFlush(newEvent);
    }
    // Delete
    public void deleteEvent(Integer eventId){
        repository.findById(eventId).orElseThrow(
                ()-> new RuntimeException(eventId + " does not exist"));
        repository.deleteById(eventId);
    }
}
