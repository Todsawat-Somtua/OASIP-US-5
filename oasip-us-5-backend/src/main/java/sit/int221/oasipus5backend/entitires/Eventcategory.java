package sit.int221.oasipus5backend.entitires;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "eventcategories")
public class Eventcategory {
    @Id
    @Column(name = "eventCategoryId", nullable = false)
    private Integer id;

    @Column(name = "eventCategoryName", nullable = false, length = 100)
    private String eventCategoryName;

    @Column(name = "eventDuration", nullable = false)
    private Integer eventDuration;

    @Column(name = "eventCategoryDescription", length = 300)
    private String eventCategoryDescription;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "eventCategoryId")
//    private Set<Event> event = new LinkedHashSet<>();
}