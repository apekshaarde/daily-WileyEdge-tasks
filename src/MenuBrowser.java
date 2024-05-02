import com.foodieapp.model.CuisineType;
import com.foodieapp.model.ItemType;
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

    public MenuBrowser(List<Restaurant> restList) {
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
                String location= sc.nextLine();
                restList=repository.findRestaurantByLocation(location);
                if(restList!=null){
                    restList.forEach(r -> System.out.println(r));
                }
                break;
            case 2:
                System.out.println("Enter Cuisine Type : VEG, NON_VEG , VEGAN ");
                String type=sc.nextLine();
                CuisineType type1=CuisineType.valueOf(type);
                restList=repository.findRestaurantByType(type1);
                if(restList!=null){
                    restList.forEach(r-> System.out.println(r));
                }
                break;
            case 3:
                System.out.println("Enter Name of Restaurant");
                String name=sc.next()+sc.nextLine();
                restList=repository.findRestaurantByName(name);
                if(restList!=null){
                    for(Restaurant rest:restList){
                        System.out.println(rest.getMenuItems());
                    }
                    restList.forEach(e -> System.out.println(e));
                }
                break;
            default:
                System.out.println("Wrong Input");
        }
    }
}
