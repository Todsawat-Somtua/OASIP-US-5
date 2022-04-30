package sit.int221.oasipus5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasipus5backend.entitires.Event;
import sit.int221.oasipus5backend.repositories.EventRepository;
import sit.int221.oasipus5backend.service.EventService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService service;
    @GetMapping("")
    public List<Event> getEvent(){
        return service.getEvent();
    }
    @GetMapping("/{eventId}")
    public Event getEventDetail(@PathVariable Integer eventId) { return service.getEventDetail(eventId);}
}
