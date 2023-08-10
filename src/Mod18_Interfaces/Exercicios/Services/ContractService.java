package Mod18_Interfaces.Exercicios.Services;

import Mod18_Interfaces.Exercicios.Entities.Contract;
import Mod18_Interfaces.Exercicios.Entities.Installment;

import java.time.LocalDate;

public class ContractService{

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){

        double basicQuota = contract.getTotalValue()/months; // valor de cada parcela

        for(int i = 1; i<=months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i); // aumentando a data de vencimento em i meses

            double interest = onlinePaymentService.interest(basicQuota, i); // a variável i que vai ser o mês da função
            double fee = onlinePaymentService.paymentFee(basicQuota + interest); // soma da parcela mais o juros
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota));

        }
    }
}
