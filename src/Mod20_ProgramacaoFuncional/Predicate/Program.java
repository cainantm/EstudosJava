package Mod20_ProgramacaoFuncional.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // forma 1 - com classe implementando Predicate<Product>
        list.removeIf(new ProductPredicate());

        // forma 2 - método estático na propria classe Product
        list.removeIf(Product::staticProductPredicate);

        //forma 3 - método comum na propria classe Product
        list.removeIf(Product::nonStaticProductPredicate);

        // forma 4 - Expressão lambda.
        Predicate<Product> pred = p -> p.getPrice() >= 100.00;
        list.removeIf(pred);

        // forma 5 - expressão lambda inline.
        list.removeIf(p -> p.getPrice() >= 100.00);


        for (Product p : list){
            System.out.println(p);
        }
    }
}
