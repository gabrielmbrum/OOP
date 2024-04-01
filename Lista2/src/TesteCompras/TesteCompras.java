package TesteCompras;

public class TesteCompras {
    public static void main(String[] args) {
        Produto batata, macarrão, molho;
        CarrinhoCompras a, b, c;

        batata = new Produto("BATATA", 3.5, 40);
        macarrão = new Produto("MACARRÃO", 5, 30);
        molho = new Produto("MOLHO", 7.3, 20);


        a = new CarrinhoCompras(30);
        a.addProduto(batata, 3);
        a.addProduto(macarrão, 1);
        a.addProduto(molho, 2);
        a.finalizarCompra();

        batata.print();
        macarrão.print();
        molho.print();

    }
}
