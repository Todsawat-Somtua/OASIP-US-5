package sit.int221.oasipus5backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasipus5backend.dtos.EventCategoryDTO;
import sit.int221.oasipus5backend.entitires.EventCategory;
import sit.int221.oasipus5backend.repositories.EventCategoryRepository;

import java.util.List;

@Service
public class EventCategoryService{
    @Autowired
    private EventCategoryRepository repository;
    // GET
    public List<EventCategory> getEventCategory(){ return repository.findAll();}
    //Update
    public EventCategory update(EventCategoryDTO updateEventCategory, Integer eventCategoryId) {
        EventCategory eventCategoryByName = repository
                .findByEventCategoryNameIgnoreCase(updateEventCategory.getEventCategoryName().trim());
        if(eventCategoryByName != null && eventCategoryByName.getEventCategoryId() != eventCategoryId){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event category name is repeat");
        }

        EventCategory eventCategory = repository.findById(eventCategoryId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Event CategoryId " + eventCategoryId + "Does not exist"));

        eventCategory.setEventCategoryName(updateEventCategory.getEventCategoryName());
        eventCategory.setEventCategoryDescription(updateEventCategory.getEventCategoryDescription());
        eventCategory.setEventDuration(updateEventCategory.getEventDuration());

        return repository.saveAndFlush(eventCategory);
    }
}