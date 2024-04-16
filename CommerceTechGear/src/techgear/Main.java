package techgear;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Admin admin = new Admin("12345678911", "admin", "admin");
        Loja loja = new Loja("TechGear");
        DisplayLoja display = new DisplayLoja(loja, admin, new Carrinho());

        display.telaPrincipal();
    }
}