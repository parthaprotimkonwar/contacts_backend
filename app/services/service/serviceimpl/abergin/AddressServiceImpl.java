package services.service.serviceimpl.abergin;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.abergin.AUser;
import models.bean.abergin.AddressBean;
import models.abergin.Address;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import repository.abergin.AddressRepository;
import services.service.abergin.AUsersServiceI;
import services.service.abergin.AddressServiceI;

@Named
@Singleton
public class AddressServiceImpl implements AddressServiceI{

	@Inject
	AddressRepository addressRepository;

	@Inject
	AUsersServiceI usersService;

	@Override
	public Address createAddress(AddressBean addressBean) throws BaseException {
		try {
			AUser user = usersService.findUserById(addressBean.getUserId());
			Address address = new Address(addressBean.getAddressHeading(), addressBean.getPincode(), addressBean.getAddress(), addressBean.getLandmark(), addressBean.getPhoneNo(), addressBean.getCity(), addressBean.getState(), addressBean.getCountry(), addressBean.getLongitude(), addressBean.getLatitude(), user);
			return addressRepository.save(address);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public Address retrieveAddress(Long addressId) throws BaseException {
		try {
			return addressRepository.findOne(addressId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public Address findAddressByUser(Long userId) throws BaseException {
		try {
			AUser user = usersService.findUserById(userId);
			return addressRepository.findByUser(user);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}
