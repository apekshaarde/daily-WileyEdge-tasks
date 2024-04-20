package product.app.java.model;

public class Electronics extends Product{

    private String brand;
    private String warrantyPeriod;
    public Electronics(int productId, String productName, double price, int quantityInStock,String brand,String warrantyPeriod) {
        super(productId, productName, price, quantityInStock);
        this.brand = brand;
        this.warrantyPeriod=warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Brand : " +brand);
        System.out.println("Warranty Period : " +warrantyPeriod);
    }
}
