package sit.int221.oasipus5backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.oasipus5backend.entitires.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}