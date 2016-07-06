package models.bean.places;

import application.enums.STATUS;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class CityBean implements Serializable {

    private Long cityId;
    private String name;
    private Double latitude;
    private Double longitude;
    private STATUS status;
    private Integer journalId;

    public CityBean() {
    }

    public CityBean(Long cityId) {
        this.cityId = cityId;
    }

    public CityBean(Long cityId, String name, Double latitude, Double longitude, STATUS status, Integer journalId) {
        this.cityId = cityId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.journalId = journalId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
