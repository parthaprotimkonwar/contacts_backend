package repository.location;

import models.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
    
}
