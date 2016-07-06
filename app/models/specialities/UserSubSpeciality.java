package models.specialities;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.Constants;
import models.bean.specialities.UserIdSubSpecialityIdBean;
import models.bean.specialities.UserSubSpecialityBean;

import javax.persistence.*;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "USER_SUB_SPECIALITY", schema = Constants.SCHEMA_NAME_CONTACTS_SPECIALITY)
public class UserSubSpeciality {

    @EmbeddedId
    private UserIdSubSpecialityId userIdSubSpecialityId;

    @Column(name = "PRICE")
    private Integer price;

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

    public UserSubSpecialityBean toUserSubSpecialityBean() throws BaseException {
        try {
            UserIdSubSpecialityIdBean userIdSubSpecialityIdBean = new UserIdSubSpecialityIdBean(userIdSubSpecialityId.getUser().getUserId(), userIdSubSpecialityId.getSubSpeciality().getSubSpecialityId());
            return new UserSubSpecialityBean(userIdSubSpecialityIdBean, price, journalId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode,err.errorMessage);
        }
    }

    public UserSubSpeciality() {
    }

    public UserSubSpeciality(UserIdSubSpecialityId userIdSubSpecialityId, Integer price) {
        this.userIdSubSpecialityId = userIdSubSpecialityId;
        this.price = price;
    }

    public UserIdSubSpecialityId getUserIdSubSpecialityId() {
        return userIdSubSpecialityId;
    }

    public void setUserIdSubSpecialityId(UserIdSubSpecialityId userIdSubSpecialityId) {
        this.userIdSubSpecialityId = userIdSubSpecialityId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
