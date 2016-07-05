package models.abergin;

import application.Utilities.Util;
import application.enums.STATUS;
import application.enums.USER_TYPE;
import models.Constants;
import models.address.Address;
import models.places.City;
import models.specialities.UserSubSpeciality;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="USERS", schema= Constants.SCHEMA_NAME_CONTACTS_ABERGIN,
		uniqueConstraints={@UniqueConstraint(columnNames = {"USER_TYPE","EMAIL"})},
		indexes = {
				@Index(name = "USERS_LOGIN", columnList = "USER_TYPE,EMAIL,PASSWORD")
		})
public class AUser implements Serializable{

	public AUser() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_TYPE")
	@Enumerated(value = EnumType.ORDINAL)
	private USER_TYPE userType;

	@Column(name = "NAME", length = 30)
	private String name;

	@Column(name = "EMAIL", length = 30)
	private String email;

	@Column(name = "MOBILE", length = 15, unique = true)
	private String mobile;

	@Column(name = "PASSWORD", length = 50)
	private String password;

	@Lob
	@Column(name = "IMAGE_BLOB")
	private byte[] imageBlob;

	@Column(name="LAST_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "STATUS")
	@Enumerated(value = EnumType.ORDINAL)
	private STATUS status;

	@Column(name="LAST_UPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	@OneToOne(mappedBy="user")
	private UserToken userToken;
	
	@OneToOne(mappedBy="user")
	private Address address;

	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City city;

	@OneToMany(mappedBy = "userIdSubSpecialityId.user", fetch = FetchType.EAGER)
	private Set<UserSubSpeciality> userSubSpecialitySet;

	public AUser(Long userId) {
		this.userId = userId;
	}

	public AUser(USER_TYPE userType, String name, String email, String mobile, String password, byte[] imageBlob, Date lastLogin, Date createdOn, STATUS status) {
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.imageBlob = imageBlob;
		this.lastLogin = lastLogin;
		this.createdOn = createdOn;
		this.status = status;
	}

	public void consolidateUser(USER_TYPE userType, String name, String email, String mobile, String password, byte[] imageBlob, Date lastLogin, Date createdOn, STATUS status) {

		if(userType != null)
			this.userType = userType;
		if(!Util.isNullOrEmpty(name))
			this.name = name;
		if(!Util.isNullOrEmpty(email))
			this.email = email;
		if(!Util.isNullOrEmpty(mobile))
			this.mobile = mobile;
		if(!Util.isNullOrEmpty(password))
			this.password = password;
		if(imageBlob != null)
			this.imageBlob = imageBlob;
		if(lastLogin != null)
			this.lastLogin = lastLogin;
		if(createdOn != null)
			this.createdOn = createdOn;
		if(status != null)
			this.status = status;
	}

	@PreUpdate
	@PrePersist
	void executeBeforeEachCommit() {
		lastUpdate = new Date();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public USER_TYPE getUserType() {
		return userType;
	}

	public void setUserType(USER_TYPE userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public UserToken getUserToken() {
		return userToken;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public byte[] getImageBlob() {
		return imageBlob;
	}

	public void setImageBlob(byte[] imageBlob) {
		this.imageBlob = imageBlob;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<UserSubSpeciality> getUserSubSpecialitySet() {
		return userSubSpecialitySet;
	}

	public void setUserSubSpecialitySet(Set<UserSubSpeciality> userSubSpecialitySet) {
		this.userSubSpecialitySet = userSubSpecialitySet;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
