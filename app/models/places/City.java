package models.places;

import models.Constants;
import models.abergin.AUser;

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

    public City(String name, Double latitude, Double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
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
}
