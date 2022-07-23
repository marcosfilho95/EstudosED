public class FilaEncadeada {
    ElementoArvore inicioLista;

    public FilaEncadeada() {
        inicioLista = null;
    }

    public boolean fila_Vazia() {
        if (inicioLista == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enfileirar_Fila(NoArvore dados) {
        ElementoArvore novoNo = new ElementoArvore(dados);
        if (!fila_Vazia()) {
            novoNo.proximo_No = inicioLista;
            inicioLista = novoNo;
        } else {
            inicioLista = novoNo;
        }
    }

    public ElementoArvore desenfileirar_Fila() {
        ElementoArvore removerNo = null;
        if (fila_Vazia()) {
            System.out.println("Fila Vazia");
        } else {
            if (inicioLista.proximo_No != null) {
                ElementoArvore Auxiliar;
                removerNo = Auxiliar = inicioLista;
                while (removerNo.proximo_No != null) {
                    Auxiliar = removerNo;
                    removerNo = removerNo.proximo_No;
                }
                Auxiliar.proximo_No = null;
            } else {
                removerNo = inicioLista;
                inicioLista = null;
            }
        }
        return removerNo;
    }
}
