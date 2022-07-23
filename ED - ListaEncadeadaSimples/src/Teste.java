public class Teste {
    public static void main(String[] args) {
        ListaDuplamenteCadeada list1 = new ListaDuplamenteCadeada();
        list1.Adicionar_Inicio(2);
        list1.Adicionar_Inicio(1);
        list1.Adicionar_Final(3);
        list1.Adicionar_Final(4);
        list1.Ver_Lista();
        System.out.println("Ver " + list1.Remover_Posicao(3).numero_armazenado);
        list1.Ver_Lista();
        ListaEncadeadaSimples lista2 = new ListaEncadeadaSimples();
        lista2.Adicionar_Inicio("");
        lista2.Ver_Lista();
    }
}
