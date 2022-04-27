package sit.int221.oasipus5backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.oasipus5backend.entitires.Eventcategory;

public interface EventcategoryRepository extends JpaRepository<Eventcategory, Integer> {
}