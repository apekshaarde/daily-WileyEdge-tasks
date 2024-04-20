package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
//            System.out.println("Enter two numbers:");
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int result = a/b;
//            System.out.println("Result is : "+result);
//
//            int []values = {10,6,2,0,5,7};
//
//            int res = values[0]/values[6];
//            System.out.println("Result is:"+res);

            System.out.println("Enter a number:");
            int no = scanner.nextInt();

                System.out.print("Enter an integer: ");
                int num = scanner.nextInt();
                System.out.println("Entered number: " + num);

                System.out.print("Enter a string: ");
                String str = scanner.next();
                System.out.println("Entered string: " + str);


        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Input mismatch. Please enter valid input.");
        }

    }
}

