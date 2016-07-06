package models.specialities;

import application.enums.STATUS;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.Constants;
import models.bean.specialities.SpecialityBean;

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

    public Speciality(String speciality, STATUS status, byte[] imageBlob) {
        this.speciality = speciality;
        this.status = status;
        this.imageBlob = imageBlob;
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

    @Lob
    @Column(name = "IMAGE_BLOB")
    private byte[] imageBlob;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    private Set<SubSpeciality> subSpecialitySet;

    @Column(name = "JOURNAL_ID")
    private Integer journalId;

    @PreUpdate
    @PrePersist
    void executeBeforeEachCommit() {
        if(journalId != null) {
            journalId += 1;
        } else {
            journalId = 0;
        }
    }

    public SpecialityBean toSpecialityBean() throws BaseException{
        try {
            return new SpecialityBean(specialityId, speciality, status, journalId);
        } catch (Exception ex) {
            ErrorConstants err= ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage);
        }
    }
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

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
