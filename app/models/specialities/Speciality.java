package models.specialities;

import application.enums.STATUS;
import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "SPECIALITY", schema = Constants.SCHEMA_NAME_CONTACTS_SPECIALITY)
public class Speciality implements Serializable {

    public Speciality() {
    }

    public Speciality(String speciality, STATUS status) {
        this.speciality = speciality;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SPECIALITY_ID")
    private Long specialityId;

    @Column(name = "SPECIALITY", length = 30, nullable = false, unique = true)
    private String speciality;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    private Set<SubSpeciality> subSpecialitySet;

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
