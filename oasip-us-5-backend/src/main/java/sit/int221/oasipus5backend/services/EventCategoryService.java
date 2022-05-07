package sit.int221.oasipus5backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int221.oasipus5backend.entitires.EventCategory;
import sit.int221.oasipus5backend.repositories.EventCategoryRepository;

import java.util.List;

@Service
public class EventCategoryService{
    @Autowired
    private EventCategoryRepository repository;
    // GET
    public List<EventCategory> getEventCategory(){ return repository.findAll();}
}