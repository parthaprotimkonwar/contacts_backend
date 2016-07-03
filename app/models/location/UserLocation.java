package models.location;

import models.Constants;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "AUSER_LOCATION", schema = Constants.SCHEMA_NAME_CONTACTS_LOCATION)
public class UserLocation implements Serializable {

    @EmbeddedId
    private UserIdLocationId userIdLocationId;

    public UserLocation() {
    }

    public UserLocation(UserIdLocationId userIdLocationId) {
        this.userIdLocationId = userIdLocationId;
    }

    public UserIdLocationId getUserIdLocationId() {
        return userIdLocationId;
    }

    public void setUserIdLocationId(UserIdLocationId userIdLocationId) {
        this.userIdLocationId = userIdLocationId;
    }
}
