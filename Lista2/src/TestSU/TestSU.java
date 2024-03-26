package TestSU;

import java.util.Scanner;

public class TestSU {
    public static void main(String[] args) {
        String a = "ovo";
        String b = "bola";

        System.out.println(StringUtils.palindromo(b));
        System.out.println(StringUtils.palindromo(a));
        System.out.println(StringUtils.paraMaiscula(a));
        System.out.println(StringUtils.paraMaiscula(b));
    }
}
