package product.app.java.repository;

import exception.DuplicateIDException;
import exception.ProductNotFoundException;
import product.app.java.model.Electronics;
import product.app.java.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartRepository{

    List<Product> productList;

    public ShoppingCartServiceImpl(){

        productList = new ArrayList<>();
    }

    private void checkProductAvailability(Product product) throws DuplicateIDException {
        int productId = product.getProductId();
        for (Product checkProd : productList) {
            if (checkProd.getProductId() == productId) {
                throw new DuplicateIDException("product is already available");
            }
        }
    }
    public void addProduct(Product product) throws DuplicateIDException {
        checkProductAvailability(product);
        productList.add(product);
    }

    public void displayProduct() {
        //System.out.println(this.getClass().getSimpleName());
        for(Product product : productList){
            System.out.println("Product ID : "+product.getProductId());
            System.out.println("Product Name : "+product.getProductName());
            System.out.println("Product Price : "+product.getPrice());
            System.out.println("Product Quantity In Stock : "+product.getQuantityInStock());

            if(product instanceof Electronics){
                Electronics electronics = (Electronics) product;
                System.out.println("Brand : "+electronics.getBrand());
                System.out.println("Warranty Period : "+electronics.getWarrantyPeriod());
            }
        }
    }

    public int getTotalPrice() {
       int totalPrice = 0;
       for(Product product : productList){
           totalPrice += product.getPrice();
       }
       return totalPrice;
    }

    private void productNotFound(int id) throws ProductNotFoundException{
        for(Product check : productList){
            if(check.getProductId()!=id){
                throw new ProductNotFoundException("Product Not Found");
            }
        }
    }
    public void deleteProduct(int id) throws ProductNotFoundException {
            productNotFound(id);
            productList.remove(id);
    }
}
