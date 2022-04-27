package sit.int221.oasipus5backend.entitires;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Setter @Getter
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "eventId", nullable = false)
    private Integer id;

    @Column(name = "bookingName", nullable = false, length = 100)
    private String bookingName;

    @Column(name = "bookingEmail", nullable = false, length = 45)
    private String bookingEmail;

    @Column(name = "eventStartTime", nullable = false)
    private Instant eventStartTime;

    @Column(name = "eventDuration", nullable = false)
    private Integer eventDuration;

    @Column(name = "eventNotes", length = 200)
    private String eventNotes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eventCategories_eventCategoryId", nullable = false)
    private Eventcategory eventcategoriesEventcategory;
}

