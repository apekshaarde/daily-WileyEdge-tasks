import com.foodieapp.model.CuisineType;
import com.foodieapp.model.ItemType;
import com.foodieapp.model.MenuItem;
import com.foodieapp.model.Restaurant;
import com.foodieapp.repository.RestaurantRepository;
import com.foodieapp.repository.RestaurantRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuBrowser {
    private RestaurantRepository repository=new RestaurantRepositoryImpl();
    private Scanner sc=new Scanner(System.in);
    List<Restaurant> restList;


    public MenuBrowser() {

        restList=new ArrayList<>();
    }

    public void browseMenus(){
        System.out.println("1.Search By Location");
        System.out.println("2.Search By Type");
        System.out.println("3.Search By Name");
        System.out.println("Enter Your Choice");
        int choice= sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter Location");
                String location= sc.next()+sc.nextLine();
                restList=repository.findRestaurantByLocation(location);
                if(restList!=null){
                    restList.forEach(r -> System.out.println(r));
                }
                break;
            case 2:
                System.out.println("Enter Cuisine Type: VEG, NON_VEG, VEGAN");
                String type =sc.next()+sc.nextLine().toUpperCase();
                try {
                    CuisineType type1 = CuisineType.valueOf(type);
                    restList = repository.findRestaurantByType(type1);
                    if (restList != null && !restList.isEmpty()) {
                        restList.forEach(r -> System.out.println(r));
                    } else {
                        System.out.println("No restaurants found for the given type.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid cuisine type. Please enter one of: VEG, NON_VEG, VEGAN");
                }
                break;
            case 3:
                System.out.println("Enter Name of Restaurant");
                sc.nextLine();
                String name = sc.nextLine();
                List<Restaurant> restaurantList = repository.findRestaurantByName(name);
                for (Restaurant restaurant : restaurantList) {
                    System.out.println("Restaurant: " + restaurant.getName());
                    System.out.println("Menu Items:");
                    if (restaurant.getMenuItems() != null) {
                        for (MenuItem item : restaurant.getMenuItems()) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("No menu items available");
                    }
                }
                break;
            default:
                System.out.println("Wrong Input");
        }
    }
}
