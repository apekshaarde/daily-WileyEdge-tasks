package product.app.java.model;

public class Clothing extends Product{

    private String size;
    private String material;

    public Clothing(int productId, String productName, double price, int quantityInStock,String size,String material) {
        super(productId, productName, price, quantityInStock);
        this.size = size;
        this.material=material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Size : "+size);
        System.out.println("Material : "+material);
    }
}
