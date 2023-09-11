package Mod20_ProgramacaoFuncional.ExercicioResolvido;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Product> list = new ArrayList<>();

            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            // usando pipeline para pegar o processo dos produtos e somar e saber a média
            double avg = list.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0, (x,y) -> x+y) / list.size();

            System.out.println("Average price: " + String.format("%.2f", avg));

            //impressão dos nomes do produtos que estão abaixo da média
            // o comparator é utilizado para colocar a lista resultante em ordem alfabética

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = list.stream()
                    .filter(p -> p.getPrice() < avg)
                    .map(p -> p.getName())
                    .sorted(comp.reversed()) // aqui o reversed é usado para inverter a ordem alfabética
                    .toList();

            names.forEach(System.out::println);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        sc.close();

    }
}
