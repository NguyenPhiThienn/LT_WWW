package iuh.fit.se.bai2.models;

public class CartItemBean {
    private String strPartNumber;
    private String strModelDescription;
    private double dblUnitCost;
    private int iQuantity;
    private double dblTotalCost;

    public CartItemBean() {}

    public CartItemBean(String strPartNumber, String strModelDescription, double dblUnitCost, int iQuantity, double dblTotalCost) {
        this.strPartNumber = strPartNumber;
        this.strModelDescription = strModelDescription;
        this.dblUnitCost = dblUnitCost;
        this.iQuantity = iQuantity;
        this.dblTotalCost = dblTotalCost;
    }

    public String getPartNumber() { return strPartNumber; }
    public void setPartNumber(String strPartNumber) { this.strPartNumber = strPartNumber; }

    public String getModelDescription() { return strModelDescription; }
    public void setModelDescription(String strModelDescription) { this.strModelDescription = strModelDescription; }

    public double getUnitCost() { return dblUnitCost; }
    public void setUnitCost(double dblUnitCost) { this.dblUnitCost = dblUnitCost; }

    public int getQuantity() { return iQuantity; }
    public void setQuantity(int iQuantity) { this.iQuantity = iQuantity; }

    public double getTotalCost() { return dblTotalCost; }
    public void setTotalCost(double dblTotalCost) { this.dblTotalCost = dblTotalCost; }
}
