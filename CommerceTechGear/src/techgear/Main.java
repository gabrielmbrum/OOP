package techgear;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // creating objects
        Admin admin = new Admin("12345678911", "admin", "admin");
        Loja loja = new Loja("TechGear");
        DisplayLoja display = new DisplayLoja(loja, admin, new Carrinho());

        display.telaPrincipal();

    }
}