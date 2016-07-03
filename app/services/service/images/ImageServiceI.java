package services.service.images;

import application.exceptions.BaseException;
import models.aaimages.AAImage;
import models.bean.images.ImageBean;

/**
 * Created by pkonwar on 7/3/2016.
 */
public interface ImageServiceI {

    /**
     * Save an AAImage
     * @param imageBean
     * @return
     * @throws BaseException
     */
    AAImage saveImage(ImageBean imageBean) throws BaseException;

    /**
     * Read an AAImage
     * @param imageId
     * @return
     * @throws BaseException
     */
    AAImage readImage(Long imageId) throws BaseException;

    /**
     * Update AAImage
     * @param imageBean
     * @return
     * @throws BaseException
     */
    AAImage updateImage(ImageBean imageBean) throws BaseException;

    /**
     *
     * Delete AAImage
     * @param imageId
     * @return
     * @throws BaseException
     */
    Boolean deleteImage(Long imageId) throws BaseException;
}