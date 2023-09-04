package Mod20_ProgramacaoFuncional.FunctionFunction;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    //aqui a classe esta presa pois a condição que é testada, está no If dentro da função, para alterar é preciso abrir a classe e alterar
    // para que isso nao aconteça é necessário que essa condição que será testada, no caso a letra inicial da palavra, venha junto como argumento da função

    public double filteredSum(List<Product> list, Predicate<Product> criteria) {
        double sum = 0.0;
        for (Product p : list){
            if(criteria.test(p)){
                sum += p.getPrice();
            }
        }
        return sum;
    }

}
