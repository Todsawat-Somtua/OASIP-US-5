package sit.int221.oasipus5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.oasipus5backend.entitires.EventCategory;
import sit.int221.oasipus5backend.services.EventCategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/eventCategories")
public class EventCategoryController {
    @Autowired
    private EventCategoryService service;
    //GET
    @GetMapping("")
    public List<EventCategory> getEventCategory(){ return service.getEventCategory(); }
}