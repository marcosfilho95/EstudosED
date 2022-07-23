public class Fila {

    int num_elementos;
    int vetor_elementos[];

    public Fila(int tamanho) {
        this.num_elementos = 0;
        this.vetor_elementos = new int[tamanho];
    }

    public int Quantidade() {
        return this.num_elementos;
    }

    public boolean Fila_Vazia() {
        if (num_elementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Fila_Cheia() {
        if (num_elementos >= vetor_elementos.length) {
            return true;
        } else {
            return false;
        }
    }

    public void Enfileirar_Fila(int valor) {
        if (Fila_Cheia()) {
            System.out.println("Fila Cheia");
        } else {
            for (int i = num_elementos; i > 0; i--) {
                vetor_elementos[i] = vetor_elementos[i - 1];
            }
            vetor_elementos[0] = valor;
            num_elementos += 1;
            System.out.println("Elemento adicionado na fila: " + valor);
        }
    }

    public void Desenfileirar_Fila() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
        } else {
            int elemento_removido = vetor_elementos[num_elementos - 1];
            num_elementos -= 1;
            System.out.println("Elemento removido da fila: " + elemento_removido);
        }
    }

    public void Ver_Fila() {
        for (int i = 0; i < num_elementos; i++) {
            if (i == 0) {
                System.out.print("[" + vetor_elementos[i] + ", ");
            } else if (i == num_elementos - 1) {
                System.out.println(vetor_elementos[i] + "]");
            } else {
                System.out.print(vetor_elementos[i] + ", ");
            }

        }
    }

    public int Retornar_inicioFila() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
            return 0;
        } else {
            int retornarPrimeiro = vetor_elementos[0];
            System.out.println("O elemento que esta no inicio da minha fila e: " + retornarPrimeiro);
            return retornarPrimeiro;
        }
    }

    public int Retornar_inicioFila2() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
            return 0;
        } else {
            int retornarPrimeiro = vetor_elementos[0];
            return retornarPrimeiro;
        }
    }

    public int Retornar_finalFila() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
            return 0;
        } else {
            int retornarUltimo = vetor_elementos[num_elementos - 1];
            System.out.println("O elemento que esta no final da minha fila e: " + retornarUltimo);
            return retornarUltimo;
        }
    }
    public int Retornar_finalFila2() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
            return 0;
        } else {
            int retornarUltimo = vetor_elementos[num_elementos - 1];
            return retornarUltimo;
        }
    }

    public void Retornar_MaiorMenorSoma() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
        }
        int retornarMaior, retornarMenor, somaElementos;
        retornarMenor = Retornar_finalFila();
        retornarMaior = Retornar_finalFila();
        somaElementos = 0;
        int xis = 1;
        while (xis <= num_elementos) {
            somaElementos += Retornar_finalFila2();
            if(retornarMenor>Retornar_finalFila2()){
                retornarMenor = Retornar_finalFila2();
            }
            if(retornarMaior < Retornar_finalFila2()){
                retornarMaior = Retornar_finalFila2();
            }
            int salvarUltimo = Retornar_finalFila2();
            Desenfileirar_Fila();
            Enfileirar_Fila(salvarUltimo);
            xis+=1;
        }
        System.out.println("Printar maior: "+retornarMaior);
        System.out.println("Printar menor: "+retornarMenor);
        System.out.println("Printar soma: "+somaElementos);
    }
}


