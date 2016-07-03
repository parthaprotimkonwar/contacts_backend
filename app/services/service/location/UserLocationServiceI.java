package services.service.location;

import application.exceptions.BaseException;
import models.bean.location.UserIdLocationIdBean;
import models.bean.location.UserLocationBean;
import models.location.UserLocation;

import java.util.List;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface UserLocationServiceI {

    /**
     * Add User Location
     * @param userLocation
     * @throws BaseException
     */
    void addUserLocation(UserLocation userLocation) throws BaseException;

    /**
     *
     * @param userIdLocationIdBean
     * @return
     * @throws BaseException
     */
    Boolean removeUserLocation(UserIdLocationIdBean userIdLocationIdBean) throws BaseException;

    /**
     *
     * @return
     * @throws BaseException
     */
    List<UserLocation> findAllUserLocation() throws BaseException;

    /**
     *
     * @param userLocationList
     * @return
     * @throws BaseException
     */
    List<UserLocationBean> convertToUserLocationBean(List<UserLocation> userLocationList) throws BaseException;

}