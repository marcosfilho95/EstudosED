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
        }
    }
    public void Desenfileirar_Fila() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
        } else {
            int elemento_removido = vetor_elementos[num_elementos - 1];
            num_elementos -= 1;
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

    public void removerCauda(){
        int salvarNum = 0;
        for(int i=0; i<=num_elementos-2; i++){
            salvarNum = Retornar_finalFila2();
            Desenfileirar_Fila();
            Enfileirar_Fila(salvarNum);
        }
        Desenfileirar_Fila();
    }

    public void inverterFilaUsandoPilha(){
        Pilha pilhAux = new Pilha(num_elementos);
        int salvarValor = 0;
        while (!Fila_Vazia()){
            salvarValor = Retornar_finalFila();
            Desenfileirar_Fila();
            pilhAux.Empilhar_Pilha(salvarValor);
        }
        while (!pilhAux.Pilha_Vazia()){
            salvarValor = pilhAux.topo;
            pilhAux.Desempilhar_Pilha();
            Enfileirar_Fila(salvarValor);
        }
    }

    public void imprimirFilaContrario(){
        int salvarNum = 0;
        System.out.print("[");
        for(int i=0; i<=num_elementos-1; i++){
            salvarNum = Retornar_finalFila2();
            Desenfileirar_Fila();
            Enfileirar_Fila(salvarNum);
            if(i == num_elementos-1){
                System.out.print(salvarNum+"]");
            }
            else{
                System.out.print(salvarNum+", ");
            }
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

    // Nao printa o retornarUltimo
    public int Retornar_finalFila2() {
        if (Fila_Vazia()) {
            System.out.println("Fila Vazia");
            return 0;
        } else {
            int retornarUltimo = vetor_elementos[num_elementos - 1];
            return retornarUltimo;
        }
    }

    public Fila inverterFilaUsandoFila() {
        Fila filAux = new Fila(num_elementos);
        int salvarNum = 0;
        while (!Fila_Vazia()) {
            for (int i = 0; i <= num_elementos - 2; i++) {
                salvarNum = Retornar_finalFila2();
                Desenfileirar_Fila();
                Enfileirar_Fila(salvarNum);
            }
            salvarNum = Retornar_finalFila2();
            filAux.Enfileirar_Fila(salvarNum);
            Desenfileirar_Fila();
        }
        return filAux;
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
