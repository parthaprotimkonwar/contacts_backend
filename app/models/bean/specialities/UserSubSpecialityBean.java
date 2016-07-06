package models.bean.specialities;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class UserSubSpecialityBean {

    private UserIdSubSpecialityIdBean userIdSubSpecialityIdBean;
    private Integer price;
    private Integer journalId;

    public UserSubSpecialityBean() {
    }

    public UserSubSpecialityBean(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean, Integer price, Integer journalId) {
        this.userIdSubSpecialityIdBean = userIdSubSpecialityIdBean;
        this.price = price;
        this.journalId = journalId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public UserIdSubSpecialityIdBean getUserIdSubSpecialityIdBean() {
        return userIdSubSpecialityIdBean;
    }

    public void setUserIdSubSpecialityIdBean(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean) {
        this.userIdSubSpecialityIdBean = userIdSubSpecialityIdBean;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
