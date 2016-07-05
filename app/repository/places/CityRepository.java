package repository.places;

import models.places.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface CityRepository extends JpaRepository<City, Long> {
    
}
