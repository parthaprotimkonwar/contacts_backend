package rest.bean.response;

import java.io.Serializable;

public class AddressDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AddressDto(Long addressId, String addressHeading, String pincode, String address, String landmark, String phoneNo, String city, String state, String country, Double latitude, Double longitude) {
		this.addressId = addressId;
		this.addressHeading = addressHeading;
		this.pincode = pincode;
		this.address = address;
		this.landmark = landmark;
		this.phoneNo = phoneNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Long addressId;
	public String addressHeading;
	public String pincode;
	public String address;
	public String landmark;
	public String phoneNo;
	public String city;
	public String state;
	public String country;
	public Double latitude;
	public Double longitude;
}
