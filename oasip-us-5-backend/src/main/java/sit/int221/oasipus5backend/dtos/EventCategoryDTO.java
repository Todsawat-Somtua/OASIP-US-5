package sit.int221.oasipus5backend.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventCategoryDTO {
    private Integer eventCategoryId;
    private String eventCategoryName;
    private Integer eventDuration;
    private String eventCategoryDescription;

}
