package models.bean.specialities;

import application.enums.STATUS;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class SpecialityBean implements Serializable {

    public SpecialityBean() {
    }

    public SpecialityBean(Long specialityId) {
        this.specialityId = specialityId;
    }

    public SpecialityBean(Long specialityId, String speciality, STATUS status) {
        this.specialityId = specialityId;
        this.speciality = speciality;
        this.status = status;
    }

    private Long specialityId;

    private String speciality;

    private STATUS status;

    private String imageUrl;

    private byte[] imageBlob;       //only one of imageUrl or imageBlob need to be filled.

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
}
