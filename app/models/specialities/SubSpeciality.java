package models.specialities;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Entity
@Table(name = "SUB_SPECIALITY", schema = Constants.SCHEMA_NAME_CONTACTS_SPECIALITY)
public class SubSpeciality implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SUB_SPECIALITY_ID")
    private Long subSpecialityId;

    @Column(name = "SUB_SPECIALITY", length = 30)
    private String subSpecilaity;

    @ManyToOne
    @JoinColumn(name = "SPECIALITY_ID")
    private Speciality speciality;

    @OneToMany(mappedBy = "userIdSubSpecialityId.subSpeciality")
    private Set<UserSubSpeciality> userSubSpecialitySet;
}
