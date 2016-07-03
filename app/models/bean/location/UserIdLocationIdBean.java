package models.bean.location;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class UserIdLocationIdBean implements Serializable {

    private Long userId;
    private Long locationId;

    public UserIdLocationIdBean() {
    }

    public UserIdLocationIdBean(Long userId, Long locationId) {
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
