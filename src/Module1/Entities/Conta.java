package Module1.Entities;

public class Conta {

    private String nome;
    private int numeroConta;
    private double valor;

    public Conta() {

    }

    public Conta(String nome, int numeroConta, double valor) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.valor = valor;
    }

    public Conta(String nome, int numeroConta) {
        this.nome = nome;
        this.numeroConta = numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getValor() {
        return valor;
    }

    public void deposito(double valor) {
        this.valor += valor;
    }

    public void saque(double valor) {
        this.valor = this.valor - valor - 5;
    }

    public String toString(){
        return "Account "
                + numeroConta
                + ", Holder: "
                + nome
                + ", Balance: $ "
                + String.format("%.2f", valor);
    }
}
