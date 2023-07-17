package Mod14HerancaPolimorf.Explicacao.Application;

import Mod14HerancaPolimorf.Explicacao.Entities.Account;
import Mod14HerancaPolimorf.Explicacao.Entities.BusinessAccount;
import Mod14HerancaPolimorf.Explicacao.Entities.SavingsAccount;

public class Program2 {
    public static void main(String[] args) {

        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withdraw(200);
        System.out.println(acc1.getBalance());

        Account acc2 = new SavingsAccount(1002, "George", 1000.0, 0.01);
        acc2.withdraw(200);
        System.out.println(acc2.getBalance());

        Account acc3 = new BusinessAccount(1003, "Maria", 1000.0, 100.0);
        acc3.withdraw(200);
        System.out.println(acc3.getBalance());


    }
}
