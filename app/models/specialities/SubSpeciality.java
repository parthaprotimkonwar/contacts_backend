package models.specialities;

import application.enums.STATUS;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.Constants;
import models.bean.specialities.SubSpecialityBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Entity
@Table(name = "SUB_SPECIALITY", schema = Constants.SCHEMA_NAME_CONTACTS_SPECIALITY)
public class SubSpeciality implements Serializable {

    public SubSpeciality() {
    }

    public SubSpeciality(String subSpeciality, STATUS status, byte[] imageBlob, Speciality speciality) {
        this.subSpeciality = subSpeciality;
        this.status = status;
        this.imageBlob = imageBlob;
        this.speciality = speciality;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SUB_SPECIALITY_ID")
    private Long subSpecialityId;

    @Column(name = "SUB_SPECIALITY", length = 30, nullable = false, unique = true)
    private String subSpeciality;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @Lob
    @Column(name = "IMAGE_BLOB")
    private byte[] imageBlob;

    @ManyToOne
    @JoinColumn(name = "SPECIALITY_ID")
    private Speciality speciality;

    @OneToMany(mappedBy = "userIdSubSpecialityId.subSpeciality")
    private Set<UserSubSpeciality> userSubSpecialitySet;

    @Column(name = "JOURNAL_ID")
    private Integer journalId;

    public SubSpecialityBean toSubSpecialityBean() throws BaseException {
        try {
            return new SubSpecialityBean(subSpecialityId, subSpeciality, status, speciality.getSpecialityId(), journalId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage);
        }
    }

    @PreUpdate
    @PrePersist
    void executeBeforeEachCommit() {
        if(journalId != null) {
            journalId += 1;
        } else {
            journalId = 0;
        }
    }

    public Long getSubSpecialityId() {
        return subSpecialityId;
    }

    public void setSubSpecialityId(Long subSpecialityId) {
        this.subSpecialityId = subSpecialityId;
    }

    public String getSubSpeciality() {
        return subSpeciality;
    }

    public void setSubSpeciality(String subSpeciality) {
        this.subSpeciality = subSpeciality;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
