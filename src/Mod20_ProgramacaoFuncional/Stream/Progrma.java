package Mod20_ProgramacaoFuncional.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Progrma {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,4,5,10,7);

        //transformando uma lista em stream
        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // Criando uma stream a partir do stream.of
        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray())); // o to array é para transformar a stream em vetor e poder imprimi-la

        // Criando uma stream a partir do iterate, onde é indicado o valor inicial e a condição para os proximos valores
        Stream<Integer> st3 = Stream.iterate(0, x-> x+2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        // fazendo a sequencia de fibonacci com iterate
        Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p-> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

    }
}
