package services.service.abergin;

import models.bean.abergin.AddressBean;
import models.abergin.Address;
import application.exceptions.BaseException;

public interface AddressServiceI {

	/**
	 * Creates a new Address
	 * @return
	 * @throws BaseException
	 */
	Address createAddress(AddressBean addressBean) throws BaseException;
	
	
	/**
	 * Returns Address based on addressId
	 * @param addressId
	 * @return
	 * @throws BaseException
	 */
	Address retrieveAddress(Long addressId) throws BaseException;

	/**
	 * Find the address of an User
	 * @param userId
	 * @return
	 * @throws BaseException
     */
	Address findAddressByUser(Long userId) throws BaseException;

}
