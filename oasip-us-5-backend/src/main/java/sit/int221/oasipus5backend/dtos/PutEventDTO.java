package sit.int221.oasipus5backend.dtos;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutEventDTO {
    private Integer eventId;
    private Instant eventStartTime;
    private String eventNotes;

}
