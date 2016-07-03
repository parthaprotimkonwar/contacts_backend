package models.bean.specialities;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/3/2016.
 */
public class UserIdSubSpecialityIdBean implements Serializable {

    private Long userId;

    private Long subSpecialityId;

    public UserIdSubSpecialityIdBean() {
    }

    public UserIdSubSpecialityIdBean(Long userId, Long subSpecialityId) {
        this.userId = userId;
        this.subSpecialityId = subSpecialityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSubSpecialityId() {
        return subSpecialityId;
    }

    public void setSubSpecialityId(Long subSpecialityId) {
        this.subSpecialityId = subSpecialityId;
    }
}
