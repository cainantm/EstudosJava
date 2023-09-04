package Mod20_ProgramacaoFuncional.Predicate;

import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {

    // classe que implementa o Predicate
    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }
}
