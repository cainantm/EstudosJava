package Mod20_ProgramacaoFuncional.Function;

import java.util.function.Function;

public class UppercaseName implements Function<Product, String> {
    //aqui implementamos o function e declaramos que ele receberá um product e retornará uma string

    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}
