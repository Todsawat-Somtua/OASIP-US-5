package sit.int221.oasipus5backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasipus5backend.entitires.Event;
import sit.int221.oasipus5backend.repositories.EventRepository;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;
    public List<Event> getEvent(){
        return repository.findAll();
    }
    public Event getEventDetail(@PathVariable Integer eventId) {
        return repository.findById(eventId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, eventId + " does not exit"));
    }
}
