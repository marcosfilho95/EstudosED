public class NoFuncionario {
    // Nó do tipo Funcionarios
    Funcionario elemento_armazenado;
    NoFuncionario proximo_no;

    public NoFuncionario(Funcionario Dados) {
        this.elemento_armazenado = Dados;
        this.proximo_no = null;
    }

    public void getFuncionario () {
        elemento_armazenado.mostrarFuncionario();
    }
}
