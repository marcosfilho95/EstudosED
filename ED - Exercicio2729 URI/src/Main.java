import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        Scanner prompt = new Scanner(System.in);
        n = prompt.nextInt();
        String[] arrayDeStrings = new String[n];
        arrayDeStrings[0] = prompt.nextLine();
        for(int indice = 0; indice < n; indice++) {
            arrayDeStrings[indice] = prompt.nextLine();
            ArrayList<String> comprasSupermercado = new ArrayList<String>(Arrays.asList(arrayDeStrings[indice].split(" ")));
            arrayDeStrings[indice] = "";
            Collections.sort(comprasSupermercado);
            for (String s : comprasSupermercado) {
                if (!arrayDeStrings[indice].contains(s)) {
                    arrayDeStrings[indice] += s + " ";
                }
            }
            StringBuffer sb = new StringBuffer(arrayDeStrings[indice]);
            sb.delete(arrayDeStrings[indice].length()-1, arrayDeStrings[indice].length());
            arrayDeStrings[indice] = sb.toString();
        }
        prompt.close();
        for(String s : arrayDeStrings){
            System.out.println(s);
        }
    }
}