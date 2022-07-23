public class Animal {
    String especie_animal;
    String raça_animal;
    String estado_saude;
    String nome_animal;

    public Animal(String especie_animal, String raça_animal, String estado_saude, String nome_animal) {
        this.especie_animal = especie_animal;
        this.raça_animal = raça_animal;
        this.estado_saude = estado_saude;
        this.nome_animal = nome_animal;
    }


    public String getEspecie_animal() {
        return especie_animal;
    }

    public String getRaça_animal() {
        return raça_animal;
    }

    public String getEstado_saude() {
        return estado_saude;
    }

    public String getNome_animal() {
        return nome_animal;
    }

}
