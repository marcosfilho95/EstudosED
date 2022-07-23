public class Teste {
    public static void main(String[] args) {
        ArvoreBinaria arvoreteste = new ArvoreBinaria();

        arvoreteste.adicionar_Direita(1,3);
        arvoreteste.adicionar_Esquerda(2,1);
        arvoreteste.adicionar_Direita(4,1);
        arvoreteste.adicionar_Direita(3,4);
        arvoreteste.varredura_profundidadeRecursaoPreOrdem();
        arvoreteste.varredura_profundidadeRecursaoEmOrdem();
        arvoreteste.varredura_profundidadeRecursaoPosOrdem();
    }
}
