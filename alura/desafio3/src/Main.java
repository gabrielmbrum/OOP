import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new LinkedList<>();

        System.out.print("Digite o limite do cartão: ");
        double cartLimit = sc.nextDouble();

        int op = 1;
        while (op != 0) {
            System.out.print("Digite o valor: ");
            double value = sc.nextDouble();
            sc.nextLine();

            if (value > cartLimit) {
                System.out.println("Saldo insuficiente!!!!");
                System.out.println("Saldo Atual: $" + cartLimit);
            } else {
                System.out.print("Digite o nome: ");
                String name = sc.nextLine();

                Product newProduct = new Product(value, name);
                products.add(newProduct);
                cartLimit -= value;
            }

            System.out.println("1 - comprar novamente | 0 - sair");
            op = sc.nextInt();
            sc.nextLine();
        }

        Collections.sort(products);

        System.out.println("Lista de produtos comprados:");
        products.forEach(product -> System.out.println(product.toString()));

        System.out.println("Saldo Atual: $" + cartLimit);
    }
}