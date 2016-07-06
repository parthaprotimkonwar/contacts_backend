package models.places;

import application.enums.STATUS;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.Constants;
import models.abergin.AUser;
import models.bean.places.CityBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "CITY", schema = Constants.SCHEMA_NAME_CONTACTS_ABERGIN)
public class City implements Serializable{

    public City(){}

    public City(String name, Double latitude, Double longitude, STATUS status){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @OneToMany(mappedBy = "city")
    private Set<AUser> userSet;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

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

    /**
     * Converts to CITY BEAN
     * @return
     * @throws BaseException
     */
    public CityBean toCityBean() throws BaseException {
        try {
            return new CityBean(cityId, name, latitude, longitude, status, journalId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage);
        }
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
