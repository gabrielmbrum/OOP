package ex6;

public class Vendedor {
    // Fields
    private static double salarioBase = 200;
    private static int qtdVendedores = 0;
    private String nome = "xxxx";
    private double salario = 0d;
    private double valorVendas = 0.0;
    private long cpf = 0L;

    // Constructor
    public Vendedor(String name, double salary, double salesValue, long cpf) {
        nome = name;
        salario = salary + valorVendas*0.09; //salary is equal to baseSalary + 9% of salesValues
        valorVendas = salesValue;
        this.cpf = cpf;
        qtdVendedores++;
    }

    // Getters
    public double getSalarioBase() {
        return salarioBase;
    }

    public static int getQtdVendedores() {
        return qtdVendedores;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public double getValVendas() {
        return valorVendas;
    }

    public long getCpf() {
        return cpf;
    }

    // Setters
    public void setNome(String n) {
        nome = n;
    }

    public void setSalario(double s) {
        salario = s;
    }

    public void setValorVendas(double v) {
        valorVendas = v;
    }

    public void setNovaVenda(double n) {
        valorVendas += n;
        salario += n*0.09; //atualiza o salário com 9% da venda realizada
    }

    public void setId(int cpf) {
        this.cpf = cpf;
    }

    // Others methods
    public void print() {
        System.out.print("\n----------------------------------\n");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Salario: " + this.getSalario());
        System.out.println("Valor de vendas: " + this.getValVendas());
        System.out.println("CPF: " + this.getCpf());
        System.out.print("----------------------------------\n");
    }

}
