package sit.int221.oasipus5backend.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasipus5backend.dtos.EventDTO;
import sit.int221.oasipus5backend.entitires.Event;
import sit.int221.oasipus5backend.repositories.EventRepository;
import sit.int221.oasipus5backend.utils.ListMapper;

import java.util.List;

@Service
public class EventService {
    @Autowired private EventRepository repository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private ListMapper listMapper;
    // GET
    public List<EventDTO> getEvents(){
        List<Event> eventList = repository.findAll();
        return listMapper.mapList(eventList, EventDTO.class, modelMapper);
    }

    public EventDTO getEventById(Integer eventId) {
        Event events = repository.findById(eventId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, eventId + " does not exist"));
        return modelMapper.map(events, EventDTO.class);
    }
    // POST
    public Event createEvent(EventDTO newEvent){
        Event evt = modelMapper.map(newEvent, Event.class);
        return repository.saveAndFlush(evt);
    }
}
