public class FilaEncadeada {
        ElementoArvoreAVL inicioLista;

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

        public void enfileirar_Fila(NoArvoreAVL dados) {
            ElementoArvoreAVL novoNo = new ElementoArvoreAVL(dados);
            if (!fila_Vazia()) {
                novoNo.proximo_No = inicioLista;
                inicioLista = novoNo;
            } else {
                inicioLista = novoNo;
            }
        }

        public ElementoArvoreAVL desenfileirar_Fila() {
            ElementoArvoreAVL removerNo = null;
            if (fila_Vazia()) {
                System.out.println("Fila Vazia");
            } else {
                if (inicioLista.proximo_No != null) {
                    ElementoArvoreAVL Auxiliar;
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
