package sit.int221.oasipus5backend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int221.oasipus5backend.entitires.Eventcategory;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Integer eventId;
    private Integer eventCategoryId;
    private String bookingName;
    private String bookingEmail;
    private Date eventStartTime;
    private Integer eventDuration;
    private String eventNotes;
}
