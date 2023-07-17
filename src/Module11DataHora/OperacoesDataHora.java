package Module11DataHora;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class OperacoesDataHora {
    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-05-20T01:30:26");
        Instant d06 = Instant.parse("2022-05-20T01:30:26Z");

        LocalDate pastWeekLocalDate = d04.minusWeeks(1);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        System.out.println(pastWeekLocalDate);
        System.out.println(nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusWeeks(1);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        System.out.println(pastWeekLocalDateTime);
        System.out.println(nextWeekLocalDateTime);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println(pastWeekInstant);
        System.out.println(nextWeekInstant);

        System.out.println("DURAÇÃO -----------------------------");

        // Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay()); usando o atStartOfDay o calculo vai ser a partir do começo do dia (meia noite)

        Duration t2 = Duration.between(pastWeekLocalDate.atTime(0,0), d04.atTime(0,0)); // nao tem como calcular duração entre dois LocalDate,
        // precisa converter para localdatetime
        // precisa colocar o atTime para indicar a hora a ser usada (de forma que converte para LocalDateTime)
        System.out.println(t2.toDays());

        Duration t1 = Duration.between(pastWeekLocalDateTime, d05);
        System.out.println(t1.toDays());

        Duration t3 = Duration.between(pastWeekInstant, d06);
        System.out.println(t3.toDays());

        Duration t4 = Duration.between(d06, pastWeekInstant); // se colocar o valor atual antes, o resultado fica negativo
        System.out.println(t4.toDays());

    }
}
