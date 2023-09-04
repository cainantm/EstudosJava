package Mod20_ProgramacaoFuncional.FunctionFunction;

import Mod20_ProgramacaoFuncional.FunctionFunction.Product;

import java.util.ArrayList;
import java.util.List;

public class FunctionFunction {
    public static void main(String[] args) {

        // Função que eu criei que recebe uma função

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));


        // como foi ajustado na classe ProductService, aqui é adicionado a condição para filtrar a lista.

        ProductService ps = new ProductService();
        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
