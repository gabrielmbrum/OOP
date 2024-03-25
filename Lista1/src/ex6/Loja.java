package ex6;

import java.util.Scanner;

public class Loja {
    private static final int MAX = 50;
    private static int count = 0;
    public static void main(String[] args) {
        // Variables
        int op = 0;
        Scanner sc = new Scanner(System.in);
        Vendedor[] vendedores = new Vendedor[MAX];

        // Operations
        while (op != -1) {
            System.out.print("\nDigite a operação que deseja realizar:\n\t1 - criar vendedor\n\t2 - definir novo salario pelo ID\n\t3 - inserir nova venda pelo ID\n\t4 - pegar ID pelo CPF\n\t5 - conferir quantidade de vendedores\n\t6 - total do valor de vendas\n\t7 - exibir todos vendedores\n\t-1 - sair;\n\nOp: ");
            op = sc.nextInt();
            sc.nextLine();

            // Prevents operations with a null salesman array
            if (count == 0 && op > 1 ) {
                System.out.println("\nNÃO HÁ VENDEDORES CADASTRADOS!!\nCADASTRE UM DIGITANDO 1");
                op = 0;
            }

            switch (op) {

                case -1 : break;

                case 1: //criar Vendedor
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o salario: ");
                    double salario = sc.nextDouble();

                    System.out.print("Digite o valor de vendas (TOTAL): ");
                    double valVen = sc.nextDouble();

                    System.out.print("Digite o CPF: ");
                    long cpf = sc.nextLong();

                    vendedores[count++] = new Vendedor(nome, salario, valVen, cpf);

                    break;

                case 2: //definir novo salario pelo ID
                    char flag = 's';
                    while (flag == 's') {
                        System.out.print("\nDigite o ID: ");
                        int id = sc.nextInt();

                        // Show the values contained in the ID inputted to check if it's correct
                        System.out.println("\nVocê deseja alterar o salario de " + vendedores[id].getNome() + ", de CPF: " + vendedores[id].getCpf());
                        System.out.print("Digite <s/n>: ");
                        flag = sc.next().charAt(0);

                        if (flag == 'n') {
                            System.out.print("\nVocê deseja tentar novamente?: ");
                            System.out.print("Digite <s/n>: ");
                            flag = sc.next().charAt(0);
                        }
                        else {
                            System.out.print("Digite o novo salário: ");
                            double newSalario = sc.nextDouble();
                            vendedores[id].setSalario(newSalario);
                            break;
                        }
                    }
                    break;

                case 3: //inserir nova venda pelo ID
                    flag = 's';
                    while (flag == 's') {
                        System.out.print("\nDigite o ID: ");
                        int id = sc.nextInt();

                        // Show the values contained in the ID inputted to check if it's correct
                        System.out.println("\nVocê deseja adicionar uma venda de " + vendedores[id].getNome() + ", de CPF: " + vendedores[id].getCpf());
                        System.out.print("Digite <s/n>: ");
                        flag = sc.next().charAt(0);

                        if (flag == 'n') {
                            System.out.print("\nVocê deseja tentar novamente?: ");
                            System.out.print("Digite <s/n>: ");
                            flag = sc.next().charAt(0);
                        }
                        else if (flag == 's') {
                            System.out.print("Digite o valor da nova venda: ");
                            double newVen = sc.nextDouble();
                            vendedores[id].setNovaVenda(newVen);
                            break;
                        }
                        else {
                            System.out.println("Ação inserida inválida!!\nERROR!!");
                            flag = 's';
                        }
                    }
                    break;

                case 4: //pegar "ID" pelo CPF // ID é a posição no vetor 'vendedores'
                    System.out.print("\nDigite o CPF que deseja procurar: ");
                    long search = sc.nextLong();
                    int aux = getIdByCpf(vendedores, search);
                    if (aux != -1)
                        System.out.println("\nO ID é: " + aux);
                    else
                        System.out.println("\nCPF NÃO CADASTRADO!!!");

                    break;

                case 5: //conferir quantidade de vendedores
                    System.out.println("\nA loja possui " + vendedores[0].getQtdVendedores() + " vendedores");
                    break;

                case 6: //ver valor total vendido
                    double total = 0.0;
                    for (int i = 0; i < count; i++)
                        total += vendedores[i].getValVendas();

                    System.out.println("\nO VALOR TOTAL DE VENDAS É: R$" + total);
                    break;

                case 7: //imprimir todos os vendedores
                    for (int i = 0; i < count; i++)
                        vendedores[i].print();
                    break;

                default:
                    System.out.println("\nOPERAÇÃO INDISPONÍVEL!!!");
            }
        }
    }

    private static int getIdByCpf(Vendedor[] v, long search) {
        long aux;
        for ( int i = 0 ; i < count ; i++ ){
            aux = v[i].getCpf();
            if(aux == search) {
                return i;
            }
        }
        return -1;
    }
}
