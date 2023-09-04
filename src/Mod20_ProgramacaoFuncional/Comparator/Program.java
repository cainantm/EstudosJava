package Mod20_ProgramacaoFuncional.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

//        essa é uma das formas de fazer um comparator
//        list.sort(new MyComparator()); // tem que passar no argumento um Comparator que é uma interface funcional, que tem apenas um método abstrato,
//        // mas tem varios estaticos e default

        // da forma abaixo é possível implementar o comparator direto no programa principal - criando uma classe anônima

//        Comparator<Product> comp = new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//            }
//        };

        // também é possível declarar com uma função anônima (arrow function)
        // o compilador dispensa que tenha que espeficificar os objetos p1 e p2 com Product (Product p1, product p2)
        // por ser uma linha de função, nao precisa de chaves
        Comparator<Product> comp = (p1, p2) ->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        // é possível também colocar toda a expressão lambda direto no sort:

        list.sort((p1, p2) ->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : list){
            System.out.println(p);
        }
    }
}
