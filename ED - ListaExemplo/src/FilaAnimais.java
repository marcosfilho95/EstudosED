import java.util.Arrays;

public class FilaAnimais {

        int num_elementos;
        Animal vetor_elementos[];

        public FilaAnimais(int tamanho) {
            this.num_elementos = 0;
            this.vetor_elementos = new Animal[tamanho];
        }

        public int Quantidade(){
            return this.num_elementos;
        }

        public boolean Fila_Vazia(){
            if(num_elementos == 0){
                return true;
            }
            else {
                return false;
            }
        }
        public boolean Fila_Cheia(){
            if(num_elementos >= vetor_elementos.length){
                return true;
            }
            else{
                return false;
            }
        }
        public void Enfileirar_Animais(Animal animal) {
            if (Fila_Cheia()){
                System.out.println("Fila Cheia");
            }
            else {
                int indice = num_elementos;
                vetor_elementos[num_elementos] = animal;
                num_elementos = num_elementos+1;
                System.out.println("Elemento adicionado na fila: "+animal.especie_animal);

            }
        }
        public void Desenfileirar_Animais() {
            if (Fila_Vazia()) {
                System.out.println("Fila Vazia");
            } else {
                String elemento_removido = vetor_elementos[num_elementos-1].especie_animal;
                vetor_elementos[num_elementos - 1] = null;
                num_elementos -= 1;
                System.out.println("Elemento removido da fila: " + elemento_removido);
            }
        }

    public void Desenfileirar_Cao(){
        if (Fila_Vazia()){
            System.out.println("Fila Vazia");
        }
        else {
            while ( true ){
                if(vetor_elementos[num_elementos-1].especie_animal.equals("Cao")){
                    Desenfileirar_Animais();
                    break;
                }
                else{
                    Animal ultimo_animal = vetor_elementos[num_elementos-1];
                    Desenfileirar_Animais();
                    Enfileirar_Animais(new Animal(ultimo_animal.especie_animal, ultimo_animal.raça_animal, ultimo_animal.estado_saude,ultimo_animal.nome_animal));
                    break;
                }
            }
        }
    }
        public void Ver_Animais(){
            for(int i = 0; i < num_elementos; i++) {
                if(i == 0){
                    System.out.print("["+vetor_elementos[i].especie_animal+", ");
                }
                else if(i == num_elementos-1){
                    System.out.println(vetor_elementos[i].especie_animal+"]");
                }
                else{
                    System.out.print(vetor_elementos[i].especie_animal + ", ");
                }

            }
        }

    @Override
    public String toString() {
        return "FilaAnimais{" +
                "num_elementos=" + num_elementos +
                ", vetor_elementos=" + Arrays.toString(vetor_elementos) +
                '}';
    }
}

