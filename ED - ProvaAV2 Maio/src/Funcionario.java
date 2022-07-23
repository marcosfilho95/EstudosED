public class Funcionario {
    String nomeFuncionario;
    double salarioBruto;
    double salarioLiquido;
    double impostoAPagar;

    public Funcionario(String nomeFuncionario, int salarioFuncionario){
        this.nomeFuncionario = nomeFuncionario;
        this.salarioBruto = salarioFuncionario;
        calcularImposto();
    }

    public void calcularImposto(){
        if(salarioBruto <= 850){
            impostoAPagar = 0;
        }
        else if(salarioBruto >= 850 && salarioBruto <= 1200){
            impostoAPagar = salarioBruto*0.1;
        }
        else{
            impostoAPagar = salarioBruto*0.2;
        }
        salarioLiquido = salarioBruto - impostoAPagar;
    }

    public void mostrarFuncionario(){
        System.out.println("Nome do Funcionario: " +nomeFuncionario);
        System.out.println("Imposto a pagar (em reais): "+impostoAPagar);
        System.out.println("Valor do salario (em reais) líquidos a receber: "+salarioLiquido);
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public double getImpostoAPagar() {
        return impostoAPagar;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nomeFuncionario='" + nomeFuncionario + '\'' +
                ", impostoAPagar=" + impostoAPagar +
                ", salarioLiquido=" + salarioLiquido +
                '}';
    }
}
