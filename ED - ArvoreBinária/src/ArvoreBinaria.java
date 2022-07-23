public class ArvoreBinaria {
    NoArvore raiz_arvore;

    public ArvoreBinaria() {
        raiz_arvore = null;
    }

    public boolean arvore_Vazia() {
        if (raiz_arvore == null) {
            return true;
        } else {
            return false;
        }
    }

    public NoArvore buscar_ElementoArvore(int elemento) {
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia !");
        } else {
            PilhaEncadeada pilha = new PilhaEncadeada();
            pilha.Empilhar_Pilha(raiz_arvore);
            while (!pilha.pilha_Vazia()) {
                NoArvore noAux = pilha.Desempilhar_Pilha().elemento_Arvore;
                if (noAux.elemento_armazenado == elemento) {
                    return noAux;
                }
                if (noAux.filho_direita != null) {
                    pilha.Empilhar_Pilha(noAux.filho_direita);
                }
                if (noAux.filho_esquerda != null) {
                    pilha.Empilhar_Pilha(noAux.filho_esquerda);
                }
            }
        }
        System.out.println("Elemento nao encontrado.");
        return null;
    }

    public void adicionar_Esquerda(int elemento, int pai) {
        NoArvore novoNo = new NoArvore(elemento);
        if (!arvore_Vazia()) {
            NoArvore noPai = buscar_ElementoArvore(pai);
            if (noPai != null) {
                if (noPai.filho_esquerda == null) {
                    noPai.filho_esquerda = novoNo;
                    System.out.println("Elemento " + "'" + noPai.filho_esquerda.elemento_armazenado + "'" + " e o filho  a esquerda do pai " + noPai.elemento_armazenado);
                } else {
                    System.out.println("Nó já possui filho!");
                }
            } else {
                System.out.println("Elemento não existe!");
            }
        } else {
            raiz_arvore = novoNo;
        }
    }

    public void adicionar_Direita(int elemento, int pai) {
        NoArvore novoNo = new NoArvore(elemento);
        if (!arvore_Vazia()) {
            NoArvore noPai = buscar_ElementoArvore(pai);
            if (noPai != null) {
                if (noPai.filho_direita == null) {
                    noPai.filho_direita = novoNo;
                    System.out.println("Elemento " + "'" + noPai.filho_direita.elemento_armazenado + "'" + " e o filho  a direita do pai " + noPai.elemento_armazenado);
                } else {
                    System.out.println("No já possui filhos!");
                }
            } else {
                System.out.println("Elemento não existe!");
            }
        } else {
            raiz_arvore = novoNo;
        }
    }

    public NoArvore buscar_Pai(int elemento) {
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia !");
            return null;
        } else {
            PilhaEncadeada pilha = new PilhaEncadeada();
            pilha.Empilhar_Pilha(raiz_arvore);
            while (!pilha.pilha_Vazia()) {
                NoArvore noAux = pilha.Desempilhar_Pilha().elemento_Arvore;
                if (noAux.filho_direita.elemento_armazenado == elemento || noAux.filho_esquerda.elemento_armazenado == elemento) {
                    System.out.println("Pai do elemento " + elemento + " é: " + noAux.elemento_armazenado);
                    return noAux;
                }
                if (noAux.filho_direita != null) {
                    pilha.Empilhar_Pilha(noAux.filho_direita);
                }
                if (noAux.filho_esquerda != null) {
                    pilha.Empilhar_Pilha(noAux.filho_esquerda);
                }
            }
        }
        System.out.println("Elemento nao encontrado.");
        return null;
    }

    public NoArvore remover_Elemento(int elemento) {
        NoArvore noRemovido = null;
        if (!arvore_Vazia()) {
            noRemovido = buscar_ElementoArvore(elemento);
            NoArvore noPai;
            if (elemento == raiz_arvore.elemento_armazenado) {
                noPai = raiz_arvore;
            } else {
                noPai = buscar_Pai(elemento);
            }
            if (noRemovido != null) {
                NoArvore noEsquerda = noRemovido.filho_esquerda;
                NoArvore noDireita = noRemovido.filho_direita;
                if (noEsquerda == null && noDireita == null) {
                    if (noPai.filho_esquerda == noRemovido) {
                        noPai.filho_esquerda = null;
                    } else {
                        noPai.filho_direita = null;
                    }
                } else if (noEsquerda != null && noDireita != null) {
                    if (noPai.filho_esquerda == noRemovido) {
                        noPai.filho_esquerda = noEsquerda;
                        while (noEsquerda.filho_esquerda != null) {
                            noEsquerda = noEsquerda.filho_esquerda;
                        }
                        noEsquerda.filho_esquerda = noDireita;
                    } else if (noPai.filho_direita == noRemovido) {
                        noPai.filho_direita = noDireita;
                        while (noDireita.filho_direita != null) {
                            noDireita = noDireita.filho_direita;
                        }
                        noDireita.filho_direita = noEsquerda;
                    } else {
                        raiz_arvore = noEsquerda;
                        while (noEsquerda.filho_esquerda != null) {
                            noEsquerda = noEsquerda.filho_esquerda;
                        }
                        noEsquerda.filho_esquerda = noDireita;
                    }
                } else {
                    if (noPai.filho_esquerda == noRemovido) {
                        if (noEsquerda == null) {
                            noPai.filho_esquerda = noDireita;
                        } else {
                            noPai.filho_esquerda = noEsquerda;
                        }
                    } else {
                        if (noDireita == null) {
                            noPai.filho_direita = noEsquerda;
                        } else {
                            noPai.filho_direita = noDireita;
                        }
                    }
                }
            }
        } else {
            System.out.println("Estrutura Vazia!");
        }
        return noRemovido;
    }

    public void varredura_Largura() {
        ListaEncadeada listaVarredura = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia!");
        } else {
            FilaEncadeada filaVarredura = new FilaEncadeada();
            filaVarredura.enfileirar_Fila(raiz_arvore);
            while (!filaVarredura.fila_Vazia()) {
                NoArvore noAux = filaVarredura.desenfileirar_Fila().elemento_Arvore;
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
                NoArvore noAux = filaVarredura.desenfileirar_Fila().elemento_Arvore;
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
                NoArvore noAux = filaVarredura.desenfileirar_Fila().elemento_Arvore;
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
            NoArvore noAux = raiz_arvore;
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

    public void varredura_profundidadeRecursaoPreOrdem(){
        ListaEncadeada listaPre = new ListaEncadeada();
        if(arvore_Vazia()){
            System.out.println("Arvore Vazia");
        }
        else{
            varredura_profundidadeRecursaoPreOrdem(raiz_arvore, listaPre);
        }
        listaPre.Ver_Lista();
    }

    public void varredura_profundidadeRecursaoPreOrdem(NoArvore n, ListaEncadeada listaPreOrdem) {
        listaPreOrdem.Adicionar_Final(n);
        if (n.filho_esquerda != null) {
            varredura_profundidadeRecursaoPreOrdem(n.filho_esquerda, listaPreOrdem);
        }
        if (n.filho_direita != null) {
            varredura_profundidadeRecursaoPreOrdem(n.filho_direita, listaPreOrdem);
        }
    }

    public void varredura_profundidadeRecursaoEmOrdem(){
        ListaEncadeada listaEm = new ListaEncadeada();
        if(arvore_Vazia()){
            System.out.println("Arvore Vazia");
        }
        else{
            varredura_profundidadeRecursaoEmOrdem(raiz_arvore, listaEm);
        }
        listaEm.Ver_Lista();
    }

    public void varredura_profundidadeRecursaoEmOrdem(NoArvore n, ListaEncadeada listaEmOrdem) {
        if (n.filho_esquerda != null) {
            varredura_profundidadeRecursaoEmOrdem(n.filho_esquerda, listaEmOrdem);
        }
        listaEmOrdem.Adicionar_Final(n);
        if (n.filho_direita != null) {
            varredura_profundidadeRecursaoEmOrdem(n.filho_direita, listaEmOrdem);
        }
    }

    public void varredura_profundidadeRecursaoPosOrdem(){
        ListaEncadeada listaPos = new ListaEncadeada();
        if(arvore_Vazia()){
            System.out.println("Arvore Vazia");
        }
        else{
            varredura_profundidadeRecursaoPosOrdem(raiz_arvore, listaPos);
        }
        listaPos.Ver_Lista();
    }

    public void varredura_profundidadeRecursaoPosOrdem(NoArvore n, ListaEncadeada listaPosOrdem) {
        if (n.filho_esquerda != null) {
            varredura_profundidadeRecursaoPosOrdem(n.filho_esquerda, listaPosOrdem);
        }
        if (n.filho_direita != null) {
            varredura_profundidadeRecursaoPosOrdem(n.filho_direita, listaPosOrdem);
        }
        listaPosOrdem.Adicionar_Final(n);
    }
    // Recursividade simples e prática

    /*public void varredura_ProfundidadePreOrdem(NoArvore noAux){
        if(noAux == null){
            return;
        }
        System.out.print(noAux.elemento_armazenado+" ");
        varredura_PosOrdem(noAux.filho_esquerda);
        varredura_PosOrdem(noAux.filho_direita);
    }*/

    /*public void varreduraProfundidadePosOrdem(NoArvore noAux){
        if(noAux == null){
            return;
        }
        varreduraProfundidadePosOrdem(noAux.filho_esquerda);
        varreduraProfundidadePosOrdem(noAux.filho_direita);
        System.out.print(noAux.elemento_armazenado+" ");
    }*/
}
