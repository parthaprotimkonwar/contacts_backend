package services.service.serviceimpl.specialities;

import application.Utilities.Util;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.specialities.SubSpecialityBean;
import models.specialities.Speciality;
import models.specialities.SubSpeciality;
import repository.specialities.SubSpecialityRepository;
import services.service.specialities.SpecialityServiceI;
import services.service.specialities.SubSpecialityServiceI;

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
public class SubSpecialityServiceImpl implements SubSpecialityServiceI {

    @Inject
    SubSpecialityRepository subSpecialityRepository;

    @Inject
    SpecialityServiceI specialityServiceI;

    @Override
    public SubSpeciality addSubSpeciality(SubSpecialityBean subSpecialityBean) throws BaseException {

        try {
            Speciality speciality = specialityServiceI.findASpeciality(subSpecialityBean.getSpecialityId());
            byte[] imageBlob = subSpecialityBean.getImageUrl() != null && !subSpecialityBean.getImageUrl().isEmpty() ? Util.convertImageToByte(subSpecialityBean.getImageUrl()) : null;
            SubSpeciality subSpeciality = new SubSpeciality(subSpecialityBean.getSubSpeciality(), subSpecialityBean.getStatus(), imageBlob, speciality);
            return subSpecialityRepository.save(subSpeciality);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeSubSpeciality(Long subSpecialityId) throws BaseException {
        try {
            subSpecialityRepository.delete(subSpecialityId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public SubSpeciality findASubSpeciality(Long subSpecialityId) throws BaseException {
        try {
            return subSpecialityRepository.findOne(subSpecialityId);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<SubSpeciality> findAllSubSpeciality() throws BaseException {
        try {
            return subSpecialityRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<SubSpecialityBean> convertToSubSpecialityBean(List<SubSpeciality> subSpecialityList) throws BaseException {
        List<SubSpecialityBean> subSpecialityBeanList = new ArrayList<>();
        try {
            for (SubSpeciality subSpeciality : subSpecialityList) {
                SubSpecialityBean subSpecialityBean = new SubSpecialityBean(subSpeciality.getSubSpecialityId(), subSpeciality.getSubSpeciality(), subSpeciality.getStatus(), subSpeciality.getSpeciality().getSpecialityId());
                subSpecialityBeanList.add(subSpecialityBean);
            }
            return subSpecialityBeanList;
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
