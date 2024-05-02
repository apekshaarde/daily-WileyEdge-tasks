import com.foodieapp.repository.RestaurantRepository;
import com.foodieapp.repository.RestaurantRepositoryImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    Scanner sc=new Scanner(System.in);
    private MenuBrowser browser=new MenuBrowser(new ArrayList<>());
     public void start(){
         while (true){
             System.out.println("====Welcome to User====");
             System.out.println("1.Browse Menus");
             System.out.println("Enter your Choice");
             int choice=sc.nextInt();
             switch (choice) {
                 case 1:
                     browser.browseMenus();
                     break;
                 default:
                     System.out.println("Invalid Input");
             }
         }
     }
}
