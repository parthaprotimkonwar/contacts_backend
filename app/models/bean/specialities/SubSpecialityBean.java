package models.bean.specialities;

import application.enums.STATUS;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/3/2016.
 */
public class SubSpecialityBean implements Serializable {

    private Long subSpecialityId;
    private String subSpeciality;
    private STATUS status;
    private Long specialityId;
    private String imageUrl;
    private byte[] imageBlob;
    private Integer journalId;

    public SubSpecialityBean() {
    }

    public SubSpecialityBean(Long subSpecialityId, String subSpeciality, STATUS status, Long specialityId, Integer journalId) {
        this.subSpecialityId = subSpecialityId;
        this.subSpeciality = subSpeciality;
        this.status = status;
        this.specialityId = specialityId;
        this.journalId = journalId;
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

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
