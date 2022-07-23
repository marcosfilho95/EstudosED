import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int Prioridade(char caracteres) {
        switch (caracteres) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infixoParaPosfixo(String expressao) {
        String resultado = new String("");

        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i<expressao.length(); ++i) {
            char caracteres = expressao.charAt(i);

            if (Character.isLetterOrDigit(caracteres))
                resultado += caracteres;

            else if (caracteres == '(')
                pilha.push(caracteres);

            else if (caracteres == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(')
                    resultado += pilha.pop();
                    pilha.pop();
            }
            else {
                while (!pilha.isEmpty() && Prioridade(caracteres) <= Prioridade(pilha.peek())){
                    resultado += pilha.pop();
                }
                pilha.push(caracteres);
            }
        }
        while (!pilha.isEmpty()){
            if(pilha.peek() == '(')
                return "Expressao Invalida";
            resultado += pilha.pop();
        }
        return resultado;
    }
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String n = leia.nextLine();
        String[] expressoes = new String[Integer.parseInt(n)];
        for (int i = 0; i < Integer.parseInt(n); i++) {
            expressoes[i] = leia.nextLine();
       }
        for (int i = 0; i < Integer.parseInt(n); i++) {
            System.out.println(infixoParaPosfixo(expressoes[i]));
        }
    }
}
