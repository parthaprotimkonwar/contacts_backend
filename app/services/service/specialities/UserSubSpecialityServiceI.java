package services.service.specialities;

import application.exceptions.BaseException;
import models.bean.specialities.UserIdSubSpecialityIdBean;
import models.bean.specialities.UserSubSpecialityBean;
import models.specialities.UserSubSpeciality;

import java.util.List;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface UserSubSpecialityServiceI {

    /**
     * Add User SubSpeciality
     *
     * @param userSubSpecialityBean
     * @throws BaseException
     */
    UserSubSpeciality addUserSubSpeciality(UserSubSpecialityBean userSubSpecialityBean) throws BaseException;


    /**
     * Remove SubSpeciality
     *
     * @param userIdSubSpecialityIdBean
     * @return
     * @throws BaseException
     */
    void removeUserSubSpeciality(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean) throws BaseException;

    /**
     * Find all User SubSpeciality
     *
     * @return
     * @throws BaseException
     */
    List<UserSubSpeciality> findAllUserSubSpeciality() throws BaseException;


    /**
     * @param userSubSpecialityList
     * @return
     * @throws BaseException
     */
    public List<UserSubSpecialityBean> convertToUserSubSpecialityBean(List<UserSubSpeciality> userSubSpecialityList) throws BaseException;
}
