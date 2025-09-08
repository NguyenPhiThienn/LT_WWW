package iuh.fit.se.bai4.model;

public class CartBeanItem {
    private String strPartNumber;
    private String strModelDescription;
    private double dblUnitCost;
    private int iQuantity;
    private double dblTotalCost;

    public String getStrPartNumber() {
        return strPartNumber;
    }

    public void setStrPartNumber(String strPartNumber) {
        this.strPartNumber = strPartNumber;
    }

    public String getStrModelDescription() {
        return strModelDescription;
    }

    public void setStrModelDescription(String strModelDescription) {
        this.strModelDescription = strModelDescription;
    }

    public double getDblUnitCost() {
        return dblUnitCost;
    }

    public void setDblUnitCost(double dblUnitCost) {
        this.dblUnitCost = dblUnitCost;
    }

    public int getiQuantity() {
        return iQuantity;
    }

    public void setiQuantity(int iQuantity) {
        this.iQuantity = iQuantity;
    }

    public double getDblTotalCost() {
        return dblTotalCost;
    }

    public void setDblTotalCost(double dblTotalCost) {
        this.dblTotalCost = dblTotalCost;
    }
}
