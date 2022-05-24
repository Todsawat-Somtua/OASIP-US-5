package sit.int221.oasipus5backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int221.oasipus5backend.entitires.Event;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM events e WHERE " +
                    "e.eventCategoryId = ?3 AND " +
                    "((e.eventStartTime < ?1 AND (e.eventStartTime + INTERVAL e.eventDuration MINUTE ) > ?1 ) OR " +
            "(e.eventStartTime >= ?1 AND e.eventStartTime < ?2))")
    List<Event> findOverlapEventsByCategoryId(Instant startTime, Instant endTime, Integer categoryId);

}