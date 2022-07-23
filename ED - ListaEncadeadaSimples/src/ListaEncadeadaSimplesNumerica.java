public class ListaEncadeadaSimplesNumerica {
    // Lista com Números
    NoNumerico inicioLista;
    public ListaEncadeadaSimplesNumerica(){
        inicioLista = null;
    }
    public boolean Lista_Vazia(){
        if(inicioLista == null){
            return true;
        }
        else{
            return false;
        }
    }
    public void Adicionar_Inicio(int Dados){
        NoNumerico novo_No = new NoNumerico(Dados);
        if(!Lista_Vazia()){
            novo_No.proximoNo = inicioLista;
            inicioLista = novo_No;
        }
        else{
            inicioLista = novo_No;
        }
    }
    public void Adicionar_Final(int Dados){
        NoNumerico novo_No = new NoNumerico (Dados);
        if(Lista_Vazia()){
            inicioLista = novo_No;
        }
        else{
            NoNumerico Auxiliar = inicioLista;
            while(Auxiliar.proximoNo != null){
                Auxiliar = Auxiliar.proximoNo;
            }
            Auxiliar.proximoNo = novo_No;
        }
    }
    public NoNumerico Remover_Inicio(){
        NoNumerico removerNo = null;
        if(Lista_Vazia()){
            System.out.println("Lista Vazia");
        }
        else{
            removerNo = inicioLista;
            inicioLista = inicioLista.proximoNo;
        }
        return removerNo;
    }
    public NoNumerico Remover_Final() {
        NoNumerico removerNo = null;
        if (Lista_Vazia()) {
            System.out.println("Lista Vazia");
        } else {
            NoNumerico Auxiliar;
            removerNo = Auxiliar = inicioLista;
            while (removerNo.proximoNo != null){
                Auxiliar = removerNo;
                removerNo = removerNo.proximoNo;
            }
            Auxiliar.proximoNo = null;
        }
        return removerNo;
    }
    public void Adicionar_Posicao(int Dados, int indice){
        if(Lista_Vazia() || indice<=1){
            Adicionar_Inicio(Dados);
        }
        else{
            NoNumerico novo_No = new NoNumerico(Dados);
            NoNumerico Auxiliar = inicioLista;
            int i = 2; // bug, se colocar 2 o código funciona. Método ta entrando no while e no else.
            while (i<indice && Auxiliar != null){
                Auxiliar = Auxiliar.proximoNo;
                i+=1;
            }
            if(Auxiliar == null){
                Adicionar_Final(Dados);
            }
            else{
                novo_No.proximoNo = Auxiliar.proximoNo;
                Auxiliar.proximoNo = novo_No;
            }
        }
    }
    public NoNumerico Remover_Posicao(int indice){
        NoNumerico noRemovido = null;
        if(Lista_Vazia() || indice <=1 ){
            noRemovido = Remover_Inicio();
        }
        else{
            NoNumerico Auxiliar;
            noRemovido = Auxiliar = inicioLista;
            int i = 1;
            while (i < indice && noRemovido != null){
                Auxiliar = noRemovido;
                noRemovido = noRemovido.proximoNo;
                i+=1;
            }
            if(noRemovido == null){
                noRemovido = Remover_Final();
            }
            else {
                Auxiliar.proximoNo = noRemovido.proximoNo;
            }
        }
        return noRemovido;
    }
    public void Ver_Lista(){
        if(Lista_Vazia()){
            System.out.println("Lista Vazia");
        }
        NoNumerico Auxiliar = inicioLista;
        System.out.print("["+Auxiliar.numero_armazenado+", ");
        Auxiliar = Auxiliar.proximoNo;
        while(Auxiliar.proximoNo != null){
            System.out.print(Auxiliar.numero_armazenado+", ");
            Auxiliar = Auxiliar.proximoNo;
        }
        System.out.println(Auxiliar.numero_armazenado+"]");
    }

    // Método inverter ordem da lista.
    public void inverterLista(){
       if(Lista_Vazia()){
           System.out.println("Lista Vazia");
        }
       else{
           ListaEncadeadaSimplesNumerica listaAux = new ListaEncadeadaSimplesNumerica();
           NoNumerico noAux = inicioLista;
           while (noAux != null){
            listaAux.Adicionar_Inicio(Remover_Inicio().numero_armazenado);
            noAux = noAux.proximoNo;
           }
           this.inicioLista = listaAux.inicioLista;
       }
    }
}
