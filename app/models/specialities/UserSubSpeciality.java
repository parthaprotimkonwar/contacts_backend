package models.specialities;

import models.Constants;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "USER_SUB_SPECIALITY", schema = Constants.SCHEMA_NAME_CONTACTS_SPECIALITY)
public class UserSubSpeciality {

    @EmbeddedId
    private UserIdSubSpecialityId userIdSubSpecialityId;

    @Column(name = "PRICE")
    private Integer price;

    public UserSubSpeciality() {
    }

    public UserSubSpeciality(UserIdSubSpecialityId userIdSubSpecialityId, Integer price) {
        this.userIdSubSpecialityId = userIdSubSpecialityId;
        this.price = price;
    }

    public UserIdSubSpecialityId getUserIdSubSpecialityId() {
        return userIdSubSpecialityId;
    }

    public void setUserIdSubSpecialityId(UserIdSubSpecialityId userIdSubSpecialityId) {
        this.userIdSubSpecialityId = userIdSubSpecialityId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
