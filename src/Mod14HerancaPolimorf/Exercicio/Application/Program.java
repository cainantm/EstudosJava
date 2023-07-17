package Mod14HerancaPolimorf.Exercicio.Application;

import Mod14HerancaPolimorf.Exercicio.Entities.Employee;
import Mod14HerancaPolimorf.Exercicio.Entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.printf("Quantidade de funcionários:");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++){
            System.out.println("Funcionário #" + i + ":");
            System.out.print("Tercerizado? (y/n)");
            char c = sc.next().charAt(0);
            System.out.print("Nome:");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Horas: ");
            int horas = sc.nextInt();
            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            if(c == 'y'){
                System.out.print("Taxa adicional: ");
                double taxaAdicional = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(nome, horas, valorPorHora, taxaAdicional);
                list.add(emp);
                // poderia fazer assim tbm list.add(new OutsourcedEmployee(nome, horas, valorPorHora, taxaAdicional));
            } else {
                Employee emp = new Employee(nome,horas,valorPorHora);
                list.add(emp);
                // poderia fazer assim tbm list.add(new Employee(nome,horas,valorPorHora));
            }
        }
        System.out.println();
        System.out.println("Pagamentos: ");

        for (Employee emp : list){
            System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
        }

    }
}
