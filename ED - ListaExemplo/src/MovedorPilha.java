public class MovedorPilha {
    Pilha pilhaux;
    Pilha pilhaux2;

    public void RetornarMaiorMenorSoma(Pilha pilha){
        pilhaux2 = pilha;
        pilhaux = new Pilha(pilha.topo);
        int maior, menor, soma;
        soma = 0;
        maior = pilhaux2.Ver_Topo();
        menor = pilhaux2.Ver_Topo();
        int contador = 0;
        int elementoSalvo;
        int contadorAux = pilhaux2.topo;
        System.out.println("\n pilhaux2 \n");
        while (contador < contadorAux){
            if(pilhaux2.Ver_Topo() > maior){
                maior = pilhaux2.Ver_Topo();
            }
            if (pilhaux2.Ver_Topo() < menor ){
                menor = pilhaux2.Ver_Topo();
            }
            soma+= pilhaux2.Ver_Topo();
            contador++;
            elementoSalvo=pilhaux2.Ver_Topo();
            pilhaux2.Desempilhar_Pilha();
            pilhaux.Empilhar_Pilha(elementoSalvo);
            System.out.println(elementoSalvo);
        }
        System.out.println("\n valores \n");
        System.out.println("Maior elemento: "+maior);
        System.out.println("Maior elemento: "+menor);
        System.out.println("Maior elemento: "+soma);
        contador = 0;
        System.out.println("\n invertida \n");
        while (contador < contadorAux){
            elementoSalvo = pilhaux.Ver_Topo();
            pilhaux.Desempilhar_Pilha();
            pilhaux2.Empilhar_Pilha(elementoSalvo);
            System.out.println(elementoSalvo);
            contador++;
        }
    }
    }

