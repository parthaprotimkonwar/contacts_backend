package services.service.places;

import application.exceptions.BaseException;
import models.bean.places.CityBean;
import models.places.City;
import rest.dto.VendorsInCityDto;

import java.util.List;

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
    City findACity(Long locationId) throws BaseException;

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

    /**
     * Find all vendor for a city;
     * @param cityId
     * @return
     * @throws BaseException
     */
    VendorsInCityDto findAllVendorsInCity(Long cityId) throws BaseException;

    /**
     * List Cities
     * @return
     * @throws BaseException
     */
    List<City> findAllCities() throws BaseException;

    /**
     * Convert to CityBean
     * @return
     * @throws BaseException
     */
    List<CityBean> convertToCityBean(List<City> cityList) throws BaseException;
}
