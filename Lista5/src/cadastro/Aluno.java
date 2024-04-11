package cadastro;

public class Aluno {
    private String matricula;
    private String nome;
    private double nota;

    // construtor
    public Aluno (String matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    // getters and setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // métodos
    public void validarNota () throws NotaInvalidaException {
        if (nota < 0 || nota > 10)
            throw (new NotaInvalidaException("Nota Inválida!!"));
        System.out.println("Nota válida!!");
    }

    public void validarMatricula () throws MatriculaInvalidaException {
        if (matricula == null) {
            throw new MatriculaInvalidaException("Matrícula nula");
        }
        System.out.println("Matrícula validada!!");
    }
}
