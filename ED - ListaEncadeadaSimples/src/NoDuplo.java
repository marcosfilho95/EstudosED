public class NoDuplo {
    // Nó do tipo inteiro
    int numero_armazenado;
    NoDuplo proximoNo;
    NoDuplo anteriorNo;

    public NoDuplo(int numeroInt){
        this.numero_armazenado = numeroInt;
        this.proximoNo = null;
        this.anteriorNo = null;
    }
}
