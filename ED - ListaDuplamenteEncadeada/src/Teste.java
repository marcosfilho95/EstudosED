public class Teste {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada list1 = new ListaDuplamenteEncadeada();
        list1.Adicionar_Inicio(2);
        list1.Adicionar_Inicio(1);
        list1.Adicionar_Final(3);
        list1.Adicionar_Final(4);
        list1.Ver_Lista();
        System.out.println("Ver "+list1.Remover_Posicao(3).numero_armazenado);
        list1.Ver_Lista();
        list1.Remover_Meio();
        list1.Ver_Lista();
    }
}
