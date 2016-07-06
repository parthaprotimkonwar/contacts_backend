package services.service;

import services.service.abergin.AUsersServiceI;
import services.service.abergin.UserTokenServiceI;
import services.service.abergin.AddressServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class ServicesFactory {

	@Inject
	public AUsersServiceI usersService;

	@Inject
	public UserTokenServiceI userTokenService;

	@Inject
	public AddressServiceI addressService;

	@Inject
	public PersonServiceI personService;

}
