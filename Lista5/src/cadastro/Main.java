package cadastro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Aluno a = new Aluno("", "geraldo", 10);

        try {
            a.validarNota();
            a.validarMatricula();
        } catch (NotaInvalidaException | MatriculaInvalidaException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}