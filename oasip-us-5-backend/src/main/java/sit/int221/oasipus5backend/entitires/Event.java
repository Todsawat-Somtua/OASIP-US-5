package sit.int221.oasipus5backend.entitires;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId", nullable = false)
    private Integer eventId;
    @ManyToOne
    @JoinColumn(name = "eventCategoryId")
    private EventCategory eventCategory;

    @Column(name = "bookingName", nullable = false, length = 100)
//    @NotEmpty(message = "Please insert name")
//    @Size(max = 100, message = "100 characters")
    private String bookingName;

    @Column(name = "bookingEmail", nullable = false, length = 100)
//    @NotEmpty(message = "Please insert email")
//    @Email(message = "must @mail only")
    private String bookingEmail;

    @Column(name = "eventStartTime", nullable = false)
    private Instant eventStartTime;

    @Column(name = "eventDuration", nullable = false)
    private Integer eventDuration;

    @Column(name = "eventNotes", length = 200)
    private String eventNotes;
}