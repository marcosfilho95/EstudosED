import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String linhas, removido;
        int n, base, numero;

        while (!(linhas = in.readLine()).equals("0")) {
            n = Integer.parseInt(linhas);
            if (n == 1) {
                out.println("Discarded cards:");
                out.println(1);
            } else {
                base = 1;
                List<Integer> cartas = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    cartas.add(i);
                }
                base = 2;
                boolean f = true;
                removido = "";
                while (cartas.size() > 1) {
                    for (Iterator<Integer> iterator = cartas.iterator(); iterator.hasNext();) {
                        numero = iterator.next();
                        if (base == 2) {
                            base = 0;
                            removido += numero + ", ";
                            iterator.remove();
                        }
                        base++;
                    }
                }
                out.println("Discarded cards: " + removido.substring(0, removido.length() - 2));
                out.println("Remaining card: " + cartas.get(0));
            }
        }
        out.close();
    }

}
