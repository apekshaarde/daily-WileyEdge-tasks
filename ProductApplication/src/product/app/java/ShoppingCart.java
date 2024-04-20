package product.app.java;

import exception.DuplicateIDException;
import exception.ProductNotFoundException;
import product.app.java.model.Clothing;
import product.app.java.model.Electronics;
import product.app.java.repository.ShoppingCartRepository;
import product.app.java.repository.ShoppingCartServiceImpl;

import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        ShoppingCartRepository repository = new ShoppingCartServiceImpl();

        do{
            System.out.println("1:Add Product:");
            System.out.println("2:Show Product:");
            System.out.println("3:Calculate Total Bill:");
            System.out.println("4:Delete Product:");
            System.out.println("Enter Choice:");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    //Electronics
                    System.out.println("=======ADD ELECTRONIC PRODUCTS DETAILS=======");
                    System.out.println("Enter Product Id : ");
                    int pId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Product Name : ");
                    String pName = sc.nextLine();
                    System.out.println("Enter Product Brand : ");
                    String pBrand = sc.nextLine();
                    System.out.println("Enter Product Warranty Period:");
                    String pWarrantyPeriod = sc.nextLine();
                    System.out.println("Enter Product Price : ");
                    double pPrice = sc.nextDouble();
                    System.out.println("Enter Quantity of Product : ");
                    int pQuantity = sc.nextInt();

                    Electronics electronics = new Electronics(pId,pName,pPrice,pQuantity,pBrand,pWarrantyPeriod);
                    try {
                            repository.addProduct(electronics);
                            System.out.println(electronics.getBrand()+" "+electronics.getProductName());

                    }catch (DuplicateIDException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    repository.displayProduct();
                    break;
                case 3:
                    System.out.println("Total Price --->"+repository.getTotalPrice());

                    break;
                case 4:
                    System.out.println("Enter ID to Delete Product:");
                    int deleteId = sc.nextInt();
                    try {
                        repository.deleteProduct(deleteId);
                    }catch (ProductNotFoundException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }while (true);


//        System.out.println("=======ADD CLOTHING PRODUCT DETAILS=======");
//        System.out.println("Enter Clothing Product Id : ");
//        int cId = sc.nextInt();
//        sc.nextLine();
//        System.out.println("Enter Product Name : ");
//        String cName = sc.nextLine();
//        System.out.println("Enter Size:");
//        String cSize = sc.nextLine();
//        System.out.println("Enter Material : ");
//        String cMaterial = sc.nextLine();
//        System.out.println("Enter Product Price : ");
//        double cPrice = sc.nextDouble();
//        System.out.println("Enter Quantity of Product : ");
//        int cQuantity = sc.nextInt();
//
//        Clothing clothing = new Clothing(cId,cName,cPrice,cQuantity,cSize,cMaterial);
//        try {
//            repository.addProduct(clothing);
//        }catch (DuplicateIDException e){
//            System.out.println(e.getMessage());
//        }


     //   System.out.println("Total Price --->"+repository.getTotalPrice());

    }
}
