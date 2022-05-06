package sit.int221.oasipus5backend.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasipus5backend.dtos.EventCategoryDTO;
import sit.int221.oasipus5backend.entitires.Eventcategory;
import sit.int221.oasipus5backend.repositories.EventcategoryRepository;
import sit.int221.oasipus5backend.utils.ListMapper;

import java.util.List;

@Service
public class EventCategoryService{
    @Autowired
    private EventcategoryRepository repository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private ListMapper listMapper;
    // GET
    public List<EventCategoryDTO> getEventCategory(){
        List<Eventcategory> eventCategory = repository.findAll();
        return listMapper.mapList(eventCategory, EventCategoryDTO.class, modelMapper);
    }
}