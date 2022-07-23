public class Lista {

    int numero_elementos;
    int vetor_elementos[];

    public Lista(int tamanho) {
        this.numero_elementos = 0;
        this.vetor_elementos = new int[tamanho];
    }

    public int Quantidade() {

        return this.numero_elementos;
    }

    public boolean Lista_Vazia() {
        if (numero_elementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Lista_Cheia() {
        if (numero_elementos >= vetor_elementos.length) {
            return true;
        } else {
            return false;
        }
    }

    public void Adicionar_Final(int valor) {
        if (Lista_Cheia()) {
            System.out.println("Lista Cheia");
        } else {
            int indice = numero_elementos;
            vetor_elementos[numero_elementos] = valor;
            numero_elementos = numero_elementos + 1;
            System.out.println("Elemento final adicionado: " + valor);
        }
    }

    public void Remover_Final() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            numero_elementos -= 1;
            int elemento_removido = vetor_elementos[numero_elementos];
            System.out.println("Elemento final removido: " + elemento_removido);
        }
    }

    public void Adicionar_Inicio(int valor) {
        if (Lista_Cheia()) {
            System.out.println("Lista Cheia");
        } else {
            int elemento_removido = vetor_elementos[0];
            for (int x = numero_elementos - 1; x >= 0; x--) {
                vetor_elementos[x + 1] = vetor_elementos[x];
            }
            vetor_elementos[0] = valor;
            numero_elementos += 1;
            System.out.println("Elemento '" + valor + "' adicionado ao inicio da lista.");
        }
    }

    public void Remover_Incio() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            int elemento_removido = vetor_elementos[0];
            for (int i = 0; i < numero_elementos - 1; i++) {
                vetor_elementos[i] = vetor_elementos[i + 1];
            }
            numero_elementos -= 1;
            System.out.println("Elemento inicial removido: " + elemento_removido);
        }
    }

    public void Adicionar_Posicao(int valor, int posicao) {
        if (Lista_Cheia()) {
            System.out.println("Lista Cheia !!");
        } else {
            for (int x = numero_elementos - 1; x >= posicao - 1; x--) {
                vetor_elementos[x + 1] = vetor_elementos[x];
            }
            vetor_elementos[posicao - 1] = valor;
            numero_elementos += 1;
            System.out.println("Elemento '" + valor + "' adicionado na posicao " + posicao);
        }
    }

    public void Remover_Posicao(int posicao) {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else if (posicao <= 0) {
            Remover_Incio();
        } else if (posicao >= numero_elementos) {
            Remover_Final();
        } else {
            int elemento_removido = vetor_elementos[posicao - 1];
            for (int i = posicao - 1; i < numero_elementos - 1; i++) {
                vetor_elementos[i] = vetor_elementos[i + 1];
            }
            numero_elementos -= 1;
            System.out.println("O elemento removido e: " + elemento_removido);
        }
    }

    public void Ver_Lista() {
        for (int i = 0; i < numero_elementos; i++) {
            if (i == 0) {
                System.out.print("[" + vetor_elementos[i] + ", ");
            } else if (i == numero_elementos - 1) {
                System.out.println(vetor_elementos[i] + "]");
            } else {
                System.out.print(vetor_elementos[i] + ", ");
            }

        }
    }

    public void Retornar_Meio() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else if (numero_elementos % 2 == 1) {
            System.out.println("O elemento do meio do vetor e: " + vetor_elementos[numero_elementos / 2]);
        } else {
            System.out.println("O vetor é par e não possui elemento central");
        }
    }

    public void Trocar_PrimeiroUltimo() {
        int aux = vetor_elementos[0];
        vetor_elementos[0] = vetor_elementos[numero_elementos - 1];
        vetor_elementos[numero_elementos - 1] = aux;
    }

    public void Retornar_ElementoPosicao(int posicao) {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            if (posicao <= 0) {
                System.out.println("O elemento retornado (posicao inicial): " + vetor_elementos[0]);
            } else if (posicao >= numero_elementos) {
                System.out.println("O elemento retornado (posicao final): " + vetor_elementos[numero_elementos]);
            } else {
                for (int indice = numero_elementos; indice <= posicao; indice--) {
                    vetor_elementos[indice] = vetor_elementos[indice - 1];
                }
                System.out.println("O elemento retornado: " + vetor_elementos[posicao]);
            }
        }
    }

    public Lista Inverter_Lista() {
        if (Lista_Vazia()) {
            System.out.println("Lista esta vazia");
        } else {
            Lista listAux = new Lista(list)
            }
        }
    }

    public void Excluir_RepetidorLista() {
        if (numero_elementos < 2) {
            System.out.println("Lista precisa de mais elementos");
        } else {
            for (int i = 0; i < numero_elementos - 2; i++) {
                for (int j = i + 1; j < numero_elementos-1; j++) {
                    if (vetor_elementos[i] == vetor_elementos[j]) {
                        System.out.println("Valor repetido " + vetor_elementos[j] + " na posicao " + (j+1));
                        if (j == numero_elementos - 1) {
                            Remover_Final();
                        } else {
                            int elemento_removido = vetor_elementos[j];
                            Remover_Posicao(j);
                        }
                    }
                }
            }
        }
    }
}

