//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;

public class Operacoes {
    public void adicionarAluno(Aluno aluno) throws Exception {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("C:\\Users\\ricar\\IdeaProjects\\Aula23\\src\\alunos.txt", true));
            writer.write(aluno.toString());
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw e;
        } finally {
            writer.close();
        }

    }

    public Aluno buscarAluno(String id) throws Exception {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\ricar\\IdeaProjects\\Aula23\\src\\alunos.txt"));

            for(String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
                if (linha.substring(0, linha.indexOf("|")).equals(id)) {
                    Aluno var4 = this.coverterObjeto(linha);
                    return var4;
                }
            }

            return null;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw e;
        } finally {
            reader.close();
        }
    }

    private Aluno coverterObjeto(String linha) throws IllegalAccessException {
        String[] atributos = linha.split("\\|");
        Aluno alunoDoArquivo = new Aluno();
        Field[] fields = Aluno.class.getDeclaredFields();

        try {
            for(int i = 0; i < fields.length; ++i) {
                fields[i].setAccessible(true);
                fields[i].set(alunoDoArquivo, atributos[i]);
            }

            return alunoDoArquivo;
        } catch (Exception e) {
            throw e;
        }
    }
}
