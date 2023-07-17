package Mod15Exceptions.Exercicios.Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Mod15Exceptions.Exercicios.Model.Entities.Reservation;
import Mod15Exceptions.Exercicios.Model.Exception.DomainException;


public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        } catch (ParseException e){ // aqui é feita excepcao pq o parse lança essa excecao
            System.out.println("invalid Date Format");

        } catch (DomainException e){ //aqui é lançada excecao customizada para indicar erro na reserva (datas)
            System.out.println("Error in reservation" + e.getMessage());

        }catch (RuntimeException e){ // aqui é lançado Runtimep para tratar qualquer excecao que seja derivada de uma Runtime Exception
            System.out.println("Unexpected Error");
        }

        sc.close();
    }
}
