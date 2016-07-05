package models.places;

import models.Constants;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "USER_CITY", schema = Constants.SCHEMA_NAME_CONTACTS_PLACES)
public class UserCity implements Serializable {

    @EmbeddedId
    private UserIdCityId userIdCityId;

    public UserCity() {
    }

    public UserCity(UserIdCityId userIdCityId) {
        this.userIdCityId = userIdCityId;
    }

    public UserIdCityId getUserIdCityId() {
        return userIdCityId;
    }

    public void setUserIdCityId(UserIdCityId userIdCityId) {
        this.userIdCityId = userIdCityId;
    }
}
