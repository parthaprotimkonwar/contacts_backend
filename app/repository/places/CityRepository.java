package repository.places;

import models.places.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    
}
