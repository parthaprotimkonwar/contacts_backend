package services.service.serviceimpl.location;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.location.UserIdLocationIdBean;
import models.bean.location.UserLocationBean;
import models.location.Location;
import models.location.UserIdLocationId;
import models.location.UserLocation;
import repository.abergin.AUsersRepository;
import repository.location.LocationRepository;
import repository.location.UserLocationRepository;
import services.service.location.UserLocationServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Named
@Singleton
public class UserLocationServiceImpl implements UserLocationServiceI{

    @Inject
    UserLocationRepository userLocationRepository;

    @Inject
    AUsersRepository usersRepository;

    @Inject
    LocationRepository locationRepository;

    @Override
    public void addUserLocation(UserLocationBean userLocationBean) throws BaseException {
        try {
            AUser user = usersRepository.findOne(userLocationBean.getUserIdLocationIdBean().getUserId());
            Location location = locationRepository.findOne(userLocationBean.getUserIdLocationIdBean().getLocationId());
            UserIdLocationId userIdLocationId = new UserIdLocationId(user, location);
            UserLocation userLocation = new UserLocation(userIdLocationId);
            userLocationRepository.save(userLocation);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeUserLocation(UserIdLocationIdBean userIdLocationIdBean) throws BaseException {
        try {
            AUser user = usersRepository.findOne(userIdLocationIdBean.getUserId());
            Location location = locationRepository.findOne(userIdLocationIdBean.getLocationId());
            UserIdLocationId userIdLocationId = new UserIdLocationId(user, location);
            userLocationRepository.delete(userIdLocationId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<UserLocation> findAllUserLocation() throws BaseException {
        try {
            return userLocationRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<UserLocationBean> convertToUserLocationBean(List<UserLocation> userLocationList) throws BaseException {
        List<UserLocationBean> userLocationBeanList = new ArrayList<>();
        try {
            for(UserLocation userLocation : userLocationList) {
                UserIdLocationIdBean userIdLocationIdBean = new UserIdLocationIdBean(userLocation.getUserIdLocationId().getUser().getUserId(), userLocation.getUserIdLocationId().getLocation().getLocationId());
                UserLocationBean userLocationBean = new UserLocationBean(userIdLocationIdBean);
                userLocationBeanList.add(userLocationBean);
            }
            return userLocationBeanList;

        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
