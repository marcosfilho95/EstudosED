public class Teste {
    public static void main(String[] args) {
        ListaEncadeadaCircular lista = new ListaEncadeadaCircular();
        lista.Adicionar_Inicio("Um");
        lista.Adicionar_Final("Dois");
        lista.Ver_Lista();
        lista.Remover_Inicio();
        lista.Ver_Lista();
        lista.Remover_Final();
        lista.Ver_Lista();
    }
}
