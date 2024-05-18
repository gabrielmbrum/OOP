import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Map<Integer, Pessoa> m = new HashMap<Integer, Pessoa>();

        m.put(1, new Pessoa("123", "Roberto"));
        m.put(2, new Pessoa("124", "Lucas"));

        if (m.containsKey(1)) {
            System.out.println("key: " + 1 + " | cpf: " + m.get(1).getCpf());
        } else {
            System.out.println("Não contém ID 1!!");
        }
    }
}