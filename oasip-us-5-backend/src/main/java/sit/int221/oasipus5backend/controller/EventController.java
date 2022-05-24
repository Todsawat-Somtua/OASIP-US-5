package sit.int221.oasipus5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasipus5backend.dtos.EventDTO;
import sit.int221.oasipus5backend.dtos.UpdateEventDTO;
import sit.int221.oasipus5backend.entitires.Event;
import sit.int221.oasipus5backend.services.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
// @CrossOrigin(origins = "*")
@RequestMapping("/api/events")
public class EventController {

    @Autowired private EventService service;
    // GET
    @GetMapping("")
    public List<Event> getEvents(){ return service.getEvents(); }

    @GetMapping("/{eventId}")
    public EventDTO getEventById(@PathVariable Integer eventId){
        return service.getEventById(eventId);
    }
    // POST
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@Valid @RequestBody EventDTO newEvent){
        return service.createEvent(newEvent); }
    // Delete
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Integer eventId) { service.deleteEvent(eventId); }
    // Update
    @PutMapping("/{eventId}")
    public Event updateEvent(@Valid @RequestBody UpdateEventDTO updatedEvent, @PathVariable Integer eventId) {
        return service.updateEvent(updatedEvent, eventId );
    }
}
