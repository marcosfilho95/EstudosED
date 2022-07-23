public class ArvoreBinariaBusca {
    NoArvore raiz_arvore;

    public ArvoreBinariaBusca() {
        raiz_arvore = null;
    }

    public boolean arvore_Vazia() {
        if (raiz_arvore == null) {
            return true;
        } else {
            return false;
        }
    }

    public NoArvore buscar_ElementoArvoreBusca(int elemento) {
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia !");
        } else {
            NoArvore noAux = raiz_arvore;
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

    public void adicionar_ElementoArvoreBusca(int elemento) {
        NoArvore novoNo = new NoArvore(elemento);
        if (!arvore_Vazia()) {
            NoArvore noAux = raiz_arvore;
            while (noAux != null) {
                if (novoNo.elemento_armazenado < noAux.elemento_armazenado) {
                    if (noAux.filho_esquerda == null) {
                        noAux.filho_esquerda = novoNo;
                        noAux = null;
                    } else {
                        noAux = noAux.filho_esquerda;
                    }
                } else {
                    if (noAux.filho_direita == null) {
                        noAux.filho_direita = novoNo;
                        noAux = null;
                    } else {
                        noAux = noAux.filho_direita;
                    }
                }
            }
        } else {
            raiz_arvore = novoNo;
        }
    }

    public NoArvore buscar_PaiArvoreBusca(int elemento) {
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia !");
            return null;
        } else {
            NoArvore noAux = raiz_arvore;
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

    public NoArvore remover_ElementoArvoreBusca(int elemento) {
        NoArvore noRemovido = null;
        if (!arvore_Vazia()) {
            noRemovido = buscar_ElementoArvoreBusca(elemento);
            if (noRemovido != null) {
                NoArvore esquerda = noRemovido.filho_esquerda;
                NoArvore direita = noRemovido.filho_direita;
                NoArvore noPai = buscar_PaiArvoreBusca(elemento);
                if (esquerda == null && direita == null) {
                    if (noPai.filho_esquerda == noRemovido) {
                        noPai.filho_esquerda = null;
                    } else {
                        noPai.filho_direita = null;
                    }
                } else if (esquerda != null && direita != null) {
                    NoArvore noFolha = noRemovido.filho_esquerda;
                    if (noPai.filho_esquerda == noRemovido) {
                        noPai.filho_esquerda = esquerda;
                    } else {
                        noPai.filho_direita = direita;
                    }
                    while (noFolha.filho_direita != null) {
                        noFolha = noFolha.filho_direita;
                    }
                    noFolha.filho_direita = noRemovido.filho_direita;
                } else {
                    if (noPai.filho_esquerda == noRemovido) {
                        if (esquerda == null) {
                            noPai.filho_esquerda = direita;
                        } else {
                            noPai.filho_esquerda = esquerda;
                        }
                    } else {
                        if (direita == null) {
                            noPai.filho_direita = esquerda;
                        } else {
                            noPai.filho_direita = direita;
                        }
                    }
                }
            }
        } else {
            System.out.println("Arvore Vazia");
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

    public void varredura_profundidadeRecursaoPreOrdem() {
        ListaEncadeada listaPre = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia");
        } else {
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

    public void varredura_profundidadeRecursaoEmOrdem() {
        ListaEncadeada listaEm = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia");
        } else {
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

    public void varredura_profundidadeRecursaoPosOrdem() {
        ListaEncadeada listaPos = new ListaEncadeada();
        if (arvore_Vazia()) {
            System.out.println("Arvore Vazia");
        } else {
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