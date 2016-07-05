package services.service.places;

import application.exceptions.BaseException;
import models.bean.places.CityBean;
import models.places.City;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface CityServiceI {

    /**
     * Read a location
     *
     * @param locationId
     * @return
     * @throws BaseException
     */
    City readCity(Long locationId) throws BaseException;

    /**
     * Save a location
     *
     * @param cityBean
     * @return
     * @throws BaseException
     */
    City saveCity(CityBean cityBean) throws BaseException;

    /**
     * @param cityId
     * @throws BaseException
     */
    void deleteCity(Long cityId) throws BaseException;

    /**
     *
     * @param cityBean
     * @return
     * @throws BaseException
     */
    City updateCity(CityBean cityBean) throws BaseException;
}
