public class PilhaEncadeada {
    // Pilha de Strings
    ElementoArvore topo;

    public PilhaEncadeada() {
        topo = null;
    }

    public boolean pilha_Vazia() {
        if (topo == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Empilhar_Pilha(NoArvore dados) {
        ElementoArvore novoNo = new ElementoArvore(dados);
        if (!pilha_Vazia()) {
            novoNo.proximo_No = topo;
            topo = novoNo;
        } else {
            topo = novoNo;
        }
    }
    public ElementoArvore Desempilhar_Pilha() {
        ElementoArvore removerNo = null;
        if (pilha_Vazia()) {
            System.out.println("Pilha Vazia");
        } else {
            removerNo = topo;
            topo = topo.proximo_No;
        }
        return removerNo;
    }
    public NoArvore Ver_Topo(){
        return topo.elemento_Arvore;
    }

    public void Ver_PilhaInvertendoPilha(){
        if(pilha_Vazia()){
            System.out.println("Pilha Vazia");
        }
        else {
            PilhaEncadeada pilhaAux = new PilhaEncadeada();
            while (topo != null) {
                System.out.println(Ver_Topo());
                pilhaAux.Empilhar_Pilha(Ver_Topo());
                Desempilhar_Pilha();
            }
            while (pilhaAux.topo != null){
                Empilhar_Pilha(pilhaAux.Ver_Topo());
                pilhaAux.Desempilhar_Pilha();
            }
        }
    }
    public void Ver_Pilha() {
        if (pilha_Vazia()) {
            System.out.println("Pilha Vazia");
        } else {
            ElementoArvore Auxiliar = topo;
            System.out.print("[");
            while (Auxiliar.proximo_No != null) {
                System.out.println(Auxiliar.elemento_Arvore);
                Auxiliar = Auxiliar.proximo_No;
            }
            System.out.println(Auxiliar.elemento_Arvore + "]\n");
        }
    }
}

