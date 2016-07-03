package models.bean.location;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class LocationBean implements Serializable {

    private Long locationId;

    private String name;

    private Double latitude;

    private Double longitude;

    public LocationBean() {
    }

    public LocationBean(Long locationId) {
        this.locationId = locationId;
    }

    public LocationBean(Long locationId, String name, Double latitude, Double longitude) {
        this.locationId = locationId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

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
