package services.service.serviceimpl.places;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.places.UserIdCityIdBean;
import models.bean.places.UserCityBean;
import models.places.City;
import models.places.UserIdCityId;
import models.places.UserCity;
import repository.abergin.AUsersRepository;
import repository.places.CityRepository;
import repository.places.UserCityRepository;
import services.service.places.UserCityServiceI;

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
public class UserCityServiceImpl implements UserCityServiceI {

    @Inject
    UserCityRepository userCityRepository;

    @Inject
    AUsersRepository usersRepository;

    @Inject
    CityRepository cityRepository;

    @Override
    public void addUserLocation(UserCityBean userCityBean) throws BaseException {
        try {
            AUser user = usersRepository.findOne(userCityBean.getUserIdCityIdBean().getUserId());
            City city = cityRepository.findOne(userCityBean.getUserIdCityIdBean().getLocationId());
            UserIdCityId userIdCityId = new UserIdCityId(user, city);
            UserCity userCity = new UserCity(userIdCityId);
            userCityRepository.save(userCity);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeUserLocation(UserIdCityIdBean userIdCityIdBean) throws BaseException {
        try {
            AUser user = usersRepository.findOne(userIdCityIdBean.getUserId());
            City city = cityRepository.findOne(userIdCityIdBean.getLocationId());
            UserIdCityId userIdCityId = new UserIdCityId(user, city);
            userCityRepository.delete(userIdCityId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<UserCity> findAllUserLocation() throws BaseException {
        try {
            return userCityRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<UserCityBean> convertToUserLocationBean(List<UserCity> userCityList) throws BaseException {
        List<UserCityBean> userCityBeanList = new ArrayList<>();
        try {
            for(UserCity userCity : userCityList) {
                UserIdCityIdBean userIdCityIdBean = new UserIdCityIdBean(userCity.getUserIdCityId().getUser().getUserId(), userCity.getUserIdCityId().getCity().getCityId());
                UserCityBean userCityBean = new UserCityBean(userIdCityIdBean);
                userCityBeanList.add(userCityBean);
            }
            return userCityBeanList;

        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
