package Mod20_ProgramacaoFuncional.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        //aqui vamos fazer uma function receber uma lista de produtos e retornar uma lista com o nome do produto em caixa alta

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //aqui vamos usar a função map, e não a estrutura de dados Map, esta serve para aplicar uma função aos elementos de uma stream, produzindo uma nova lista.
        // essa função map só funciona para stream e não para list.

        // forma 1 - com classe implementando Function<Product, String>
        List<String> names = list.stream().map(new UppercaseName()).toList();

        // forma 2 - método estático na propria classe Product
        List<String> names1 = list.stream().map(Product::staticUpperCaseName).toList();

        //forma 3 - método comum na propria classe Product
        List<String> names2 = list.stream().map(Product::nonStaticUpperCaseName).toList();

        // forma 4 - Expressão lambda.
        Function<Product, String> fun = p -> p.getName().toUpperCase();
        List<String> names3 = list.stream().map(fun).toList();

        // forma 5 - expressão lambda inline.
        List<String> names4 = list.stream().map(p -> p.getName().toUpperCase()).toList();

        names.forEach(System.out::println);

    }
}
