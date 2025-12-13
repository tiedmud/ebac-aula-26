import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Operacoes op = new Operacoes();

        String operacao = "";

        List<Aluno> listaAluno = new ArrayList<Aluno>();
        GeradorTxt geradorTxt = null;

        do {
            System.out.printf("Digite a operação:\n1 - Adicionar aluno\n2 - Buscar aluno\n3 - Sair\n");
            operacao = scanner.nextLine();

            switch (operacao) {
                case "1":
                    System.out.printf("Digite a matrícula:\n");
                    String matricula = scanner.nextLine();
                    System.out.printf("Digite o nome:\n");
                    String nome = scanner.nextLine();
                    System.out.printf("Digite o curso:\n");
                    String curso = scanner.nextLine();
                    Aluno aluno = new Aluno();
                    aluno.setMatricula(matricula);
                    aluno.setNome(nome);
                    aluno.setCurso(curso);

                    geradorTxt = new GeradorTxt();
                    GeradorTxt.gerarArquivo(aluno, "alunos.xml");

                    op.adicionarAluno(aluno);
                    break;

                case "2":
                    System.out.printf("Digite a matrícula do cliente:\n");
                    String matriculaBuscado = scanner.nextLine();
                    Aluno alunoBuscado = op.buscarAluno(matriculaBuscado);
                    if (Objects.nonNull(alunoBuscado)) {
                        System.out.printf("Dados do aluno buscado:\n" + String.valueOf(alunoBuscado) + "\n");
                    } else {
                        System.out.printf("Cliente não encontrado:\n");
                    }
                break;
                default:
                break;
            }
        } while(operacao.equals("1") || operacao.equals("2"));
    }
}
