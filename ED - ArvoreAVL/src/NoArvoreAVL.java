public class NoArvoreAVL {
    int elemento_armazenado;
    int altura;
    NoArvoreAVL filho_esquerda;
    NoArvoreAVL filho_direita;

    public NoArvoreAVL(int valor){
        elemento_armazenado = valor;
        filho_esquerda = null;
        filho_direita = null;
        altura = 0;
    }

    public NoArvoreAVL (int valor, NoArvoreAVL filho_esquerda, NoArvoreAVL filho_direita){
        elemento_armazenado = valor;
        this.filho_direita = filho_direita;
        this.filho_esquerda = filho_esquerda;
        altura = 0;
    }
}
