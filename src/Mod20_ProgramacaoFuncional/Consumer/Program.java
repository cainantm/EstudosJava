package Mod20_ProgramacaoFuncional.Consumer;

import Mod20_ProgramacaoFuncional.Predicate.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // forma 1 - com classe implementando Consumer<Product>
        list.forEach(new PriceUpdate());

        // forma 2 - método estático na propria classe Product
        list.forEach(Product::staticPriceUpdate);

        //forma 3 - método comum na propria classe Product
        list.forEach(Product::nonStaticPriceUpdate);

        // forma 4 - Expressão lambda.
        Consumer<Product> consumer = p -> {
            p.setPrice(p.getPrice() * 1.1);
        };
        list.forEach(consumer);

        // forma 5 - expressão lambda inline.
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        list.forEach(System.out::println);
    }
}
