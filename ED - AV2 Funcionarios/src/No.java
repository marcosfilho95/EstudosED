public class No {
    // Nó do tipo Funcionarios
    Funcionario elemento_armazenado;
    No proximo_no;

    public No(Funcionario Dados) {
        this.elemento_armazenado = Dados;
        this.proximo_no = null;
    }

    public void getFuncionario () {
        elemento_armazenado.mostrarFuncionario();
    }
}