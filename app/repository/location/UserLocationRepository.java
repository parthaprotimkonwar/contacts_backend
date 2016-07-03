package repository.location;

import models.location.UserIdLocationId;
import models.location.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface UserLocationRepository extends JpaRepository<UserLocation, UserIdLocationId> {
}
