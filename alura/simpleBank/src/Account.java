public class Account {
    private String name;
    private String cpf;
    private Double balance;

    public Account(String name, String cpf, Double balance) {
        this.name = name;
        this.cpf = cpf;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public  Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
