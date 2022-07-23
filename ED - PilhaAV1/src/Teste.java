public class Teste {
    public static void main(String[] args) {
        Pilha pilha1 = new Pilha(4);
        pilha1.Empilhar_Pilha(23);
        pilha1.Empilhar_Pilha(5);
        pilha1.Empilhar_Pilha(2);
        pilha1.Empilhar_Pilha(1);
        pilha1.verPilha();
        pilha1 = pilha1.ordenarPilha();
        pilha1.verPilha();

    }
}
