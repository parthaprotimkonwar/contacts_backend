package services.service.places;

import application.exceptions.BaseException;
import models.bean.places.UserIdCityIdBean;
import models.bean.places.UserCityBean;
import models.places.UserCity;

import java.util.List;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface UserCityServiceI {

    /**
     * Add User City
     * @param userCityBean
     * @throws BaseException
     */
    void addUserLocation(UserCityBean userCityBean) throws BaseException;

    /**
     *
     * @param userIdCityIdBean
     * @return
     * @throws BaseException
     */
    void removeUserLocation(UserIdCityIdBean userIdCityIdBean) throws BaseException;

    /**
     *
     * @return
     * @throws BaseException
     */
    List<UserCity> findAllUserLocation() throws BaseException;

    /**
     *
     * @param userCityList
     * @return
     * @throws BaseException
     */
    List<UserCityBean> convertToUserLocationBean(List<UserCity> userCityList) throws BaseException;

}
