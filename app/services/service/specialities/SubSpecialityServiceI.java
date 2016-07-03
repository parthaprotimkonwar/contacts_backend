package services.service.specialities;

import application.exceptions.BaseException;
import models.bean.specialities.SubSpecialityBean;
import models.specialities.SubSpeciality;

import java.util.List;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface SubSpecialityServiceI {

    /**
     * Add SubSpeciality
     *
     * @param subSpecialityBean
     * @return
     */
    SubSpeciality addSubSpeciality(SubSpecialityBean subSpecialityBean) throws BaseException;

    /**
     * Remove SubSpeciality
     *
     * @param subSpecialityId
     * @return
     * @throws BaseException
     */
    Boolean removeSubSpeciality(Long subSpecialityId) throws BaseException;

    /**
     * Find a SubSpeciality
     *
     * @param subSpecialityId
     * @return
     * @throws BaseException
     */
    SubSpeciality findASubSpeciality(Long subSpecialityId) throws BaseException;

    /**
     * Find all SubSpeciality
     *
     * @return
     * @throws BaseException
     */
    List<SubSpeciality> findAllSubSpeciality() throws BaseException;


    /**
     * Convert
     *
     * @param subSpecialityList
     * @return
     * @throws BaseException
     */
    List<SubSpecialityBean> convertToSubSpecialityBean(List<SubSpeciality> subSpecialityList) throws BaseException;

}