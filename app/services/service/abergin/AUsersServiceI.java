package services.service.abergin;

import application.enums.USER_TYPE;
import application.exceptions.BaseException;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import models.places.City;
import rest.dto.VendorsInCityDto;

import java.util.List;

public interface AUsersServiceI {

	/**
	 * Create a new User
	 * @param userBean
	 * @return
	 * @throws BaseException
	 */
	AUser createAUser(AUserBean userBean) throws BaseException;


	/**
	 * Update a user
	 * @param userBean
	 * @return
	 * @throws BaseException
     */
	AUser updateAUser(AUserBean userBean) throws BaseException;

	/**
	 * Login
	 * @param userBean
	 * @return
	 * @throws BaseException
	 */
	AUser login(AUserBean userBean) throws BaseException;

	/**
	 *
	 * @param cityId
	 * @return
	 * @throws BaseException
     */
	List<AUser> findUsersByCity(Long cityId) throws BaseException;


	/**
	 *
	 * @param email
	 * @param password
	 * @param userType
	 * @return
	 * @throws BaseException
     */
	AUser findUserByEmailAndPasswordAndUserType(String email, String password, USER_TYPE userType) throws BaseException;
	/**
	 * Find a user by emailId and Password
	 * @param email
	 * @param password
	 * @return
	 * @throws BaseException
	 */
	AUser findUserByEmailAndPassword(String email, String password) throws BaseException;

	/**
	 * Find a User by emailId.
	 * @param email
	 * @return
	 * @throws BaseException
	 */
	AUser findUserByEmail(String email, USER_TYPE userType) throws BaseException;


	/**
	 * Find a new User
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	AUser findUserById(Long userId) throws BaseException;

	/**
	 * Find all users
	 * @return
	 * @throws BaseException
	 */
	List<AUser> users() throws BaseException;

	/**
	 * Delete a user.
	 * @param userId
	 * @throws BaseException
	 */
	void deleteUser(Long userId) throws BaseException;


	/**
	 *
	 * @param users
	 * @return
	 * @throws BaseException
     */
	List<AUserBean> convertToUserBeanList(List<AUser> users) throws BaseException;
}
