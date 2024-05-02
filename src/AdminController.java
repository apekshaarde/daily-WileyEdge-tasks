import com.foodieapp.model.*;
import com.foodieapp.repository.RestaurantRepository;
import com.foodieapp.repository.RestaurantRepositoryImpl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private RestaurantRepository repository=new RestaurantRepositoryImpl();
    private Restaurant restaurant1;

    private MenuItem item;
    Scanner sc=new Scanner(System.in);
    public void start(){
        while(true){
            System.out.println("====Welcome to Admin====");
            System.out.println("1.Add New Restaurant : ");
            System.out.println("2.Update New Restaurant : ");
            System.out.println("3.Set Activation Status : ");
            System.out.println("4.Exit");
            int choice =sc.nextInt();
            switch (choice){
                case 1:
                    CuisineType cuisineType = null;
                    ItemType type=null;
                    item=new MenuItem("Biryani",300,type.NON_VEG,2500);
                    restaurant1=new FastFoodRestaurant(1,"Arsalan",
                            cuisineType.FAST_FOOD_RESTAURANT,"Mohali", LocalTime.of(10,00),
                            LocalTime.of(21,00),
                            new ArrayList<>(List.of(item)),false);
                    if(restaurant1!=null) {
                        repository.addRestaurant(restaurant1);
                    }
                    else{
                        System.out.println("InAppropriate Data");
                    }
                    System.out.println("Restaurant added"+restaurant1);
                    break;
                case 2:
                    System.out.println("Enter price to update : ");
                    double price=sc.nextDouble();
                    System.out.println("Enter Calorie count : ");
                    double calorie= sc.nextDouble();
                    item.setCalorieCount(calorie);
                    item.setPrice(price);
                    repository.updateMenuItem(item);
                    break;
                case 3:
                    repository.setActivationStatus(restaurant1.isActive(),
                            restaurant1.getRestaurantId());
                    break;
                case 4:
                    return;
            }
        }
    }
}
