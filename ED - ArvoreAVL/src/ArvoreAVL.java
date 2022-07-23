public class ArvoreAVL {
    NoArvoreAVL raiz_arvore;

    public ArvoreAVL() {
        raiz_arvore = null;
    }

    public boolean arvore_Vazia() {
        if (raiz_arvore == null) {
            return true;
        } else {
            return false;
        }
    }

    public NoArvoreAVL getRaiz_arvore() {
        return raiz_arvore;
    }

    public int retornarAltura(NoArvoreAVL noArvore){
        if(noArvore == null){
            return -1;
        }
        else{
            return noArvore.altura;
        }
    }

    public int alturaMaxima(int alturaEsquerda, int alturaDireita) {
        if(alturaEsquerda > alturaDireita){
            return alturaEsquerda;
        }
        else{
            return alturaDireita;
        }
    }

    public int fatorBalanceamento(NoArvoreAVL noArvore){
        return retornarAltura(noArvore.filho_esquerda) - retornarAltura(noArvore.filho_direita);
    }

    public NoArvoreAVL balanceamentoArvoreAVL (NoArvoreAVL noArvore) {
        if(fatorBalanceamento(noArvore) == 2){
            if(fatorBalanceamento(noArvore.filho_esquerda) > 0){
                noArvore = rotacaoDireita(noArvore);
            }
            else{
                noArvore = rotacaoDuplaDireita(noArvore);
            }
        }
        else if(fatorBalanceamento(noArvore) == -2){
            if(fatorBalanceamento(noArvore.filho_direita) < 0){
                noArvore = rotacaoEsquerda(noArvore);
            }
            else{
                noArvore = rotacaoDuplaEsquerda(noArvore);
            }
        }
        noArvore.altura = alturaMaxima(retornarAltura(noArvore.filho_esquerda), retornarAltura(noArvore.filho_direita))+1;
        return noArvore;
    }

    public NoArvoreAVL rotacaoDireita(NoArvoreAVL noArvore) {
        NoArvoreAVL noAux = noArvore.filho_esquerda;
        noArvore.filho_esquerda = noAux.filho_direita;
        noAux.filho_direita = noArvore;
        noArvore.altura = alturaMaxima(retornarAltura(noArvore.filho_esquerda), retornarAltura(noArvore.filho_direita))+1;
        noAux.altura = alturaMaxima(retornarAltura(noAux.filho_esquerda), noArvore.altura) +1;
        return noAux;
    }

    public NoArvoreAVL rotacaoEsquerda(NoArvoreAVL noArvore){
        NoArvoreAVL noAux = noArvore.filho_direita;
        noArvore.filho_direita = noAux.filho_esquerda;
        noAux.filho_esquerda = noArvore;
        noArvore.altura = alturaMaxima(retornarAltura(noArvore.filho_esquerda), retornarAltura(noArvore.filho_direita))+1;
        noAux.altura = alturaMaxima(retornarAltura(noAux.filho_esquerda), noArvore.altura) +1;
        return noAux;
    }

    public NoArvoreAVL rotacaoDuplaDireita(NoArvoreAVL noArvore){
        noArvore.filho_esquerda = rotacaoEsquerda(noArvore.filho_esquerda);
        return rotacaoDireita(noArvore);
    }

    public NoArvoreAVL rotacaoDuplaEsquerda(NoArvoreAVL noArvore){
        noArvore.filho_direita = rotacaoDireita(noArvore.filho_direita);
        return rotacaoEsquerda(noArvore);
    }

    public NoArvoreAVL buscar_ElementoArvoreBusca(int elemento) {
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia !");
        } else {
            NoArvoreAVL noAux = raiz_arvore;
            while (noAux != null) {
                if (elemento == noAux.elemento_armazenado) {
                    if (elemento == raiz_arvore.elemento_armazenado) {
                        System.out.println("O elemento: " + elemento + " é o nó raiz");
                    } else if (noAux.filho_direita == null && noAux.filho_esquerda == null) {
                        System.out.println("O elemento: " + elemento + " é um nó folha");
                    } else {
                        System.out.println("O elemento: " + elemento + " é um nó interno");
                    }
                    return noAux;
                } else if (elemento < noAux.elemento_armazenado) {
                    noAux = noAux.filho_esquerda;
                } else {
                    noAux = noAux.filho_direita;
                }
            }
        }
        System.out.println("Elemento nao encontrado.");
        return null;
    }

    public void adicionarElementoArvoreAVL (int valor) {
        raiz_arvore = adicionarElementoArvoreAVL (valor, raiz_arvore);
    }

    private NoArvoreAVL adicionarElementoArvoreAVL (int valor, NoArvoreAVL noArvore) {
        if( noArvore == null ) {
            noArvore = new NoArvoreAVL(valor, null, null);
        }
        else if( valor < noArvore.elemento_armazenado ){
            noArvore.filho_esquerda = adicionarElementoArvoreAVL(valor, noArvore.filho_esquerda);
        }
        else if( valor > noArvore.elemento_armazenado){
            noArvore.filho_direita = adicionarElementoArvoreAVL(valor, noArvore.filho_direita);
        }
        noArvore =  balanceamentoArvoreAVL(noArvore);
        return noArvore;
    }

    public NoArvoreAVL buscar_PaiArvoreBusca(int elemento) {
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia !");
            return null;
        } else {
            NoArvoreAVL noAux = raiz_arvore;
            while (noAux != null) {
                if (elemento == noAux.filho_esquerda.elemento_armazenado || elemento == noAux.filho_direita.elemento_armazenado) {
                    return noAux;
                } else if (elemento < noAux.elemento_armazenado) {
                    noAux = noAux.filho_esquerda;
                } else {
                    noAux = noAux.filho_direita;
                }
            }
        }
        return null;
    }

    public NoArvoreAVL menorValorNoArvoreAVL(NoArvoreAVL noArvore) {
        NoArvoreAVL noAux = noArvore;
        while (noAux.filho_esquerda != null) {
            noAux = noAux.filho_esquerda;
        }
        return noAux;
    }

    public NoArvoreAVL removerNoArvoreAVL(NoArvoreAVL noRaizArvore, int valor) {
        if(noRaizArvore == null){
            return noRaizArvore;
        }
        if (valor < noRaizArvore.elemento_armazenado) {
            noRaizArvore.filho_esquerda = removerNoArvoreAVL(noRaizArvore.filho_esquerda, valor);
        }
        else if (valor > noRaizArvore.elemento_armazenado) {
            noRaizArvore.filho_direita = removerNoArvoreAVL(noRaizArvore.filho_direita, valor);
        }
        else {
            if ((noRaizArvore.filho_esquerda == null) || (noRaizArvore.filho_direita == null)) {
                NoArvoreAVL noAux = null;
                if (noAux == noRaizArvore.filho_esquerda) {
                    noAux = noRaizArvore.filho_direita;
                    System.out.println("entrei 1");
                }
                else {
                    noAux = noRaizArvore.filho_esquerda;
                    System.out.println("entrei 2");
                }
                if (noAux == null) {
                    noAux = noRaizArvore;
                    noRaizArvore = null;
                    System.out.println("entrei 3");
                }
                else {
                    noRaizArvore = noAux;
                    System.out.println("entrei 4");
                }
            }
            else {
                NoArvoreAVL noAux = menorValorNoArvoreAVL(noRaizArvore.filho_direita);
                noRaizArvore.elemento_armazenado = noAux.elemento_armazenado;
                noRaizArvore.filho_direita = removerNoArvoreAVL(noRaizArvore.filho_direita, noAux.elemento_armazenado);
            }
        }
        if (noRaizArvore == null) {
            return noRaizArvore;
        }
        noRaizArvore.altura = alturaMaxima(retornarAltura(noRaizArvore.filho_esquerda), retornarAltura(noRaizArvore.filho_direita)) + 1;
        int balanceamento = fatorBalanceamento(noRaizArvore);
        if (balanceamento > 1 && fatorBalanceamento(noRaizArvore.filho_esquerda) >= 0) {
            return rotacaoDireita(noRaizArvore);
        }
        // Rotacao Dupla Direita
        if (balanceamento > 1 && fatorBalanceamento(noRaizArvore.filho_esquerda) < 0) {
            noRaizArvore.filho_esquerda = rotacaoEsquerda(noRaizArvore.filho_esquerda);
            return rotacaoDireita(noRaizArvore);
        }
        if (balanceamento < -1 && fatorBalanceamento(noRaizArvore.filho_direita) <= 0) {
            return rotacaoEsquerda(noRaizArvore);
        }
        // Rotacao Dupla Esquerda
        if (balanceamento < -1 && fatorBalanceamento(noRaizArvore.filho_direita) > 0) {
            noRaizArvore.filho_direita = rotacaoDireita(noRaizArvore.filho_direita);
            return rotacaoEsquerda(noRaizArvore);
        }
        return noRaizArvore;
    }

    public void varredura_Largura() {
        ListaEncadeada listaVarredura = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia!");
        } else {
            FilaEncadeada filaVarredura = new FilaEncadeada();
            filaVarredura.enfileirar_Fila(raiz_arvore);
            while (!filaVarredura.fila_Vazia()) {
                NoArvoreAVL noAux = filaVarredura.desenfileirar_Fila().elemento_Arvore;
                listaVarredura.Adicionar_Final(noAux);
                if (noAux.filho_esquerda != null) {
                    filaVarredura.enfileirar_Fila(noAux.filho_esquerda);
                }
                if (noAux.filho_direita != null) {
                    filaVarredura.enfileirar_Fila(noAux.filho_direita);
                }
            }
        }
        listaVarredura.Ver_Lista();
    }

    public void varredura_ProfundidadePreOrdem() {
        ListaEncadeada listaVarredura = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia!");
        } else {
            FilaEncadeada filaVarredura = new FilaEncadeada();
            filaVarredura.enfileirar_Fila(raiz_arvore);
            while (!filaVarredura.fila_Vazia()) {
                NoArvoreAVL noAux = filaVarredura.desenfileirar_Fila().elemento_Arvore;
                listaVarredura.Adicionar_Final(noAux);
                if (noAux.filho_esquerda != null) {
                    filaVarredura.enfileirar_Fila(noAux.filho_esquerda);
                }
                if (noAux.filho_direita != null) {
                    filaVarredura.enfileirar_Fila(noAux.filho_direita);
                }
            }
        }
        listaVarredura.Ver_Lista();
    }

    public void varredura_ProfundidadeEmOrdem() {
        ListaEncadeada listaVarredura = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia!");
        } else {
            FilaEncadeada filaVarredura = new FilaEncadeada();
            filaVarredura.enfileirar_Fila(raiz_arvore);
            while (!filaVarredura.fila_Vazia()) {
                NoArvoreAVL noAux = filaVarredura.desenfileirar_Fila().elemento_Arvore;
                listaVarredura.Adicionar_Final(noAux);
                if (noAux.filho_esquerda != null) {
                    filaVarredura.enfileirar_Fila(noAux.filho_esquerda);
                }
                if (noAux.filho_direita != null) {
                    filaVarredura.enfileirar_Fila(noAux.filho_direita);
                }
            }
        }
        listaVarredura.Ver_Lista();
    }

    public void varredura_ProfundidadePosOrdem() {
        ListaEncadeada listaVarredura = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia!");
        } else {
            PilhaEncadeada pilhaVarredura = new PilhaEncadeada();
            NoArvoreAVL noAux = raiz_arvore;
            pilhaVarredura.Empilhar_Pilha(noAux);
            while (!pilhaVarredura.pilha_Vazia()) {
                noAux = pilhaVarredura.Desempilhar_Pilha().elemento_Arvore;
                if (noAux.filho_esquerda != null) {
                    pilhaVarredura.Empilhar_Pilha(noAux.filho_esquerda);
                }
                if (noAux != null && !listaVarredura.buscarElemento(noAux)) {
                    listaVarredura.Adicionar_Inicio(noAux);
                    if (noAux.filho_direita != null) {
                        pilhaVarredura.Empilhar_Pilha(noAux.filho_direita);
                        noAux = noAux.filho_direita;
                    }
                }
            }
        }
        listaVarredura.Ver_Lista();
    }

    public void varredura_profundidadeRecursaoPreOrdem() {
        ListaEncadeada listaPre = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia");
        } else {
            varredura_profundidadeRecursaoPreOrdem(raiz_arvore, listaPre);
        }
        listaPre.Ver_Lista();
    }

    public void varredura_profundidadeRecursaoPreOrdem(NoArvoreAVL n, ListaEncadeada listaPreOrdem) {
        listaPreOrdem.Adicionar_Final(n);
        if (n.filho_esquerda != null) {
            varredura_profundidadeRecursaoPreOrdem(n.filho_esquerda, listaPreOrdem);
        }
        if (n.filho_direita != null) {
            varredura_profundidadeRecursaoPreOrdem(n.filho_direita, listaPreOrdem);
        }
    }

    public void varredura_profundidadeRecursaoEmOrdem() {
        ListaEncadeada listaEm = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia");
        } else {
            varredura_profundidadeRecursaoEmOrdem(raiz_arvore, listaEm);
        }
        listaEm.Ver_Lista();
    }

    public void varredura_profundidadeRecursaoEmOrdem(NoArvoreAVL n, ListaEncadeada listaEmOrdem) {
        if (n.filho_esquerda != null) {
            varredura_profundidadeRecursaoEmOrdem(n.filho_esquerda, listaEmOrdem);
        }
        listaEmOrdem.Adicionar_Final(n);
        if (n.filho_direita != null) {
            varredura_profundidadeRecursaoEmOrdem(n.filho_direita, listaEmOrdem);
        }
    }

    public void varredura_profundidadeRecursaoPosOrdem() {
        ListaEncadeada listaPos = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia");
        } else {
            varredura_profundidadeRecursaoPosOrdem(raiz_arvore, listaPos);
        }
        listaPos.Ver_Lista();
    }

    public void varredura_profundidadeRecursaoPosOrdem(NoArvoreAVL n, ListaEncadeada listaPosOrdem) {
        if (n.filho_esquerda != null) {
            varredura_profundidadeRecursaoPosOrdem(n.filho_esquerda, listaPosOrdem);
        }
        if (n.filho_direita != null) {
            varredura_profundidadeRecursaoPosOrdem(n.filho_direita, listaPosOrdem);
        }
        listaPosOrdem.Adicionar_Final(n);
    }
}