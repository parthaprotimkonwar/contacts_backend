package models.specialities;

import models.abergin.AUser;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Embeddable
public class UserIdSubSpecialityId implements Serializable {


    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AUser user;

    @ManyToOne
    @JoinColumn(name = "SUB_SPECIALITY_ID")
    private SubSpeciality subSpeciality;

    public UserIdSubSpecialityId() {
    }

    public UserIdSubSpecialityId(AUser user, SubSpeciality subSpeciality) {
        this.user = user;
        this.subSpeciality = subSpeciality;
    }

    public AUser getUser() {
        return user;
    }

    public void setUser(AUser user) {
        this.user = user;
    }

    public SubSpeciality getSubSpeciality() {
        return subSpeciality;
    }

    public void setSubSpeciality(SubSpeciality subSpeciality) {
        this.subSpeciality = subSpeciality;
    }
}
