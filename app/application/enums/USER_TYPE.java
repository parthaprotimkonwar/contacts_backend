package application.enums;

import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
public enum USER_TYPE implements Serializable{
    ADMIN("ADMIN"),
    CUSTOMERS("CUSTOMERS"),
    VENDORS("VENDORS");


    String userType;

    private USER_TYPE(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return userType;
    }
}
