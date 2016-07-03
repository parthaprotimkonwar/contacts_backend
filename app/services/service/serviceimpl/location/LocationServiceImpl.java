package services.service.serviceimpl.location;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.location.LocationBean;
import models.location.Location;
import repository.location.LocationRepository;
import services.service.location.LocationServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Named
@Singleton
public class LocationServiceImpl implements LocationServiceI{

    @Inject
    LocationRepository locationRepository;

    @Override
    public Location readLocation(Long locationId) throws BaseException {
        try {
            return locationRepository.findOne(locationId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public Location storeLocation(LocationBean locationBean) throws BaseException {
        try {
            Location location = new Location(locationBean.getName(), locationBean.getLatitude(), locationBean.getLongitude());
            return locationRepository.save(location);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public void deleteLocation(Long locationId) throws BaseException {
        try {
            locationRepository.delete(locationId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public Location updateLocation(LocationBean locationBean) throws BaseException {
        try {
            Location location = readLocation(locationBean.getLocationId());
            //update Name
            if(locationBean.getName() != null && !locationBean.getName().isEmpty())
                location.setName(locationBean.getName());
            //update latitude
            if(locationBean.getLatitude() != null)
                location.setLatitude(locationBean.getLatitude());
            //update longitude
            if(locationBean.getLongitude() != null)
                location.setLongitude(locationBean.getLongitude());
            return locationRepository.save(location);

        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
