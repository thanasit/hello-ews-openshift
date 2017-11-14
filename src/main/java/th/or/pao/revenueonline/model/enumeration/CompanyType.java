package th.or.pao.revenueonline.model.enumeration;

public enum CompanyType {
    GAS("Gas"),
    CIGARETTE("Cigarette"),
    HOTEL("Hotel");

    private String type;

    CompanyType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
