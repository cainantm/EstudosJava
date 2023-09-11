package Mod20_ProgramacaoFuncional.ExercicioFixacao;

import Mod20_ProgramacaoFuncional.ExercicioResolvido.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            // descobrindo pessoas com o salário maior que do que indicado
            System.out.print("Enter salary: ");
            Double salary = sc.nextDouble();

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> email = list.stream()
                    .filter(e -> e.getSalary() > salary)
                    .map(e -> e.getEmail())
                    .sorted(comp)
                    .toList();

            email.forEach(System.out::println);

            // encontrando a soma do salário de todos que começam com M

            double sum = list.stream()
                            .filter(e -> e.getName().charAt(0) == 'M')
                            .map(e -> e.getSalary())
                            .reduce(0.0, (x,y) -> x+y);

            System.out.println("Sum of salary of people whose name starts with 'M': $" + String.format("%.2f", sum));


        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        sc.close();

    }
}
