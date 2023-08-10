package Mod18_Interfaces.Explicacao.Comparable;

public class Employee implements Comparable<Employee>{

    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // o compareTo faz a comparação e o resultado é em número, ex:
    // "maria" compareTo("alex") return 12 - significa que maria é maior que alex na ordem alfabética
    // "alex" compareTo("maria") return -12 - significa que alex é menor que maria na ordem alfabética
    // "maria" compareTo("maria") return 0 - significa que tem o mesmo valor na ordem alfabética

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.getName());
    }

//      para ordenar por salário crescente:
//    @Override
//    public int compareTo(Employee o) {
//        return salary.compareTo(o.getSalary());
//    }

    //      para ordenar por salário decrescente:
//    @Override
//    public int compareTo(Employee o) {
//        return -salary.compareTo(o.getSalary());
//    }
}
