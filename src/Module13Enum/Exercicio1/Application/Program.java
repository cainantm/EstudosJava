package Module13Enum.Exercicio1.Application;

import Module13Enum.Exercicio1.Entities.Department;
import Module13Enum.Exercicio1.Entities.Enum.WorkerLevel;
import Module13Enum.Exercicio1.Entities.HourContract;
import Module13Enum.Exercicio1.Entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Enter worker level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        // aqui instancia um trabalhador com os dados indicados acima.

        System.out.print("How many contracts: ");
        int n = sc.nextInt();

        for(int i = 1; i<=n; i++){
            System.out.println("Enter Contract #" + i + " data:");
            System.out.print("Enter date: ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt(); // aqui sao adicinados os dados de cada contrato

            HourContract contract = new HourContract(contractDate, valuePerHour, hours); // aqui é instancia um contrato com os dados adicionados acima
            worker.addContract(contract); // aqui o contrato e os seus dados sao associados ao trabalhador.
            // cada ‘loop’ irá adicionar um novo contrato.

        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2)); // substring é pra cortar a String, o numero zero indica o começo e o 2 o final, no caso do MM/YYYY vao ser os
        //dois primeiros dígitos
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name:" + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
