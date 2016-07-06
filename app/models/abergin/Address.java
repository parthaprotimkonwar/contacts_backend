package models.abergin;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.Constants;
import models.bean.abergin.AddressBean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ADDRESS", schema= Constants.SCHEMA_NAME_CONTACTS_ADDRESS)
public class Address implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="ADDRESS_HEADING", length=30, nullable=false)
	private String addressHeading;
	
	@Column(name="PINCODE", length=10, nullable=false)
	private String pincode;
	
	@Column(name = "ADDRESS", columnDefinition = "text")
	private String address;
	
	@Column(name="LANDMARK", length=100)
	private String landmark;
	
	@Column(name="PHONE_NO", length=15)
	private String phoneNo;

	@Column(name="CITY", length=20)
	private String city;
	
	@Column(name="STATE", length=20)
	private String state;
	
	@Column(name="COUNTRY", length=20)
	private String country;

	@Column(name = "LONGITUDE")
	private Double longitude;

	@Column(name = "LATITUDE")
	private Double latitude;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private AUser user;

	@Column(name = "JOURNAL_ID")
	private Integer journalId;			//Journal ID of the record

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
	 * Convert to addressBean
	 * @return
     */
	public AddressBean toAddressBean() throws BaseException {
		try {
			return new AddressBean(addressId, addressHeading, pincode, address, landmark, phoneNo, city, state, country, longitude, latitude, user.getUserId(), journalId);
		} catch (Exception ex) {
			ErrorConstants er = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(er.errorCode, er.errorMessage);
		}
	}

	public Address() {}

	public Address(String addressHeading, String pincode, String address, String landmark, String phoneNo, String city, String state, String country,  Double longitude, Double latitude, AUser user) {
		this.addressHeading = addressHeading;
		this.pincode = pincode;
		this.address = address;
		this.landmark = landmark;
		this.phoneNo = phoneNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.user = user;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressHeading() {
		return addressHeading;
	}

	public void setAddressHeading(String addressHeading) {
		this.addressHeading = addressHeading;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public AUser getUser() {
		return user;
	}

	public void setUser(AUser user) {
		this.user = user;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
}
