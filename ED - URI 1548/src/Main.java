import java.io.IOException;
import java.util.Scanner;

 public class Main {

    public static class No{
        // No do tipo int
        public int elemento_armazenado;
        public int posicao;
        public No proximo_no;
        public No anterior_no;

        public No(int valor, int posicao){
            this.elemento_armazenado = valor;
            this.posicao = posicao;
            this.proximo_no = null;
            this.anterior_no = null;
        }
    }
    public static class Fila{
       private No inicioFila;
       private No finalFila;
       private int contador;

        public Fila(){
            this.inicioFila = null;
            this.finalFila = null;
            this.contador = 0;
        }

        public void enfileirar_Fila(int Dado, int Posicao) {
            No novoNo = new No(Dado, Posicao);
            if (inicioFila == null){
                inicioFila = novoNo;
                finalFila = novoNo;
            }
            else if (novoNo.elemento_armazenado > inicioFila.elemento_armazenado) {
                novoNo.proximo_no = inicioFila;
                inicioFila.anterior_no = novoNo;
                inicioFila = novoNo;
            } else if (novoNo.elemento_armazenado < finalFila.elemento_armazenado) {
                finalFila.proximo_no = novoNo;
                novoNo.anterior_no = finalFila;
                finalFila = novoNo;
            } else {
                No noAux = inicioFila;
                No noAux2 = null;
                while (noAux != null && novoNo.elemento_armazenado < noAux.elemento_armazenado) {
                    noAux2 = noAux;
                    noAux = noAux.proximo_no;
                }
                noAux2.proximo_no = novoNo;
                novoNo.anterior_no = noAux2;
                novoNo.proximo_no = noAux;
                noAux.anterior_no = novoNo;
            }
            contador++;
        }
        public void limpar_Fila(){
            inicioFila = null;
            finalFila = null;
            contador = 0;
        }
        public void mostrar_NaoTrocados(){
            int i = 0;
            int naoTrocou = 0;
            for(No NoAux = inicioFila; NoAux != null; NoAux = NoAux.proximo_no){
                if(NoAux.posicao == i){
                    naoTrocou++;
                }
                i++;
            }
            System.out.println(naoTrocou);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner leia = new Scanner(System.in);
        Fila fila = new Fila();
        int n = leia.nextInt();
        int m;
        int i;
        int j;
        if(n != 0) {
            for (i = 0; i < n; i++) {
                m = leia.nextInt();
                for (j = 0; j < m; j++) {
                    fila.enfileirar_Fila(leia.nextInt(), j);
                }
                fila.mostrar_NaoTrocados();
                fila.limpar_Fila();
            }
        }
    }
}
