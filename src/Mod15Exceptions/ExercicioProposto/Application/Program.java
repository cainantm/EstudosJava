package Mod15Exceptions.ExercicioProposto.Application;

import Mod15Exceptions.ExercicioProposto.Model.Entities.Account;
import Mod15Exceptions.ExercicioProposto.Model.Exception.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        try {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw Limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, name, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);

            System.out.println("New balance: $" + String.format("%.2f",account.getBalance()));

        }
        catch (DomainException e){
            System.out.println("Withdraw error:" + e.getMessage());
        }

    }
}
