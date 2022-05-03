package sit.int221.oasipus5backend.entitires;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "eventId", nullable = false)
    private Integer eventId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eventCategoryId")
    private Eventcategory eventCategory;

    @Column(name = "bookingName", nullable = false, length = 100)
    private String bookingName;

    @Column(name = "bookingEmail", nullable = false, length = 45)
    private String bookingEmail;

    @Column(name = "eventStartTime", nullable = false)
    private Date eventStartTime;

    @Column(name = "eventDuration", nullable = false)
    private Integer eventDuration;
    
    @Column(name = "eventNotes", length = 200)
    private String eventNotes;
}