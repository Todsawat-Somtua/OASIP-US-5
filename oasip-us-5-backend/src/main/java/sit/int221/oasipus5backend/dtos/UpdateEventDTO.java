package sit.int221.oasipus5backend.dtos;

import lombok.*;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventDTO {
    private Instant eventStartTime;
    private String eventNotes;
}
