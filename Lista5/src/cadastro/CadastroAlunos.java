package cadastro;

import java.util.ArrayList;
import java.util.List;

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

    public void removerAluno (String matricula) throws AlunoInexistenteException{
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
}
