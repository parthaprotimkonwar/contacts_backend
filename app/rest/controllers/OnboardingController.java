package rest.controllers;

import application.enums.STATUS;
import application.exceptions.BaseException;
import models.abergin.AUser;
import models.abergin.Address;
import models.bean.abergin.AUserBean;
import models.bean.abergin.AddressBean;
import models.bean.places.CityBean;
import models.bean.specialities.SpecialityBean;
import models.bean.specialities.SubSpecialityBean;
import models.bean.specialities.UserSubSpecialityBean;
import models.places.City;
import models.specialities.Speciality;
import models.specialities.SubSpeciality;
import models.specialities.UserSubSpeciality;
import play.mvc.BodyParser;
import play.mvc.Result;
import rest.bean.response.ErrorResponse;
import rest.bean.response.ResponseBean;
import rest.factory.BaseController;
import services.service.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 7/6/2016.
 */
@Named
@Singleton
public class OnboardingController extends BaseController{

    @Inject
    ServicesFactory servicesFactory;

    @BodyParser.Of(BodyParser.Json.class)
    public Result onboardCity() {
        ResponseBean responseBean = null;
        try {
            CityBean cityBean = convertRequestBodyToObject(request().body(), CityBean.class);
            City city = servicesFactory.cityService.saveCity(cityBean);
            responseBean = new ResponseBean(STATUS.SUCCESS, null, city.toCityBean(), null);
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

    @BodyParser.Of(BodyParser.Json.class)
    public Result onboardSpeciality() {
        ResponseBean responseBean = null;
        try {
            SpecialityBean specialityBean = convertRequestBodyToObject(request().body(), SpecialityBean.class);
            Speciality speciality = servicesFactory.specialityService.addSpeciality(specialityBean);
            responseBean = new ResponseBean(STATUS.SUCCESS, null, speciality.toSpecialityBean(), null);

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


    @BodyParser.Of(BodyParser.Json.class)
    public Result onboardSubSpeciality() {
        ResponseBean responseBean = null;
        try {
            SubSpecialityBean subSpecialityBean = convertRequestBodyToObject(request().body(), SubSpecialityBean.class);
            SubSpeciality subSpeciality = servicesFactory.subSpecialityService.addSubSpeciality(subSpecialityBean);
            responseBean = new ResponseBean(STATUS.SUCCESS, null, subSpeciality.toSubSpecialityBean(), null);

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

    @BodyParser.Of(BodyParser.Json.class)
    public Result onboardUser() {
        ResponseBean responseBean = null;
        try {
            AUserBean userBean = convertRequestBodyToObject(request().body(), AUserBean.class);
            AUser user = servicesFactory.usersService.createAUser(userBean);
            responseBean = new ResponseBean(STATUS.SUCCESS, null, user.toAUserBean(), null);

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

    @BodyParser.Of(BodyParser.Json.class)
    public Result onboardAddress() {
        ResponseBean responseBean = null;
        try {
            AddressBean addressBean = convertRequestBodyToObject(request().body(), AddressBean.class);
            Address address = servicesFactory.addressService.createAddress(addressBean);
            responseBean = new ResponseBean(STATUS.SUCCESS, null, address.toAddressBean(), null);

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

    @BodyParser.Of(BodyParser.Json.class)
    public Result onboardUserSubSpeciality() {
        ResponseBean responseBean = null;
        try {
            UserSubSpecialityBean userSubSpecialityBean = convertRequestBodyToObject(request().body(), UserSubSpecialityBean.class);
            UserSubSpeciality userSubSpeciality = servicesFactory.userSubSpecialityService.addUserSubSpeciality(userSubSpecialityBean);
            responseBean = new ResponseBean(STATUS.SUCCESS, null, userSubSpeciality.toUserSubSpecialityBean(), null);

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
