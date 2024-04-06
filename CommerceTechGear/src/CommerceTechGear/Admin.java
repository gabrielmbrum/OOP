package CommerceTechGear;

import java.util.Scanner;

public class Admin {
    private String CPF;
    private String usuario;
    private String senha;

    // constructor
    public Admin(String CPF, String usuario, String senha) {
        this.CPF = CPF;
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
}
