package Serializable;

import java.io.*;

public class SerializarPessoa {

    public static void main(String[] args) throws Exception {
        // Criar objeto Pessoa
        Pessoa pessoa = new Pessoa("João Silva", 35);

        // Criar fluxo de saída para arquivo
        FileOutputStream fileOut = new FileOutputStream("pessoa.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        // Gravar objeto Pessoa no arquivo
        out.writeObject(pessoa);

        // Fechar fluxos
        out.close();
        fileOut.close();

        ObjectInputStream in;
        Pessoa inputPessoa;
        try {
            in = new ObjectInputStream(new FileInputStream("pessoa.dat"));
            inputPessoa = (Pessoa) in.readObject();
            System.out.println("nome: " + inputPessoa.getNome() + "\nidade: " + inputPessoa.getIdade());
            inputPessoa.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Objeto Pessoa serializado com sucesso em pessoa.dat");
    }
}

