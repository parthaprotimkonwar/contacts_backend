package services.service.specialities;

import application.exceptions.BaseException;
import models.bean.specialities.SpecialityBean;
import models.specialities.Speciality;

import java.util.List;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface SpecialityServiceI {

    /**
     * Add a Speciality
     *
     * @param specialityBean
     * @return
     * @throws BaseException
     */
    Speciality addSpeciality(SpecialityBean specialityBean) throws BaseException;

    /**
     * Remove Speciality
     *
     * @param specialityId
     * @return
     * @throws BaseException
     */
    void removeSpeciality(Long specialityId) throws BaseException;

    /**
     * Update a Speciality
     *
     * @param specialityBean
     * @return
     * @throws BaseException
     */
    Speciality updateSpeciality(SpecialityBean specialityBean) throws BaseException;

    /**
     * Find a Speciality
     *
     * @param specialityId
     * @return
     * @throws BaseException
     */
    Speciality findASpeciality(Long specialityId) throws BaseException;

    /**
     * Find all Specialities
     *
     * @return
     * @throws BaseException
     */
    List<Speciality> findAllSpeciality() throws BaseException;

    /**
     * @param specialityList
     * @return
     * @throws BaseException
     */
    List<SpecialityBean> convertToSpecialityBean(List<Speciality> specialityList) throws BaseException;
}
