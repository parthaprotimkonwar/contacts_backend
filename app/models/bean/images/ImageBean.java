package models.bean.images;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class ImageBean implements Serializable {

    public ImageBean() {
    }

    public ImageBean(Long imageId) {
        this.imageId = imageId;
    }

    public ImageBean(Long imageId, byte[] imageBlob) {
        this.imageId = imageId;
        this.imageBlob = imageBlob;
    }

    private Long imageId;

    private byte[] imageBlob;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }
}
