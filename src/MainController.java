import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====Welcome to Online Food Delivery System====");
            System.out.println("Select user Type");
            System.out.println("1.Admin");
            System.out.println("2.User");
            System.out.println("3.Exit");
            System.out.println("Enter Your Choice : ");
            int userType = sc.nextInt();
            switch (userType) {
                case 1:
                    AdminController controller = new AdminController();
                    controller.start();
                    break;
                case 2:
                    UserController controller1 = new UserController();
                    controller1.start();
                    break;
                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice");

            }
        }
    }
}
