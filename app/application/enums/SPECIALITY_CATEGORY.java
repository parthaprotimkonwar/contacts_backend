package application.enums;

/**
 * Created by pkonwar on 5/20/2016.
 */
public enum SPECIALITY_CATEGORY {
    TUITION("TUITION"),
    MAID("MAID"),
    DAILY_LABOUR("DAILY_LABOUR"),
    COOK("COOK"),
    AUTOWALA("AUTOWALA"),
    TAXI("TAXI"),
    MINI_TRUCK("MINI_TRUCK"),
    ELECTRICIAN("ELECTRICIAN"),
    PLUMBER("PLUMBER"),
    CARPENTER("CARPENTER"),
    PAINTER("PAINTER"),
    PHYSIOTHERAPIST("PHYSIOTHERAPIST"),
    MILKMAN("MILKMAN");

    String specialityCategory;

    SPECIALITY_CATEGORY(String specialityCategory) {
        this.specialityCategory = specialityCategory;
    }

    @Override
    public String toString() {
        return specialityCategory;
    }
}
