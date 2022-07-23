import sun.awt.geom.AreaOp;

import java.util.ArrayList;

public class TesteLista {

    public static void main(String[] args) {

//       Lista mylist = new Lista(5);
//        mylist.Adicionar_Inicio(5);
//        mylist.Adicionar_Posicao(6,2);
//        mylist.Adicionar_Final(7);
//        mylist.Adicionar_Inicio(7);
//        mylist.Adicionar_Inicio(7);
//        mylist.Excluir_RepetidorLista();
//        mylist.Ver_Lista();
//       Fila filinha = new Fila((3));


      Pilha pilhaa = new Pilha(5);
      MovedorPilha movedor = new MovedorPilha();
       pilhaa.Empilhar_Pilha(1);
       pilhaa.Empilhar_Pilha(2);
       pilhaa.Empilhar_Pilha(8);
       pilhaa.Empilhar_Pilha(78);
       movedor.RetornarMaiorMenorSoma(pilhaa);
//        Animal animal1 = new Animal("Cao", "Westie", "bom","Snow");
//        Animal animal2 = new Animal("Gato","Persa","bom","Garfield");
//        Animal animal3 = new Animal("Gato","Pe Duro","indefinido","Pedrim");
//        Animal animal4 = new Animal("Cao","Shitzu","ruim","Pi");

//       FilaAnimais Animal = new FilaAnimais(4);
//       Animal.Enfileirar_Animais(new Animal("Cao", "Westie", "bom","Snow"));
//       Animal.Enfileirar_Animais(new Animal("Gato","Persa","bom","Garfield"));
//       Animal.Enfileirar_Animais(new Animal("Gato","Pe Duro","indefinido","Pedrim"));
//        Animal.Enfileirar_Animais(new Animal("Cao","Shitzu","ruim","Pi"));
//
//          Animal.Ver_Animais();
//          Animal.Desenfileirar_Animais();
//          Animal.Ver_Animais();
//          Animal.Desenfileirar_Cao();
//          Animal.Ver_Animais();

        /* Fila fila = new Fila(3);
         fila.Enfileirar_Fila(33);
         fila.Ver_Fila();
         fila.Enfileirar_Fila(45);
         fila.Ver_Fila();
         fila.Enfileirar_Fila(77);
         fila.Ver_Fila();
         fila.Retornar_inicioFila();
         fila.Retornar_finalFila();
         fila.Retornar_MaiorMenorSoma();
         fila.Ver_Fila();*/


    }
}
