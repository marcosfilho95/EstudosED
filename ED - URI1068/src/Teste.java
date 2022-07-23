import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        String equacao;
        while(leia.hasNextLine()){
            boolean vericar = true;
            int contador = 0;
            equacao = leia.nextLine();
            List<String> equacoes = new ArrayList<String>(Arrays.asList(equacao.split("")));
            for(String s: equacoes){
                if(s.equals(")")){
                    contador--;
                    if(contador < 0){
                        vericar = false;
                        break;
                    }
                }
                else if(s.equals("(")){
                    contador++;
                }
            }
            if(contador == 0){
                System.out.println("correct");
            }
            else if(vericar == false || contador != 0) {
                System.out.println("incorrect");
            }
        }
    }
}
