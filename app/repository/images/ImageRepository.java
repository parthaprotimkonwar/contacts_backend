package repository.images;

import models.aaimages.AAImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface ImageRepository extends JpaRepository<AAImage, Long> {
}
