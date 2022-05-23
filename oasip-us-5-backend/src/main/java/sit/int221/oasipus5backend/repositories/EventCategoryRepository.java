package sit.int221.oasipus5backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.oasipus5backend.entitires.EventCategory;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {
    EventCategory findByEventCategoryNameIgnoreCase(String categoryName);
}