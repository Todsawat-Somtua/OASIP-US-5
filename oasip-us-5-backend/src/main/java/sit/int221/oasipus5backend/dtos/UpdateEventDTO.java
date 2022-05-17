package sit.int221.oasipus5backend.dtos;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventDTO {
    @Future(message = "Your Time is invalid, Please insert a future date and time")
    private Instant eventStartTime;
    @Size(max = 500, message = "Note must size between 0 and 500 character")
    private String eventNotes;
}
