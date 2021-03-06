package services.service.serviceimpl.abergin;

import application.Utilities.Util;
import application.enums.USER_TYPE;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import models.bean.abergin.AddressBean;
import models.bean.specialities.UserSubSpecialityBean;
import models.places.City;
import models.specialities.UserSubSpeciality;
import repository.abergin.AUsersRepository;
import rest.dto.VendorsInCityDto;
import services.service.abergin.AUsersServiceI;
import services.service.places.CityServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Named
@Singleton
public class AUsersServiceImpl implements AUsersServiceI {

	@Inject
	AUsersRepository userRepository;

	@Inject
	CityServiceI cityService;

	@Override
	public AUser createAUser(AUserBean userBean) throws BaseException{
		try {
			byte[] imageBytes = userBean.getImageUrl() != null && !userBean.getImageUrl().isEmpty() ? Util.convertImageToByte(userBean.getImageUrl()) : null;
			City city = cityService.findACity(userBean.getCityId());
			AUser user = new AUser(userBean.getUserType(), userBean.getName(), userBean.getEmail(), userBean.getMobile(), userBean.getPassword(), imageBytes, userBean.getLastLogin(), userBean.getCreatedOn(), userBean.getStatus(), city);
			userRepository.save(user);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser updateAUser(AUserBean userBean) throws BaseException {
		try {
			byte[] imageBytes = userBean.getImageUrl() != null && !userBean.getImageUrl().isEmpty() ? Util.convertImageToByte(userBean.getImageUrl()) : null;
			AUser user = findUserById(userBean.getUserId());
			City city = cityService.findACity(userBean.getCityId());
			user.consolidateUser(userBean.getUserType(), userBean.getName(), userBean.getEmail(), userBean.getMobile(), userBean.getPassword(), imageBytes, userBean.getLastLogin(), userBean.getCreatedOn(), userBean.getStatus(), city);
			userRepository.save(user);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser login(AUserBean userBean) throws BaseException {
		try {
			AUser user = null;
			if(userBean.getUserType() == null) {
				user = findUserByEmailAndPassword(userBean.getEmail(), userBean.getPassword());		//Default Login for vendors
			} else {
				user = findUserByEmailAndPasswordAndUserType(userBean.getEmail(), userBean.getPassword(), userBean.getUserType());	//Login for Others
			}
			//No such user
			if(user == null) {
				ErrorConstants error = ErrorConstants.INVALID_LOGIN;
				throw new BaseException(error.errorCode, error.errorMessage);
			}
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<AUser> findUsersByCity(Long cityId) throws BaseException {
		try {
			City city = cityService.findACity(cityId);
			return userRepository.findByCity(city);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmailAndPasswordAndUserType(String email, String password, USER_TYPE userType) throws BaseException {
		try {
			AUser user = userRepository.findByEmailAndPasswordAndUserType(email, password, userType);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmailAndPassword(String email, String password) throws BaseException {
		try {
			AUser user = userRepository.findByEmailAndPasswordAndUserType(email, password, USER_TYPE.VENDORS);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmail(String email, USER_TYPE userType) throws BaseException {
		try {
			AUser user = userRepository.findByEmailAndUserType(email, userType);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserById(@NotNull Long userId) throws BaseException{
		try {
			return userRepository.findOne(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<AUser> users() throws BaseException{
		try {
			return userRepository.findAll();
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public void deleteUser(Long userId) throws BaseException {
		try {
			userRepository.delete(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<AUserBean> convertToUserBeanList(List<AUser> users) throws BaseException {
		List<AUserBean> userBeanList = new ArrayList<>();
		try {
			for(AUser user : users) {
				userBeanList.add(user.toAUserBean());
			}
			return userBeanList;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

}
