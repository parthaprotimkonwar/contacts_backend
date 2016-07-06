package repository.abergin;

import models.abergin.AUser;
import models.abergin.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByUser(AUser user);
}
