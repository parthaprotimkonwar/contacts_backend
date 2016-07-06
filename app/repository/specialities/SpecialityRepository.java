package repository.specialities;

import models.specialities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
