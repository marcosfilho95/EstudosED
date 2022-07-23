public class ListaEncadeadaCircular {
    // Lista de Pessoas
    No finalLista;
    No inicioLista;

    public ListaEncadeadaCircular() {
        finalLista = null;
    }

    public boolean Lista_Vazia() {
        if (finalLista == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Adicionar_Inicio(String Dados) {
        No novoNo = new No(Dados);
        if (!Lista_Vazia()) {
            novoNo.proximo_no = finalLista.proximo_no;
            finalLista.proximo_no = novoNo;
        } else {
            finalLista = novoNo;
            finalLista.proximo_no = novoNo;
        }
    }

    public void Adicionar_Final(String Dados) {
        No novoNo = new No(Dados);
        if (Lista_Vazia()) {
            finalLista = novoNo;
            finalLista.proximo_no = novoNo;
        } else {
            novoNo.proximo_no = finalLista.proximo_no;
            finalLista.proximo_no = novoNo;
            finalLista = novoNo;
        }
    }

    public No Remover_Inicio() {
        No removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else if (finalLista == finalLista.proximo_no) {
            removerNo = finalLista;
            finalLista = null;
        } else {
            removerNo = finalLista.proximo_no;
            finalLista.proximo_no = finalLista.proximo_no.proximo_no;
        }
        return removerNo;
    }

    public No Remover_Final() {
        No removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        }
        else if (finalLista == finalLista.proximo_no) {
            removerNo = finalLista;
            finalLista = null;
        }
        else {
            removerNo = finalLista;
            No auxiliar = finalLista.proximo_no;
            while (auxiliar.proximo_no != finalLista) {
                auxiliar = auxiliar.proximo_no;
            }
            auxiliar.proximo_no = finalLista.proximo_no;
            finalLista = auxiliar;
        }
        return removerNo;
    }

    public void Adicionar_Posicao(String Dados, int posicao) {
        if (Lista_Vazia() || posicao <= 1) {
            Adicionar_Inicio(Dados);
        }
        else {
            No novoNo = new No(Dados);
            No Auxiliar = finalLista.proximo_no;
            int i = 2; // nao funciona com um
            while (i < posicao && Auxiliar != finalLista) {
                System.out.println(i);
                Auxiliar = Auxiliar.proximo_no;
                i += 1;
            }
            if(Auxiliar == finalLista) {
                Adicionar_Final(Dados);
            }
            else {
                novoNo.proximo_no = Auxiliar.proximo_no;
                Auxiliar.proximo_no = novoNo;
            }
        }
    }

    public No Remover_Posicao(int posicao) {
        No noRemovido = null;
        if (Lista_Vazia() || posicao <= 1) {
            noRemovido = Remover_Inicio();
        } else {
            No Auxiliar;
            noRemovido = Auxiliar = finalLista.proximo_no;
            int i = 1;
            while (i < posicao && noRemovido != finalLista) {
                Auxiliar = noRemovido;
                noRemovido = noRemovido.proximo_no;
                i += 1;
            }
            if (noRemovido == finalLista) {
                noRemovido = Remover_Final();
            } else {
                Auxiliar.proximo_no = noRemovido.proximo_no;
            }
        }
        return noRemovido;
    }

    public void Ver_Lista() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            No Auxiliar = finalLista.proximo_no;
            System.out.print("[");
            while (Auxiliar != finalLista) {
                System.out.print(Auxiliar.elemento_armazenado + ", ");
                Auxiliar = Auxiliar.proximo_no;
            }
            System.out.println(Auxiliar.elemento_armazenado + "]");
        }
    }
}
