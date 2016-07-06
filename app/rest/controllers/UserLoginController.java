package rest.controllers;

import application.exceptions.BaseException;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import play.mvc.BodyParser;
import play.mvc.Result;
import rest.bean.response.ErrorResponse;
import rest.factory.BaseController;
import services.service.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Named
@Singleton
public class UserLoginController extends BaseController{

    @Inject
    ServicesFactory servicesFactory;

    @BodyParser.Of(BodyParser.Json.class)
    public Result signup() {

        AUserBean userResponse = null;
        try {
            AUserBean userBean = convertRequestBodyToObject(request().body(), AUserBean.class);
            AUser user = servicesFactory.usersService.createAUser(userBean);
            //UserToken token = servicesFactory.userTokenService.createOrupdateToken(user.getUserId());
            userResponse = user.toAUserBean();

        } catch (BaseException ex) {
            System.out.println(ex.getCause());
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(userResponse);

    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateUser() {

        AUserBean userResponse = null;
        try {
            AUserBean userBean = convertRequestBodyToObject(request().body(), AUserBean.class);
            AUser user = servicesFactory.usersService.updateAUser(userBean);
            //UserToken token = servicesFactory.userTokenService.createOrupdateToken(user.getUserId());
            userResponse = user.toAUserBean();

        } catch (BaseException ex) {
            System.out.println(ex.getCause());
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(userResponse);

    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result login() {

        /*LoginResponseBean response = null;
        try {
            AUserBean userBean = convertRequestBodyToObject(request().body(), AUserBean.class);
            AUser user = servicesFactory.usersService.login(userBean);
            if(user == null) {
                ErrorConstants error = ErrorConstants.INVALID_LOGIN;
                throw new BaseException(error.errorCode, error.errorMessage);
            }
            UserToken token = servicesFactory.userTokenService.createOrupdateToken(user.getUserId());
            //UserResponseBean userDetails = servicesFactory.usersService.convertToUserBean(user);
            UserResponseBean userDetails = new UserResponseBean();
            response = new LoginResponseBean(user.getUserId(), token.getTokenId(), user.getStatus(), userDetails);

        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(response);*/
        return null;

    }


    @BodyParser.Of(BodyParser.Json.class)
    public Result logout() {

        /*ResponseBean response = null;
        try {
            UserTransactionRequestBean userBean = convertRequestBodyToObject(request().body(), UserTransactionRequestBean.class);
            servicesFactory.userTokenService.removeToken(userBean.getToken());
            response = new ResponseBean(STATUS.SUCCESS);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(response);*/
        return null;

    }
}
