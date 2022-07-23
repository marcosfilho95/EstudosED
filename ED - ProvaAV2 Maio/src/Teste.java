public class Teste {
    public static void main(String[] args) {
        ListaEncadeadaSimplesFuncionario lista1 = new ListaEncadeadaSimplesFuncionario();
        lista1.Adicionar_Inicio(new Funcionario("Joao", 750));
        lista1.Adicionar_Inicio(new Funcionario("Marcos", 2000));
        lista1.Adicionar_Inicio(new Funcionario("Jordana", 1150));
        lista1.Adicionar_Inicio(new Funcionario("Maria",950));
        lista1.ordenarPorSalario();
    }
}
