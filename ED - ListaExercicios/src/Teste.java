public class Teste {

    public static void main(String[] args) {

        Lista lista = new Lista(5);
        lista.Adicionar_Inicio(4);
        lista.Adicionar_Inicio(12);
        lista.Adicionar_Final(4);
        lista.Adicionar_Posicao(22, 3);
        lista.Adicionar_Inicio(4);
        lista.Ver_Lista();
        lista.Excluir_RepetidorLista();
       // lista.Retornar_ElementoPosicao(4);
        lista.Ver_Lista();
        // lista = lista.inverterLista();
       // lista.Ver_Lista();
//        lista.Retornar_Meio();
    //    lista.Trocar_PrimeiroUltimo();

    }

    public Lista inverterLista(Lista lista) {
        if (lista.Lista_Vazia()) {
            System.out.println("Lista esta vazia");
            return lista;
        } else {
            Lista listAux = new Lista(lista.numero_elementos);
            int salvarNumeroElementos = lista.numero_elementos;
            int salvarPrimeiroElemento = 0;
            for (int i = 0; i < salvarNumeroElementos; i++) {
                salvarPrimeiroElemento = lista.Retornar_InicioLista();
                lista.Remover_Incio();
                listAux.Adicionar_Inicio(salvarPrimeiroElemento);
            }
            return listAux;
        }
    }
}
