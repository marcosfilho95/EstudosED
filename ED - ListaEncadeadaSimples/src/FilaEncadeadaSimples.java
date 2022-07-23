public class FilaEncadeadaSimples {
    // Fila de Strings
    No inicioLista;

    public FilaEncadeadaSimples() {
        inicioLista = null;
    }

    public boolean Lista_Vazia() {
        if (inicioLista == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enfileirar_Fila(String Dados) {
        No novoNo = new No(Dados);
        if (!Lista_Vazia()) {
            novoNo.proximo_no = inicioLista;
            inicioLista = novoNo;
        } else {
            inicioLista = novoNo;
        }
    }

    public No desenfileirar_Fila() {
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

    public void Ver_Fila() {
        if (Lista_Vazia()) {
            System.out.println("Fila Vazia");
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
