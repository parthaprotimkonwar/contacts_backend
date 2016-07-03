package services.service.location;

import application.exceptions.BaseException;
import models.bean.location.LocationBean;
import models.location.Location;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface LocationServiceI {

    /**
     * Read a location
     *
     * @param locationId
     * @return
     * @throws BaseException
     */
    Location readLocation(Long locationId) throws BaseException;

    /**
     * Save a location
     *
     * @param locationBean
     * @return
     * @throws BaseException
     */
    Location storeLocation(LocationBean locationBean) throws BaseException;

    /**
     * @param locationId
     * @return
     * @throws BaseException
     */
    Boolean deleteLocation(Long locationId) throws BaseException;

    /**
     *
     * @param locationBean
     * @return
     * @throws BaseException
     */
    Location updateLocation(LocationBean locationBean) throws BaseException;
}
