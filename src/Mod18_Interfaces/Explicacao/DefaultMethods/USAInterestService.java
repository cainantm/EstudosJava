package Mod18_Interfaces.Explicacao.DefaultMethods;

import java.security.InvalidParameterException;

public class USAInterestService implements InterestService{

    private double interestRate;

    public USAInterestService(double interestRate) {
        this.interestRate = interestRate;
    }
    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
