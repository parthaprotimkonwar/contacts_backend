package models.bean.abergin;

import application.enums.STATUS;
import application.enums.USER_TYPE;

import java.io.Serializable;
import java.util.Date;

public class AUserBean implements Serializable {

    private Long userId;
    private USER_TYPE userType;
    private String name;
    private String email;
    private String mobile;
    private String password;
    private String imageUrl;
    private byte[] imageBlob;   //either of imageUrl or imageBlob should be set
    private Date lastLogin;
    private Date createdOn;
    private STATUS status;
    private Date lastUpdate;     //only during response
    public AUserBean() {
    }

    /**
     * For Request
     * @param userId
     * @param userType
     * @param name
     * @param email
     * @param mobile
     * @param password
     * @param imageUrl
     * @param lastLogin
     * @param createdOn
     * @param status
     */
    public AUserBean(Long userId, USER_TYPE userType, String name, String email, String mobile, String password, String imageUrl, Date lastLogin, Date createdOn, STATUS status) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.imageUrl = imageUrl;
        this.lastLogin = lastLogin;
        this.createdOn = createdOn;
        this.status = status;
    }

    /**
     * For Response
     * @param userId
     * @param userType
     * @param name
     * @param email
     * @param mobile
     * @param password
     * @param imageBlob
     * @param lastLogin
     * @param createdOn
     * @param status
     */
    public AUserBean(Long userId, USER_TYPE userType, String name, String email, String mobile, String password, byte[] imageBlob, Date lastLogin, Date createdOn, STATUS status) {
        this.userId = userId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
