import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Teste {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String nTrilhos = leia.nextLine();
        ArrayList<String> A;
        Stack<Integer> estacao = new Stack<Integer>();
        Stack<Integer> B = new Stack<Integer>();
        ArrayList<String> saidas = new ArrayList<String>();
        while(!nTrilhos.equals("0")){
           String numeroVagoes = leia.nextLine();
           boolean verifica = true;
            while(!numeroVagoes.equals("0")){
                A = new ArrayList<String>(Arrays.asList(numeroVagoes.split(" ")));
                int atual = Integer.parseInt(nTrilhos);
                while (B.size() != Integer.parseInt(nTrilhos)){
                    if(!A.isEmpty()) {
                        if (A.get(A.size() - 1) == "" + atual) {
                            B.push(atual);
                            A.remove(A.size() - 1);
                            atual--;
                        }
                        else if(!estacao.isEmpty() && estacao.peek() == atual){
                            estacao.pop();
                            B.push(atual);
                            atual--;
                        }
                        else{
                            estacao.push(Integer.parseInt(A.get(A.size()-1)));
                            A.remove(A.size()-1);
                        }
                    }
                    else{
                        if(estacao.peek() == atual){
                            estacao.pop();
                            B.push(atual);
                            atual--;
                        }
                        else{
                            saidas.add("No");
                            verifica = false;
                            break;
                        }
                    }
                }
                estacao.removeAllElements();
                if(verifica == true){
                    saidas.add("Yes");
                }
                verifica = true;
                B.removeAllElements();
                numeroVagoes = leia.nextLine();
            }
            saidas.add("");
            nTrilhos = leia.nextLine();
        }
        for(String s : saidas){
            System.out.println(s);
        }
    }
}