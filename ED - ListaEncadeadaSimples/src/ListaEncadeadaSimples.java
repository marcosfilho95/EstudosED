public class ListaEncadeadaSimples {
    // Lista de Strings
    No inicioLista;

    public ListaEncadeadaSimples() {
        inicioLista = null;
    }

    public boolean Lista_Vazia() {
        if (inicioLista == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Adicionar_Inicio(String Dados) {
        No novoNo = new No(Dados);
        if (!Lista_Vazia()) {
            novoNo.proximo_no = inicioLista;
            inicioLista = novoNo;
        } else {
            inicioLista = novoNo;
        }
    }

    public void Adicionar_Final(String Dados) {
        No novoNo = new No(Dados);
        if (Lista_Vazia()) {
            inicioLista = novoNo;
        } else {
            No Auxiliar = inicioLista;
            while (Auxiliar.proximo_no != null) {
                Auxiliar = Auxiliar.proximo_no;
            }
            Auxiliar.proximo_no = novoNo;
        }
    }

    public No Remover_Inicio() {
        No removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            removerNo = inicioLista;
            inicioLista = inicioLista.proximo_no;
        }
        return removerNo;
    }

    public No Remover_Final() {
        No removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Fila Vazia");
        } else {
            if (inicioLista.proximo_no != null) {
                No Auxiliar;
                removerNo = Auxiliar = inicioLista;
                while (removerNo.proximo_no != null) {
                    Auxiliar = removerNo;
                    removerNo = removerNo.proximo_no;
                }
                Auxiliar.proximo_no = null;
            } else {
                removerNo = inicioLista;
                inicioLista = null;
            }
        }
        return removerNo;
    }

    public void Adicionar_Posicao(String Dados, int indice) {
        if (Lista_Vazia() || indice <= 1) {
            Adicionar_Inicio(Dados);
        } else {
            No novoNo = new No(Dados);
            No Auxiliar = inicioLista;
            int i = 2; // bug, se colocar 2 o código funciona. Método ta entrando no while e no else.
            while (i < indice && Auxiliar != null) {
                Auxiliar = Auxiliar.proximo_no;
                i += 1;
            }
            if (Auxiliar == null) {
                Adicionar_Final(Dados);
            } else {
                novoNo.proximo_no = Auxiliar.proximo_no;
                Auxiliar.proximo_no = novoNo;
            }
        }
    }

    public No Remover_Posicao(int indice) {
        No noRemovido = null;
        if (Lista_Vazia() || indice <= 1) {
            noRemovido = Remover_Inicio();
        } else {
            No Auxiliar;
            noRemovido = Auxiliar = inicioLista;
            int i = 1;
            while (i < indice && noRemovido != null) {
                Auxiliar = noRemovido;
                noRemovido = noRemovido.proximo_no;
                i += 1;
            }
            if (noRemovido == null) {
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
            No Auxiliar = inicioLista;
            System.out.print("[");
            while (Auxiliar.proximo_no != null) {
                System.out.print(Auxiliar.elemento_armazenado + ", ");
                Auxiliar = Auxiliar.proximo_no;
            }
            System.out.println(Auxiliar.elemento_armazenado + "]");
        }
    }
}
