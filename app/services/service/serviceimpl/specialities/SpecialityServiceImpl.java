package services.service.serviceimpl.specialities;

import application.Utilities.Util;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.specialities.SpecialityBean;
import models.specialities.Speciality;
import repository.specialities.SpecialityRepository;
import services.service.specialities.SpecialityServiceI;

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
public class SpecialityServiceImpl implements SpecialityServiceI {

    @Inject
    SpecialityRepository specialityRepository;

    @Override
    public Speciality addSpeciality(SpecialityBean specialityBean) throws BaseException {
        try {
            byte[] imageBlob = specialityBean.getImageUrl() != null && !specialityBean.getImageUrl().isEmpty() ? Util.convertImageToByte(specialityBean.getImageUrl()) : null;
            Speciality speciality = new Speciality(specialityBean.getSpeciality(), specialityBean.getStatus(), imageBlob);
            return specialityRepository.save(speciality);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeSpeciality(Long specialityId) throws BaseException {
        try {
            specialityRepository.delete(specialityId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public Speciality updateSpeciality(SpecialityBean specialityBean) throws BaseException {
        try {
            Speciality speciality = findASpeciality(specialityBean.getSpecialityId());
            //Set Speciality
            if (specialityBean.getSpeciality() != null && !specialityBean.getSpeciality().isEmpty())
                speciality.setSpeciality(specialityBean.getSpeciality());

            //set Status
            if (specialityBean.getStatus() != null)
                speciality.setStatus(specialityBean.getStatus());

            return specialityRepository.save(speciality);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public Speciality findASpeciality(Long specialityId) throws BaseException {
        try {
            return specialityRepository.findOne(specialityId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<Speciality> findAllSpeciality() throws BaseException {
        try {
            return specialityRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<SpecialityBean> convertToSpecialityBean(List<Speciality> specialityList) throws BaseException {
        List<SpecialityBean> specialityBeanList = new ArrayList<>();
        try {
            for (Speciality speciality : specialityList) {
                SpecialityBean specialityBean = new SpecialityBean(speciality.getSpecialityId(), speciality.getSpeciality(), speciality.getStatus());
                specialityBeanList.add(specialityBean);
            }
            return specialityBeanList;
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
