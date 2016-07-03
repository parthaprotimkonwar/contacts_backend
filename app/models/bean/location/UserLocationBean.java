package models.bean.location;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class UserLocationBean implements Serializable {

    private UserIdLocationIdBean userIdLocationIdBean;

    public UserLocationBean() {
    }

    public UserLocationBean(UserIdLocationIdBean userIdLocationIdBean) {
        this.userIdLocationIdBean = userIdLocationIdBean;
    }

    public UserIdLocationIdBean getUserIdLocationIdBean() {
        return userIdLocationIdBean;
    }

    public void setUserIdLocationIdBean(UserIdLocationIdBean userIdLocationIdBean) {
        this.userIdLocationIdBean = userIdLocationIdBean;
    }
}