package iuh.fit.se.bai4.model;

public class Product {
    private String id;
    private String model;
    private String description;
    private int quantity;
    private double price;
    private String ingURL;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIngURL() {
        return ingURL;
    }

    public void setIngURL(String ingURL) {
        this.ingURL = ingURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
