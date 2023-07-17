package Mod14HerancaPolimorf.ExercicioProposto.Application;

import Mod14HerancaPolimorf.ExercicioProposto.Entities.Company;
import Mod14HerancaPolimorf.ExercicioProposto.Entities.Individual;
import Mod14HerancaPolimorf.ExercicioProposto.Entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++){
            System.out.println("Tax payer #" + i + ":");
            System.out.print("Individual or Company (i/c)? ");
            char c = sc.next().charAt(0);

            if (c == 'i'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Annual income: ");
                double annualIncome = sc.nextDouble();
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();

                list.add(new Individual(name, annualIncome, healthExpenditures));

            } else {
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Annual income: ");
                double annualIncome = sc.nextDouble();
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();

                list.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        for(TaxPayer taxPayer : list){
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f" , taxPayer.tax()));
        }

        System.out.println();

        double sum = 0;
        for(TaxPayer taxPayer : list){
            sum += taxPayer.tax();
        }
        System.out.println("TOTAL TAXES: " + String.format("%.2f", sum));

        sc.close();
    }
}
