package models.specialities;

import models.abergin.AUser;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table
public class UserSubSpeciality {

    @EmbeddedId
    private UserIdSubSpecialityId userIdSubSpecialityId;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;
}
