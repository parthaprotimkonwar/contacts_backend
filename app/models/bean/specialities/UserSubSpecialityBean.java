package models.bean.specialities;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class UserSubSpecialityBean {

    private UserIdSubSpecialityIdBean userIdSubSpecialityIdBean;

    private Integer price;

    private Double latitude;

    private Double longitude;

    public UserSubSpecialityBean() {
    }

    public UserSubSpecialityBean(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean, Integer price, Double latitude, Double longitude) {
        this.userIdSubSpecialityIdBean = userIdSubSpecialityIdBean;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public UserIdSubSpecialityIdBean getUserIdSubSpecialityIdBean() {
        return userIdSubSpecialityIdBean;
    }

    public void setUserIdSubSpecialityIdBean(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean) {
        this.userIdSubSpecialityIdBean = userIdSubSpecialityIdBean;
    }
}
