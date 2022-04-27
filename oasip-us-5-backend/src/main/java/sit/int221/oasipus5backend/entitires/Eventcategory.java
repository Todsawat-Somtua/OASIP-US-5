package sit.int221.oasipus5backend.entitires;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter@Getter
@Table(name = "eventcategories")
public class Eventcategory {
    @Id
    @Column(name = "eventCategoryId", nullable = false, length = 45)
    private String id;

    @Column(name = "eventCategoryName", nullable = false, length = 100)
    private String eventCategoryName;

    @Column(name = "eventDuration", nullable = false)
    private Integer eventDuration;

    @Column(name = "eventCategoryDescription", length = 300)
    private String eventCategoryDescription;
}