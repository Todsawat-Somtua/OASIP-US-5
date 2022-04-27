package sit.int221.oasipus5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.oasipus5backend.entitires.Event;
import sit.int221.oasipus5backend.repositories.EventRepository;
import sit.int221.oasipus5backend.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService service;
    @GetMapping("")
    public List<Event>getAllEvent(){
        return service.getEvent();
    }
}
