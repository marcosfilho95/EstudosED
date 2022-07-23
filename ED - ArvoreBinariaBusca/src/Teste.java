public class Teste {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvorebuscateste = new ArvoreBinariaBusca();

        arvorebuscateste.adicionar_ElementoArvoreBusca(1);
        arvorebuscateste.adicionar_ElementoArvoreBusca(2);
        arvorebuscateste.adicionar_ElementoArvoreBusca(3);
        arvorebuscateste.adicionar_ElementoArvoreBusca(4);
        arvorebuscateste.varredura_Largura();
        arvorebuscateste.varredura_ProfundidadePreOrdem();
        arvorebuscateste.varredura_ProfundidadeEmOrdem();
        arvorebuscateste.varredura_ProfundidadePosOrdem();
    }
}
