package sit.int221.oasipus5backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventCategoryDTO {
    private Integer eventCategoryId;
    @NotBlank(message = "Event category name is empty")
    @Size(max = 100, message = "Event category name is more than 100 char")
    private String eventCategoryName;

    @Size(max = 500, message = "Event category description is more than 500 char")
    private String eventCategoryDescription;

    @NotNull(message = "Event duration is empty")
    @Min(value = 1, message = "Event duration is out of range")
    @Max(value = 480, message = "Event duration is out of range")
    private Integer eventDuration;
}

