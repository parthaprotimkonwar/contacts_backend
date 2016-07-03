package repository.specialities;

import models.specialities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
