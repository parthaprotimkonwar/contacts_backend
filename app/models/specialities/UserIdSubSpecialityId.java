package models.specialities;

import models.abergin.AUser;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Embeddable
public class UserIdSubSpecialityId implements Serializable{

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AUser user;

    @ManyToOne
    @JoinColumn(name = "SUB_SPECIALITY_ID")
    private SubSpeciality subSpeciality;
}
