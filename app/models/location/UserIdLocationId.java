package models.location;

import models.abergin.AUser;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Embeddable
public class UserIdLocationId implements Serializable{

    public UserIdLocationId() {}

    public UserIdLocationId(AUser user, Location location) {
        this.user = user;
        this.location = location;
    }


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private AUser user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AUser getUser() {
        return user;
    }

    public void setUser(AUser user) {
        this.user = user;
    }
}
