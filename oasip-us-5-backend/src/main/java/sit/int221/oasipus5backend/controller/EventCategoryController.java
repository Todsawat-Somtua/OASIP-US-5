package sit.int221.oasipus5backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasipus5backend.dtos.EventCategoryDTO;
import sit.int221.oasipus5backend.entitires.EventCategory;
import sit.int221.oasipus5backend.services.EventCategoryService;

import javax.validation.Valid;
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
    @PutMapping("/{eventCategoryId}")
    public EventCategory update(@Valid @RequestBody EventCategoryDTO updateCategory, @PathVariable Integer eventCategoryId){
        return service.update(updateCategory,eventCategoryId);
    }
}