package repository.specialities;

import models.specialities.UserIdSubSpecialityId;
import models.specialities.UserSubSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface UserSubSpecialityRepository extends JpaRepository<UserSubSpeciality, UserIdSubSpecialityId> {
}
