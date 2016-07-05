package models.bean.places;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class UserCityBean implements Serializable {

    private UserIdCityIdBean userIdCityIdBean;

    public UserCityBean() {
    }

    public UserCityBean(UserIdCityIdBean userIdCityIdBean) {
        this.userIdCityIdBean = userIdCityIdBean;
    }

    public UserIdCityIdBean getUserIdCityIdBean() {
        return userIdCityIdBean;
    }

    public void setUserIdCityIdBean(UserIdCityIdBean userIdCityIdBean) {
        this.userIdCityIdBean = userIdCityIdBean;
    }
}