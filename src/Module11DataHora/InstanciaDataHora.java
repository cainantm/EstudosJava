package Module11DataHora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class InstanciaDataHora {

    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now(); // vai gerar a hora GMT



        Instant d07 = Instant.parse("2022-05-20T01:30:26-03:00");
        LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);

        LocalDate d10 = LocalDate.of(2022,7,20);
        LocalDateTime d11 = LocalDateTime.of(2022,7,20,1,30);

        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(d07);
        System.out.println(d08);
        System.out.println(d09);
        System.out.println(d10);
        System.out.println(d11);

        System.out.println("-----------------------------------------------");

        LocalDate d04 = LocalDate.parse("2022-05-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-05-20T01:30:26");
        Instant d06 = Instant.parse("2022-05-20T01:30:26Z");

        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt6 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt7 = DateTimeFormatter.ISO_INSTANT;

        System.out.println(d04.format(fmt3)); // chamar a data com a formataçao
        System.out.println(fmt3.format(d04)); // chamar a formatação com a data

        System.out.println(d05.format(fmt3));
        System.out.println(fmt4.format(d05));


        System.out.println(fmt5.format(d06)); // nao tem como chamar o format do Instant, então tem que chamar pela formatação - a hora com fuso nao aceita ser formatada por
        // uma formatação sem fuso.
        System.out.println(fmt7.format(d06));

        System.out.println(fmt6.format(d05));

        System.out.println("------------------------------------------");

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

        System.out.println(d04.getDayOfMonth());
        System.out.println(d04.getMonthValue());
        System.out.println(d04.getMonth());















    }
}
