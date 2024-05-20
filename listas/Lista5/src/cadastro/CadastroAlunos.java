package cadastro;

import cadastro.exceptions.AlunoInexistenteException;
import cadastro.exceptions.MatriculaInvalidaException;
import cadastro.exceptions.NotaInvalidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroAlunos {
    List<Aluno> alunos;

    // construtor
    public CadastroAlunos() {
        alunos = new ArrayList<Aluno>();
    }

    // métodos
    public void adicionarAluno (Aluno aluno) {
        alunos.add(aluno);
    }

    public void adicionarAlunoInterativo () {
        Scanner sc = new Scanner(System.in);
        String matricula, nome;
        double nota;
        boolean done = false;

        System.out.print("Matrícula: ");
        matricula = sc.nextLine();

        System.out.print("Nome: ");
        nome = sc.nextLine();

        System.out.print("Nota: ");
        nota = sc.nextDouble();

        Aluno a = new Aluno(matricula, nome, nota);

        while (!done) {
            try {
                a.validarNota();
                a.validarMatricula();
                done = true;
            } catch (NotaInvalidaException e) {
                System.err.println("ERROR: " + e.getMessage());

                System.out.print("INSIRA NOVAMENTE A NOTA: ");
                nota = sc.nextDouble();
                a.setNota(nota);

            } catch (MatriculaInvalidaException e) {
                System.err.println("ERROR: " + e.getMessage());

                System.out.print("INSIRA NOVAMENTE A MATRICULA: ");
                matricula = sc.nextLine();
                a.setMatricula(matricula);
            }
        }

        alunos.add(a);

    }

    public void removerAluno (String matricula) throws AlunoInexistenteException {
        alunos.removeIf(a -> a.getMatricula().equals(matricula));
        throw new AlunoInexistenteException("Aluno Inexistente!!");
    }

    public Aluno buscarAluno (String matricula) throws AlunoInexistenteException {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula))
                return a;
        }
        throw new AlunoInexistenteException("Aluno Inexistente!!");
    }

    public void listarAluno () {
        System.out.println("\n-------- Alunos Cadastrados --------");
        for (Aluno a : alunos) {
            a.printAluno();
        }
    }
}
