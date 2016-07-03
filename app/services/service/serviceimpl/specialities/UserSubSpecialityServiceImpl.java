package services.service.serviceimpl.specialities;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.specialities.UserIdSubSpecialityIdBean;
import models.bean.specialities.UserSubSpecialityBean;
import models.specialities.SubSpeciality;
import models.specialities.UserIdSubSpecialityId;
import models.specialities.UserSubSpeciality;
import repository.specialities.UserSubSpecialityRepository;
import services.service.abergin.AUsersServiceI;
import services.service.specialities.SubSpecialityServiceI;
import services.service.specialities.UserSubSpecialityServiceI;

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
public class UserSubSpecialityServiceImpl implements UserSubSpecialityServiceI {

    @Inject
    UserSubSpecialityRepository userSubSpecialityRepository;

    @Inject
    AUsersServiceI usersServiceI;

    @Inject
    SubSpecialityServiceI subSpecialityServiceI;

    @Override
    public UserSubSpeciality addUserSubSpeciality(UserSubSpecialityBean userSubSpecialityBean) throws BaseException {
        try {
            SubSpeciality subSpeciality = subSpecialityServiceI.findASubSpeciality(userSubSpecialityBean.getUserIdSubSpecialityIdBean().getSubSpecialityId());
            AUser user = usersServiceI.findUserById(userSubSpecialityBean.getUserIdSubSpecialityIdBean().getUserId());
            UserIdSubSpecialityId userIdSubSpecialityId = new UserIdSubSpecialityId(user, subSpeciality);
            UserSubSpeciality userSubSpeciality = new UserSubSpeciality(userIdSubSpecialityId, userSubSpecialityBean.getPrice(), userSubSpecialityBean.getLatitude(), userSubSpecialityBean.getLongitude());
            return userSubSpecialityRepository.save(userSubSpeciality);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeUserSubSpeciality(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean) throws BaseException {
        try {
            SubSpeciality subSpeciality = subSpecialityServiceI.findASubSpeciality(userIdSubSpecialityIdBean.getSubSpecialityId());
            AUser user = usersServiceI.findUserById(userIdSubSpecialityIdBean.getUserId());
            UserIdSubSpecialityId userIdSubSpecialityId = new UserIdSubSpecialityId(user, subSpeciality);
            userSubSpecialityRepository.delete(userIdSubSpecialityId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<UserSubSpeciality> findAllUserSubSpeciality() throws BaseException {
        try {
            return userSubSpecialityRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<UserSubSpecialityBean> convertToUserSubSpecialityBean(List<UserSubSpeciality> userSubSpecialityList) throws BaseException {
        List<UserSubSpecialityBean> userSubSpecialityBeanList = new ArrayList<>();
        try {
            for (UserSubSpeciality userSubSpeciality : userSubSpecialityList) {
                UserIdSubSpecialityIdBean userIdSubSpecialityIdBean = new UserIdSubSpecialityIdBean(userSubSpeciality.getUserIdSubSpecialityId().getUser().getUserId(), userSubSpeciality.getUserIdSubSpecialityId().getSubSpeciality().getSubSpecialityId());
                UserSubSpecialityBean userSubSpecialityBean = new UserSubSpecialityBean(userIdSubSpecialityIdBean, userSubSpeciality.getPrice(), userSubSpeciality.getLatitude(), userSubSpeciality.getLongitude());
                userSubSpecialityBeanList.add(userSubSpecialityBean);
            }
            return userSubSpecialityBeanList;
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
