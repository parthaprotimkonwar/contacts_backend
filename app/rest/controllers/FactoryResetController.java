package rest.controllers;

import application.enums.STATUS;
import application.exceptions.BaseException;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import models.bean.places.CityBean;
import models.bean.specialities.SpecialityBean;
import models.bean.specialities.SubSpecialityBean;
import models.places.City;
import models.specialities.Speciality;
import models.specialities.SubSpeciality;
import play.mvc.BodyParser;
import play.mvc.Result;
import rest.bean.response.ErrorResponse;
import rest.bean.response.ResponseBean;
import rest.dto.FactoryResetDto;
import rest.dto.VendorsInCityDto;
import rest.factory.BaseController;
import services.service.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 7/6/2016.
 */
@Named
@Singleton
public class FactoryResetController extends BaseController{

    @Inject
    ServicesFactory servicesFactory;

    public Result factoryResetData() {

        ResponseBean responseBean = null;
        FactoryResetDto factoryData = new FactoryResetDto();
        try {
            // CITIES
            List<City> cityList = servicesFactory.cityService.findAllCities();
            List<CityBean> cityBeanList = servicesFactory.cityService.convertToCityBean(cityList);

            // SPECIALITY
            List<Speciality> specialityList = servicesFactory.specialityService.findAllSpeciality();
            List<SpecialityBean> specialityBeanList = servicesFactory.specialityService.convertToSpecialityBean(specialityList);

            // SUB-SPECIALITY
            List<SubSpeciality> subSpecialityList = servicesFactory.subSpecialityService.findAllSubSpeciality();
            List<SubSpecialityBean> subSpecialityBeanList = servicesFactory.subSpecialityService.convertToSubSpecialityBean(subSpecialityList);

            factoryData.setCityBeanList(cityBeanList);
            factoryData.setSpecialityBeanList(specialityBeanList);
            factoryData.setSubSpecialityBeanList(subSpecialityBeanList);

            responseBean = new ResponseBean(STATUS.SUCCESS, null, factoryData, null);

        } catch (BaseException ex) {
            System.out.println(ex.getCause());
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(responseBean);
    }


    public Result vendorsInCity(Long cityId) {
        ResponseBean responseBean = null;
        VendorsInCityDto vendorsInCityDto;
        try {
            vendorsInCityDto = servicesFactory.cityService.findAllVendorsInCity(cityId);
            responseBean = new ResponseBean(STATUS.SUCCESS, null, vendorsInCityDto, null);

        } catch (BaseException ex) {
            System.out.println(ex.getCause());
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(responseBean);
    }

}
