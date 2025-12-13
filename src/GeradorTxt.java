import java.io.FileWriter;
import java.lang.reflect.Field;

public class GeradorTxt {
    public static void gerarArquivo(Object obj, String nomeArquivo) throws Exception {
        FileWriter writer = new FileWriter(nomeArquivo);

        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();

        writer.write("<aluno>" + "\n");

        for (Field field : fields) {
            field.setAccessible(true);
            Object valor = field.get(obj);
            writer.write("<" + field.getName() + ">" + valor + "</" + field.getName() + ">" + "\n");
        }

        writer.write("</aluno>" + "\n");

        writer.close();
    }
}