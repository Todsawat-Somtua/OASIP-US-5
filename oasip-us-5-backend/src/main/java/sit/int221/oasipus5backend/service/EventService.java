package sit.int221.oasipus5backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
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
}
