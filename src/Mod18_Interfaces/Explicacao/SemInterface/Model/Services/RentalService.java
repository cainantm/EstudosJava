package Mod18_Interfaces.Explicacao.SemInterface.Model.Services;

import Mod18_Interfaces.Explicacao.SemInterface.Entities.CarRental;
import Mod18_Interfaces.Explicacao.SemInterface.Entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes/60; // pegar a fração das horas para arredondar
        double basicPayment;


        if (hours <= 12){
            basicPayment = pricePerHour * Math.ceil(hours); // arredondando pra cima
        } else {
            basicPayment = pricePerDay * Math.ceil(hours/24); // divide por 24 para achar a duração em dias
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
