package models.location;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "LOCATION")
public class Location implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @OneToOne(mappedBy = "userIdLocationId.location")
    private UserLocation userLocation;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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
}
