public class ListaEncadeada {
    ElementoArvore inicioLista;

    public ListaEncadeada() {
        inicioLista = null;
    }

    public boolean Lista_Vazia() {
        if (inicioLista == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Adicionar_Inicio(NoArvore dados) {
        ElementoArvore novoNo = new ElementoArvore(dados);
        if (Lista_Vazia()) {
            inicioLista = novoNo;
        } else {
            novoNo.proximo_No = inicioLista;
            inicioLista = novoNo;
        }
    }

    public void Adicionar_Final(NoArvore dados) {
        ElementoArvore novoNo = new ElementoArvore(dados);
        if (Lista_Vazia()) {
            inicioLista = novoNo;
        } else {
            ElementoArvore noAuxiliar = inicioLista;
            while (noAuxiliar.proximo_No != null) {
                noAuxiliar = noAuxiliar.proximo_No;
            }
            noAuxiliar.proximo_No = novoNo;
        }
    }

    public void Ver_Lista() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            ElementoArvore Auxiliar = inicioLista;
            System.out.print("[");
            while (Auxiliar.proximo_No != null) {
                System.out.print(Auxiliar.elemento_Arvore.elemento_armazenado + ", ");
                Auxiliar = Auxiliar.proximo_No;
            }
            System.out.println(Auxiliar.elemento_Arvore.elemento_armazenado + "]");
        }
    }

    public boolean buscarElemento(NoArvore elemento) {
        ElementoArvore noAux = inicioLista;
        while (noAux != null) {
            if(elemento.elemento_armazenado == noAux.elemento_Arvore.elemento_armazenado) {
                return true;
            }
            noAux = noAux.proximo_No;
        }
        return false;
    }
}
