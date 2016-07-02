package models.images;

import models.abergin.AUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Entity
@Table(name = "IMAGES")
public class Image implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IMAGE_ID")
    private Long imageId;

    @Lob
    @Column(name = "IMAGE_BLOB")
    private byte[] imageBlob;

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private Set<AUser> aUserSet;


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
