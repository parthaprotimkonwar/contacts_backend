package models.places;

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
public class UserIdCityId implements Serializable{

    public UserIdCityId() {}

    public UserIdCityId(AUser user, City city) {
        this.user = user;
        this.city = city;
    }


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private AUser user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_ID")
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public AUser getUser() {
        return user;
    }

    public void setUser(AUser user) {
        this.user = user;
    }
}
