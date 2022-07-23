import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        int n;
        Scanner prompt = new Scanner(System.in);
        System.out.println("Digite um valor para n: ");
        n = prompt.nextInt();
        String[] arrayDeStrings = new String[n];

        for(int indice = 0; indice < n; indice++) {
            Scanner prompt2 = new Scanner(System.in);
            arrayDeStrings[indice] = prompt2.nextLine();
            ArrayList<String> comprasSupermercado = new ArrayList<String>(Arrays.asList(arrayDeStrings[indice].split(" ")));
            arrayDeStrings[indice] = "";
            Collections.sort(comprasSupermercado);
            for (String s : comprasSupermercado) {
                if (!arrayDeStrings[indice].contains(s)) {
                    if (s == comprasSupermercado.get(comprasSupermercado.size() - 1)) {
                        arrayDeStrings[indice] += s;
                        break;
                    }
                    arrayDeStrings[indice] += s + " ";
                }
            }
        }
        for(String s : arrayDeStrings){
            System.out.println(s);
        }
    }
}

/*n = leia_inteiro
        para i de 1 até n faça
        linha = leia_texto.divida(" ").ordene
        var ultimo := ""
        var lista := [""].cauda
        para item em linha faça
        se item <> ultimo então
        lista := lista + [item]
        ultimo := item
        fim
        fim
        escreva lista.junte(" ")
        fim*/
