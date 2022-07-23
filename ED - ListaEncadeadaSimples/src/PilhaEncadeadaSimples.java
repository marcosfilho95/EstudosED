public class PilhaEncadeadaSimples {
    // Pilha de Strings
    No topo;

    public PilhaEncadeadaSimples() {
        topo = null;
    }

    public boolean Lista_Vazia() {
        if (topo == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Empilhar_Pilha(String Dados) {
        No novoNo = new No(Dados);
        if (!Lista_Vazia()) {
            novoNo.proximo_no = topo;
            topo = novoNo;
        } else {
            topo = novoNo;
        }
    }
    public No Desempilhar_Pilha() {
        No removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Pilha Vazia");
        } else {
            removerNo = topo;
            topo = topo.proximo_no;
        }
        return removerNo;
    }
    public String Ver_Topo(){
        return topo.elemento_armazenado;
    }

    public void Ver_PilhaInvertendoPilha(){
        if(Lista_Vazia()){
            System.out.println("Pilha Vazia");
        }
        else {
            PilhaEncadeadaSimples pilhaAux = new PilhaEncadeadaSimples();
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
        if (Lista_Vazia()) {
            System.out.println("Pilha Vazia");
        } else {
            No Auxiliar = topo;
            System.out.print("[");
            while (Auxiliar.proximo_no != null) {
                System.out.println(Auxiliar.elemento_armazenado);
                Auxiliar = Auxiliar.proximo_no;
            }
            System.out.println(Auxiliar.elemento_armazenado + "]\n");
        }
    }
}
