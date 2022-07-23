public class Pilha {

    int topo;
    int vetor_elementos[];

    public Pilha(int tamanho) {
        this.topo = 0;
        this.vetor_elementos = new int[tamanho];
    }

    public int Quantidade() {
        return this.topo;
    }

    public boolean Pilha_Vazia() {
        if (topo == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Pilha_Cheia() {
        if (topo >= vetor_elementos.length) {
            return true;
        } else {
            return false;
        }
    }

    public void Empilhar_Pilha(int valor) {
        if (Pilha_Cheia()) {
            System.out.println("Pilha Cheia");
        } else {
            vetor_elementos[topo] = valor;
            topo += 1;

        }
    }

    public void Desempilhar_Pilha() {
        if (Pilha_Vazia()) {
            System.out.println("Pilha Vazia");
        } else {
            int elemento_removido = vetor_elementos[topo-1];
            topo -= 1;

        }
    }
    public void Ordenar_Pilha() {
        if (Pilha_Vazia()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = topo; i < vetor_elementos.length; i++) {
                for (int j = topo+1; j < vetor_elementos.length; j++) {
                    if (vetor_elementos[topo] > vetor_elementos[j]) {
                        int var_aux = vetor_elementos[i];
                        vetor_elementos[i] = vetor_elementos[j];
                        vetor_elementos[j] = var_aux;
                    }
                }
            }
        }
    }
    public int Ver_Topo()
    {
            System.out.println(vetor_elementos[topo-1]);
            return vetor_elementos[topo-1];
        }
}
