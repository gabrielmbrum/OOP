package palindromo;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the string
        System.out.print("Pls, digit a string: ");
        String inp = sc.nextLine();

        // Remove all spaces on the string and put it on Lower Case
        inp = inp.replaceAll("\\s", "").toLowerCase();

        // Initialize and insert the inverted string
        String inpInv = "";
        for (int i = inp.length() - 1; i >= 0; i--)
        {
            inpInv += inp.charAt(i);
        }

        // Check if is it a palindrome
        if (inp.equals(inpInv)) {
            System.out.println("It's a palindrome!!!");
        } else {
            System.out.println("It's a palindrome!!!");
        }
    }
}
