public class ListaDuplamenteCadeada {
    // Lista com Números
    NoDuplo inicioLista;
    NoDuplo finalLista;

    public ListaDuplamenteCadeada() {
        finalLista = null;
        inicioLista = null;
    }

    public boolean Lista_Vazia() {
        if (inicioLista == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Adicionar_Inicio(int Dados) {
        NoDuplo novo_No = new NoDuplo(Dados);
        if (!Lista_Vazia()) {
            novo_No.proximoNo = inicioLista;
            inicioLista.anteriorNo = novo_No;
            inicioLista = novo_No;

        } else {
            inicioLista = novo_No;
            finalLista = inicioLista;
        }
    }

    public void Adicionar_Final(int Dados) {
        NoDuplo novo_No = new NoDuplo(Dados);
        if (Lista_Vazia()) {
            inicioLista = novo_No;
            finalLista = inicioLista;
        } else {
            finalLista.proximoNo = novo_No;
            novo_No.anteriorNo = finalLista;
            finalLista = novo_No;
        }
    }

    public NoDuplo Remover_Inicio() {
        NoDuplo removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else if (inicioLista == finalLista) {
            removerNo = inicioLista;
            inicioLista = null;
            finalLista = null;
        } else {
            removerNo = inicioLista;
            inicioLista = inicioLista.proximoNo;
            inicioLista.anteriorNo = null;
            /*inicioLista.proximoNo.anteriorNo = null;
            inicioLista = inicioLista.proximoNo;*/
            // logica mais dificil, porém funciona também
        }
        return removerNo;
    }

    public NoDuplo Remover_Final() {
        NoDuplo removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else if (inicioLista == finalLista) {
            removerNo = inicioLista;
            inicioLista = null;
            finalLista = null;
        } else {
            removerNo = finalLista;
            finalLista = finalLista.anteriorNo;
            finalLista.proximoNo = null;
            /*finalLista.anteriorNo.proximoNo = null;
            finalLista = finalLista.anteriorNo;*/
            // logica mais dificil, porém funciona também
        }
        return removerNo;
    }

    public void Adicionar_Posicao(int Dados, int indice) {
        if (Lista_Vazia() || indice <= 1) {
            Adicionar_Inicio(Dados);
        } else {
            NoDuplo novo_No = new NoDuplo(Dados);
            NoDuplo Auxiliar = inicioLista;
            int i = 1;
            while (i < indice && Auxiliar != null) {
                Auxiliar = Auxiliar.proximoNo;
                i += 1;
            }
            if (Auxiliar == null) {
                Adicionar_Final(Dados);
            } else {
                novo_No.proximoNo = Auxiliar;
                novo_No.anteriorNo = Auxiliar.anteriorNo;
                novo_No.anteriorNo.proximoNo = novo_No;
                novo_No.proximoNo.anteriorNo = novo_No;
            }
        }
    }

    public NoDuplo Remover_Posicao(int indice) {
        NoDuplo noRemovido = null;
        if (Lista_Vazia() || indice <= 1) {
            noRemovido = inicioLista;
            Remover_Inicio();
        } else {
            NoDuplo Auxiliar = inicioLista;
            int i = 1;
            while (i < indice && Auxiliar != null) {
                Auxiliar = Auxiliar.proximoNo;
                i += 1;
            }
            if (Auxiliar.proximoNo == null) {
                Remover_Final();
            } else {
                Auxiliar.anteriorNo.proximoNo = Auxiliar.proximoNo;
                Auxiliar.proximoNo.anteriorNo = Auxiliar.anteriorNo;
                noRemovido = Auxiliar;
            }
        }
        return noRemovido;
    }

    public void Ver_Lista() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            NoDuplo Auxiliar = inicioLista;
            System.out.print("[");
            while (Auxiliar.proximoNo != null) {
                System.out.print(Auxiliar.numero_armazenado + ", ");
                Auxiliar = Auxiliar.proximoNo;
            }
            System.out.println(Auxiliar.numero_armazenado + "]");
        }
    }

    public int Buscar_Elemento(int elementoBuscado) {
        if (Lista_Vazia()) {
            System.out.println("Lista vazia");
        } else {
            if (elementoBuscado == inicioLista.numero_armazenado) {
                System.out.println("Posição: " + "1.");
                return 1;
            }
            int indice = 1;
            NoDuplo Auxiliar = inicioLista;
            while (Auxiliar != null) {
                if (elementoBuscado == Auxiliar.numero_armazenado) {
                    System.out.println("Posição: " + indice);
                    return indice;
                }
                Auxiliar = Auxiliar.proximoNo;
                indice += 1;
            }
        }
        System.out.println("Elemento não encontrado.");
        return -1;
    }

    public void Remover_Meio() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            NoDuplo Auxiliar = inicioLista;
            int indice = 0;
            while (Auxiliar != null) {
                Auxiliar = Auxiliar.proximoNo;
                indice += 1;
            }
            if (indice % 2 == 0) {
                System.out.println("Lista não possui elemento do MEIO");
            } else {
                if (indice == 1) {
                    Remover_Posicao(indice);
                }
                Remover_Posicao((indice / 2) + 1);
            }
        }
    }

    public boolean Verificar_Repetidos() {
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            NoDuplo Auxiliar = inicioLista;
            while (Auxiliar.proximoNo != null) {
                NoDuplo Auxiliar2 = Auxiliar.proximoNo;
                while (Auxiliar2 != null) {
                    if (Auxiliar.numero_armazenado == Auxiliar2.numero_armazenado) {
                        System.out.println("Retornou verdadeiro");
                        return true;
                    }
                    Auxiliar2 = Auxiliar2.proximoNo;
                }
                Auxiliar = Auxiliar.proximoNo;
            }
            System.out.println("Retornou falso");
        }
        return false;
    }

    public void Verificar_ElementoMaisRepetido() {
        if (Verificar_Repetidos()) {
            String elementoRepetido = "";
            int quantidadeRepeticoes = 0;
            NoDuplo Auxiliar = inicioLista;
            while (Auxiliar.proximoNo != null) {
                NoDuplo Auxiliar2 = Auxiliar.proximoNo;
                int contador = 0;
                while (Auxiliar2 != null) {
                    if (Auxiliar.numero_armazenado == Auxiliar2.numero_armazenado) {
                        contador += 1;
                    }
                    Auxiliar2 = Auxiliar2.proximoNo;
                }
                if (contador > quantidadeRepeticoes) {
                    elementoRepetido = ""+Auxiliar.numero_armazenado;
                    quantidadeRepeticoes = contador;
                }
                else if(contador == quantidadeRepeticoes){
                    elementoRepetido+=" e "+Auxiliar.numero_armazenado;
                }
                Auxiliar = Auxiliar.proximoNo;
            }
            System.out.println("Elemento(s) mais repetido(s): "+"'"+elementoRepetido+"'"+" se repete(m) "+quantidadeRepeticoes+" vez(es).");
        }
    }
    public void Inverter_Lista(){
        if(Lista_Vazia()){
            System.out.println("Lista Vazia");
        }
        else{
            ListaDuplamenteCadeada listaAux = new ListaDuplamenteCadeada();
            while (inicioLista != null){
                listaAux.Adicionar_Inicio(Remover_Inicio().numero_armazenado);
            }
            inicioLista = listaAux.inicioLista;
        }
    }
}
