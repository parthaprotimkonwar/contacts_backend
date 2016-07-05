package models.bean.places;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class UserIdCityIdBean implements Serializable {

    private Long userId;
    private Long locationId;

    public UserIdCityIdBean() {
    }

    public UserIdCityIdBean(Long userId, Long locationId) {
        this.userId = userId;
        this.locationId = locationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
