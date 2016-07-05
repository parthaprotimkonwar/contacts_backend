package services.service.serviceimpl.places;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.places.CityBean;
import models.places.City;
import repository.places.CityRepository;
import services.service.places.CityServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Named
@Singleton
public class CityServiceImpl implements CityServiceI {

    @Inject
    CityRepository cityRepository;

    @Override
    public City readCity(Long locationId) throws BaseException {
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
            City city = new City(cityBean.getName(), cityBean.getLatitude(), cityBean.getLongitude());
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
            City city = readCity(cityBean.getCityId());
            //update Name
            if(cityBean.getName() != null && !cityBean.getName().isEmpty())
                city.setName(cityBean.getName());
            //update latitude
            if(cityBean.getLatitude() != null)
                city.setLatitude(cityBean.getLatitude());
            //update longitude
            if(cityBean.getLongitude() != null)
                city.setLongitude(cityBean.getLongitude());
            return cityRepository.save(city);

        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
