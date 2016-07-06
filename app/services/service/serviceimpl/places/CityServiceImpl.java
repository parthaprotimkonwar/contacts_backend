package services.service.serviceimpl.places;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import models.bean.abergin.AddressBean;
import models.bean.places.CityBean;
import models.places.City;
import models.specialities.UserSubSpeciality;
import repository.places.CityRepository;
import rest.dto.VendorsInCityDto;
import services.service.abergin.AUsersServiceI;
import services.service.places.CityServiceI;

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
public class CityServiceImpl implements CityServiceI {

    @Inject
    CityRepository cityRepository;

    @Inject
    AUsersServiceI usersService;

    @Override
    public City findACity(Long locationId) throws BaseException {
        try {
            return cityRepository.findOne(locationId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public City saveCity(CityBean cityBean) throws BaseException {
        try {
            City city = new City(cityBean.getName(), cityBean.getLatitude(), cityBean.getLongitude(), cityBean.getStatus());
            return cityRepository.save(city);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public void deleteCity(Long cityId) throws BaseException {
        try {
            cityRepository.delete(cityId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public City updateCity(CityBean cityBean) throws BaseException {
        try {
            City city = findACity(cityBean.getCityId());
            //update Name
            if(cityBean.getName() != null && !cityBean.getName().isEmpty())
                city.setName(cityBean.getName());
            //update latitude
            if(cityBean.getLatitude() != null)
                city.setLatitude(cityBean.getLatitude());
            //update longitude
            if(cityBean.getLongitude() != null)
                city.setLongitude(cityBean.getLongitude());
            //update STATUS
            if(cityBean.getStatus() != null)
                city.setStatus(cityBean.getStatus());

            return cityRepository.save(city);

        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public VendorsInCityDto findAllVendorsInCity(Long cityId) throws BaseException {
        VendorsInCityDto vendorsInCityDto = new VendorsInCityDto();
        try {
            List<AUser> userList = usersService.findUsersByCity(cityId);

            for(AUser user : userList) {
                AUserBean userBean = user.toAUserBean();
                AddressBean addressBean = user.getAddress().toAddressBean();
                for(UserSubSpeciality userSubSpeciality : user.getUserSubSpecialitySet()) {
                    vendorsInCityDto.addToUserSubSpeciality(userSubSpeciality.toUserSubSpecialityBean());
                }
                vendorsInCityDto.addToUserBeanList(userBean);
                vendorsInCityDto.addToAddressBeanList(addressBean);
            }
            return vendorsInCityDto;
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<City> findAllCities() throws BaseException {
        try {
            return cityRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<CityBean> convertToCityBean(List<City> cityList) throws BaseException {
        List<CityBean> cityBeanList = new ArrayList<>();
        try {
            for(City city : cityList) {
                cityBeanList.add(city.toCityBean());
            }
            return cityBeanList;
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }

    }
}
