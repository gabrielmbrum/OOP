package cadastro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Aluno a = new Aluno("a", "geraldo", 6);
        Aluno b = new Aluno("b", "carlos", 10);
        Aluno c;
        CadastroAlunos lista = new CadastroAlunos();

        lista.adicionarAluno(a);
        lista.adicionarAluno(b);
        try {
            c = lista.buscarAluno("a");
            a.validarMatricula();
            b.validarNota();
            lista.removerAluno("c");

        } catch (AlunoInexistenteException | NotaInvalidaException | MatriculaInvalidaException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}