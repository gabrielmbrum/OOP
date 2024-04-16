package techgear;

public class Admin {
    private String cpf;
    private String usuario;
    private String senha;

    // constructor
    public Admin(String cpf, String usuario, String senha) {
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
    }

    // getters
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getCPF() { return cpf;}
}
