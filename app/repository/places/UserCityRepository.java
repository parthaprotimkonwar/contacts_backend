package repository.places;

import models.places.UserIdCityId;
import models.places.UserCity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface UserCityRepository extends JpaRepository<UserCity, UserIdCityId> {
}
