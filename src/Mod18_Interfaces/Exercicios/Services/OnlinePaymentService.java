package Mod18_Interfaces.Exercicios.Services;

public interface OnlinePaymentService {

    double paymentFee(double amount);
    double interest(double amount, int months);

}
