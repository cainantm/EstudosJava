package Module1.Application;

import Module1.Entities.Conta;

import java.util.Locale;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Conta conta;

        System.out.print("Enter account number:");
        int numeroConta = sc.nextInt();
        System.out.print("Enter account holder:");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Is there an initial deposit? (y/n)?");
        char decisao = sc.next().charAt(0);

        if (decisao == 'y'){
            System.out.print("Enter initial deposit value:");
            double valorInicial = sc.nextDouble();
            conta = new Conta(nome, numeroConta, valorInicial);
        } else {
            conta = new Conta(nome, numeroConta);
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.println(conta);

        System.out.println();
        System.out.print("Enter a deposit value: ");
        double valorDeposito = sc.nextDouble();
        conta.deposito(valorDeposito);
        System.out.println("Updated account data");
        System.out.println(conta);

        System.out.println();
        System.out.print("Enter withdraw value: ");
        double valorSaque = sc.nextDouble();
        conta.saque(valorSaque);
        System.out.println("Updated account data: ");
        System.out.println(conta);

        sc.close();
    }
}