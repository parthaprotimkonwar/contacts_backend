package services.service.serviceimpl.abergin;

import application.Utilities.Util;
import application.enums.USER_TYPE;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import repository.abergin.AUsersRepository;
import services.service.abergin.AUsersServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.util.List;

@Named
@Singleton
public class AUsersServiceImpl implements AUsersServiceI {

	@Inject
	AUsersRepository AUsersRepository;
	
	@Override
	public AUser createAUser(AUserBean userBean) throws BaseException{
		try {
			byte[] imageBytes = userBean.getImageUrl() != null && !userBean.getImageUrl().isEmpty() ? Util.convertImageToByte(userBean.getImageUrl()) : null;
			AUser user = new AUser(userBean.getUserType(), userBean.getName(), userBean.getEmail(), userBean.getMobile(), userBean.getPassword(), imageBytes, userBean.getLastLogin(), userBean.getCreatedOn(), userBean.getStatus());
			AUsersRepository.save(user);
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
	public AUser findUserByEmailAndPasswordAndUserType(String email, String password, USER_TYPE userType) throws BaseException {
		try {
			AUser user = AUsersRepository.findByEmailAndPasswordAndUserType(email, password, userType);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmailAndPassword(String email, String password) throws BaseException {
		try {
			AUser user = AUsersRepository.findByEmailAndPasswordAndUserType(email, password, USER_TYPE.VENDORS);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmail(String email, USER_TYPE userType) throws BaseException {
		try {
			AUser user = AUsersRepository.findByEmailAndUserType(email, userType);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserById(@NotNull Long userId) throws BaseException{
		try {
			return AUsersRepository.findOne(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<AUser> users() throws BaseException{
		try {
			return AUsersRepository.findAll();
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public void deleteUser(Long userId) throws BaseException {
		try {
			AUsersRepository.delete(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public UserResponseBean convertToUserBean(AUser aUser) throws BaseException {
		return new UserResponseBean(aUser.getUserId(), aUser.getUserType(), aUser.getName(), aUser.getEmail(), aUser.getMobile(), aUser.getLastLogin(), aUser.getCreatedOn(), null, aUser.getStatus());
	}

}
