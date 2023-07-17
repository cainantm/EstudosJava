package Mod15Exceptions.Explicacao.Application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        method();

        System.out.println("Fim do programa");
    }

    public static void method(){
        System.out.println("Method 1 Starts");
        method2();
        System.out.println("Method 1 Ends");
    }

    public static void method2(){
        System.out.println("Method 2 Start");
        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position!");
            e.printStackTrace();

        }
        catch (InputMismatchException e ){
            System.out.println("Input Error");
        }
        sc.close();
        System.out.println("Method 2 Ends");
    }

}
