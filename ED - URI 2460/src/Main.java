import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static class No{
        public int numero_armazenado;
        public No proximo_no;
        public No anterior_no;
        public No(int numero_armazenado){
            this.numero_armazenado = numero_armazenado;
            this.proximo_no = null;
            this.anterior_no = null;
        }
    }
    public static class Fila {
        private No inicioFila;
        private No finalFila;
        private int contador;
        public Fila() {
            this.inicioFila = null;
            this.finalFila = null;
            this.contador = 0;
        }
        public void enfileirar_Fila(int valor) {
            No novoNo = new No(valor);
            if (empty()) {
                inicioFila = novoNo;
                finalFila = novoNo;
            } else {
                finalFila.proximo_no = novoNo;
                novoNo.anterior_no = finalFila;
                finalFila = novoNo;
            }
            contador++;
        }
        public int procurarEDesenfileirar_Fila(int valor) {
            if (!empty()) {
                No noAux = inicioFila;
                int identificador;
                while(valor != noAux.numero_armazenado){
                    noAux = noAux.proximo_no;
                }
                if (tamanho() == 1) {
                    identificador = inicioFila.numero_armazenado;
                    inicioFila = null;
                    finalFila = null;
                }
                else {
                    if(noAux == inicioFila){
                        identificador = inicioFila.numero_armazenado;
                        inicioFila = inicioFila.proximo_no;
                        inicioFila.anterior_no.proximo_no = null;
                        inicioFila.anterior_no = null;
                    }
                    else if(noAux == finalFila){
                        identificador = finalFila.numero_armazenado;
                        finalFila = finalFila.anterior_no;
                        finalFila.proximo_no.anterior_no = null;
                        finalFila.proximo_no = null;
                    }
                    else{
                        identificador = noAux.numero_armazenado;
                        noAux.anterior_no.proximo_no = noAux.proximo_no;
                        noAux.proximo_no.anterior_no = noAux.anterior_no;
                        noAux.anterior_no = null;
                        noAux.proximo_no = null;
                    }
                }
                contador--;
                return identificador;
            } else {
                throw new IllegalArgumentException("Fila vazia");
            }
        }
        public boolean empty() {
            if (inicioFila == null) {
                return true;
            } else {
                return false;
            }
        }
        public int tamanho() {
            return contador;
        }
        public void exibir(){
            for(No aux = inicioFila; aux != null; aux = aux.proximo_no){
                if (aux != finalFila){
                    System.out.print(aux.numero_armazenado + " ");
                }
                else {
                    System.out.println(aux.numero_armazenado);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        Fila fila = new Fila();
        int n;
        int m;
        int i;
        int j;
        n = entrada.nextInt();entrada.nextLine();
        for(i = 0; i < n; i++){
            fila.enfileirar_Fila(entrada.nextInt());
        }
        m = entrada.nextInt();entrada.nextLine();
        for(j = 0; j < m; j++){
            fila.procurarEDesenfileirar_Fila(entrada.nextInt());
        }
        fila.exibir();
    }
}