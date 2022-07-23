public class NoArvore {
    int elemento_armazenado;
    NoArvore filho_esquerda;
    NoArvore filho_direita;

    public NoArvore(int valor){
        elemento_armazenado = valor;
        filho_esquerda = null;
        filho_direita = null;
    }
}
